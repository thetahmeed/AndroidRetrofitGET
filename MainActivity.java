package com.tahmeedul.retrofitjustajson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = findViewById(R.id.mTitle);


        // 1. Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 2. Retrofit client
        RetroInterface retroInterface = retrofit.create(RetroInterface.class);

        // 3. Call
        Call<List<MyModel>> call = retroInterface.getData(7);

        // 4. CallBack
        call.enqueue(new Callback<List<MyModel>>() {
            @Override
            public void onResponse(Call<List<MyModel>> call, Response<List<MyModel>> response) {
                if (response.isSuccessful()){
                    List<MyModel> list = response.body();
                    for (MyModel myModel : list){
                        mTitle.append(
                                myModel.getId()+"\n"
                                        +myModel.getEmail()+"\n"
                                        +myModel.getUserName()
                                        +"\n\n");
                    }

                }else {
                    mTitle.setText("Error Code: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<List<MyModel>> call, Throwable t) {
                mTitle.setText("Response Error: "+t.getMessage());
            }
        });

    }
}

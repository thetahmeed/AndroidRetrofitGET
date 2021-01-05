# AndroidRetrofitGET
// basics use of GET method by Retrofit


//  Library used (Don't forget about taking internet permisssion)

//  implementation 'com.squareup.retrofit2:retrofit:2.9.0'
//  implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

// In case of this error:
CLEARTEXT communication to api.openweathermap.org not permitted by network security policy. Error to get data from api.openweathermap.org.
Solved: Manifest.xml >  inside "application" tag > add "android:usesCleartextTraffic="true""


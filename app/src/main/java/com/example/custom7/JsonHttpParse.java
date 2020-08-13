package com.example.custom7;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class JsonHttpParse {

    String FinalHttpData = "";
    String Result ;
    BufferedWriter bufferedWriter ;
    OutputStream outputStream ;
    BufferedReader bufferedReader ;
    StringBuilder stringBuilder = new StringBuilder();
    URL url;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String postRequest(String method, String Email,String Password, String HttpUrlHolder) {

        try {
            url = new URL(HttpUrlHolder);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setReadTimeout(14000);

            httpURLConnection.setConnectTimeout(14000);

            httpURLConnection.setRequestMethod("POST");

            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");

            httpURLConnection.setRequestProperty("Accept", "application/json");

            String jsonInputString="{\"method\":\"login\",\"customer_email\":\"aman123@gmail.com\",\"customer_password\":\"aman@123\"}";

           // String jsonInputString="{\"method\":\"login\",\"customer_email\":\"aman123@gmail.com\",\"customer_password\":\"aman@123\"}";

            httpURLConnection.setDoInput(true);

            httpURLConnection.setDoOutput(true);

            try(OutputStream os = httpURLConnection.getOutputStream()){
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }


            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                FinalHttpData=response.toString();
                System.out.println(response.toString());
            }




//            outputStream = httpURLConnection.getOutputStream();
//
//            bufferedWriter = new BufferedWriter(
//
//                    new OutputStreamWriter(outputStream, "UTF-8"));
//
//            bufferedWriter.write(FinalDataParse(Data));
//
//            bufferedWriter.flush();
//
//            bufferedWriter.close();
//
//            outputStream.close();
//
//            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//
//                bufferedReader = new BufferedReader(
//                        new InputStreamReader(
//                                httpURLConnection.getInputStream()
//                        )
//                );
//                FinalHttpData = bufferedReader.readLine();
//            }
//            else {
//                FinalHttpData = "Something Went Wrong";
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return FinalHttpData;
    }

//    public String FinalDataParse(HashMap<String,String> hashMap2) throws UnsupportedEncodingException {
//
//        for(Map.Entry<String,String> map_entry : hashMap2.entrySet()){
//
//            stringBuilder.append("&");
//
//            stringBuilder.append(URLEncoder.encode(map_entry.getKey(), "UTF-8"));
//
//            stringBuilder.append("=");
//
//            stringBuilder.append(URLEncoder.encode(map_entry.getValue(), "UTF-8"));
//
//        }
//
//        Result = stringBuilder.toString();
//
//        return Result ;
//    }

}
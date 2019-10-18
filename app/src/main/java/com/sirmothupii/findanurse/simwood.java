package com.sirmothupii.findanurse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.TreeMap;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class simwood
{

    //String message =  {"to\":\"27623216594\", \"from\":\"447537149235\", \"message\":\"Hey, what's up"};

    //public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    //OkHttpClient client = new OkHttpClient();
    private TreeMap<String, String> hashMap;

   /** public simwood() throws IOException
    {

    }*/

    void post(String url, String json) throws IOException {

        OkHttpClient client = new OkHttpClient();


        // RequestBody body = RequestBody.create(JSON, json);
        RequestBody body = new FormBody.Builder()
                //.setType(MultipartBody.FORM)
                .add("to", "27623216594")
                .add("from", "447537149235")
                .add("message", "Hey, what's up")
                .build();


        Request request = new Request.Builder()
                .url("https://api.simwood.com/v3/messaging/931236/sms")
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();

            JSONArray array = new JSONArray(response.body().string());
            JSONObject object = array.getJSONObject(0);

            hashMap.put("msg", object.getString("msgtype"));
            hashMap.put("msg", object.getString("msg"));
            // Do something with the response.
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        /**String message;
        String response = post("https://api.simwood.com/v3/messaging/931236/sms", message);*/
    }
}

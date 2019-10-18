package com.sirmothupii.findanurse;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.internal.framed.Header;

public class simwoodRest {

    public void getPublicTimeline() throws JSONException {
        RequestParams rp = new RequestParams();
        rp.add("to", "27623216594");
        rp.add("from", "447537149235");
        rp.add("message","Hi...");

        HttpUtils.post("https://api.simwood.com/v3/messaging/931236/sms", rp, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
            }});



    }
}

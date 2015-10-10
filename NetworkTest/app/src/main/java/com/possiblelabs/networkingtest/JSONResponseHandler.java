package com.possiblelabs.networkingtest;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by possiblelabs on 7/20/15.
 */
public class JSONResponseHandler implements ResponseHandler<List<String>> {

    private static final String LONGITUDE_TAG = "lng";
    private static final String LATITUDE_TAG = "lat";
    private static final String MAGNITUDE_TAG = "magnitude";
    private static final String EARTHQUAKE_TAG = "earthquakes";

    @Override
    public List<String> handleResponse(HttpResponse response) throws IOException {
        List<String> result = new ArrayList<String>();
        String JSONResponse = new BasicResponseHandler().handleResponse(response);

        try {

            JSONObject responseObject = (JSONObject) new JSONTokener(JSONResponse).nextValue();

            JSONArray earthquakes = responseObject.getJSONArray(EARTHQUAKE_TAG);

            for (int idx = 0; idx < earthquakes.length(); idx++) {
                JSONObject earthquake = (JSONObject) earthquakes.get(idx);
                double magnitude = earthquake.getDouble(MAGNITUDE_TAG);
                double latitude = earthquake.getDouble(LATITUDE_TAG);
                double longitude = earthquake.getDouble(LONGITUDE_TAG);

                result.add(MAGNITUDE_TAG + ":" + magnitude + ","
                        + LATITUDE_TAG + ":" + latitude + ","
                        + LONGITUDE_TAG + ":" + longitude);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}

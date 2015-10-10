package com.possiblelabs.networkingtest;

import android.app.ListActivity;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.List;

/**
 * Created by possiblelabs on 7/20/15.
 */
public class EarthQuakesList extends ListActivity {

    private String parsingType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parsingType = getIntent().getStringExtra("TYPE");
        new LoadEarthQuakes().execute();
    }

    private class LoadEarthQuakes extends AsyncTask<Void, Void, List<String>> {

        //CREAR CUENTA => http://www.geonames.org/login
        private static final String URL_JSON = "http://api.geonames.org/earthquakesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&username=tive";
        private static final String URL_XML = "http://api.geonames.org/earthquakesXML?north=44.1&south=-9.9&east=-22.4&west=55.2&username=tive";


        AndroidHttpClient mClient = AndroidHttpClient.newInstance("");

        @Override
        protected List<String> doInBackground(Void... params) {
            if ("XML".equalsIgnoreCase(parsingType)) {
                return loadFromXML();
            } else {
                return loadFromJSON();
            }
        }

        private List<String> loadFromJSON() {
            HttpGet request = new HttpGet(URL_JSON);
            JSONResponseHandler responseHandler = new JSONResponseHandler();
            try {
                return mClient.execute(request, responseHandler);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private List<String> loadFromXML() {
            HttpGet request = new HttpGet(URL_XML);
            XMLResponseHandler responseHandler = new XMLResponseHandler();
            try {
                return mClient.execute(request, responseHandler);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<String> result) {
            if (null != mClient)
                mClient.close();

            setListAdapter(new ArrayAdapter<String>(EarthQuakesList.this, R.layout.list_item, result));
        }
    }

}

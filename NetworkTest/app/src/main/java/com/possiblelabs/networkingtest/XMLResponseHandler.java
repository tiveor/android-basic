package com.possiblelabs.networkingtest;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by possiblelabs on 7/20/15.
 */
class XMLResponseHandler implements ResponseHandler<List<EarthQuake>> {

    private static final String MAGNITUDE_TAG = "magnitude";
    private static final String LONGITUDE_TAG = "lng";
    private static final String LATITUDE_TAG = "lat";
    private String mLat, mLng, mMag;
    private boolean mIsParsingLat, mIsParsingLng, mIsParsingMag;
    private final List<EarthQuake> mResults = new ArrayList<EarthQuake>();

    @Override
    public List<EarthQuake> handleResponse(HttpResponse response) throws IOException {
        try {

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(new InputStreamReader(response.getEntity().getContent()));

            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG) {
                    startTag(xpp.getName());
                } else if (eventType == XmlPullParser.END_TAG) {
                    endTag(xpp.getName());
                } else if (eventType == XmlPullParser.TEXT) {
                    text(xpp.getText());
                }
                eventType = xpp.next();
            }
            return mResults;
        } catch (XmlPullParserException e) {
        }
        return null;
    }

    public void startTag(String localName) {
        if (localName.equals(LATITUDE_TAG)) {
            mIsParsingLat = true;
        } else if (localName.equals(LONGITUDE_TAG)) {
            mIsParsingLng = true;
        } else if (localName.equals(MAGNITUDE_TAG)) {
            mIsParsingMag = true;
        }
    }

    public void text(String text) {
        if (mIsParsingLat) {
            mLat = text.trim();
        } else if (mIsParsingLng) {
            mLng = text.trim();
        } else if (mIsParsingMag) {
            mMag = text.trim();
        }
    }

    public void endTag(String localName) {
        if (localName.equals(LATITUDE_TAG)) {
            mIsParsingLat = false;
        } else if (localName.equals(LONGITUDE_TAG)) {
            mIsParsingLng = false;
        } else if (localName.equals(MAGNITUDE_TAG)) {
            mIsParsingMag = false;
        } else if (localName.equals("earthquake")) {
            EarthQuake earthQuake = new EarthQuake(Double.valueOf(mMag), Double.valueOf(mLat), Double.valueOf(mLng));
            mResults.add(earthQuake);
            mLat = null;
            mLng = null;
            mMag = null;
        }
    }
}

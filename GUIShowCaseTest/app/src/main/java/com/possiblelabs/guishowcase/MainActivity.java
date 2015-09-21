package com.possiblelabs.guishowcase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by possiblelas on 7/3/15.
 */
public class MainActivity extends Activity {

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
    }

    private void startActivity(Class x) {
        Intent intent = new Intent(this, x);
        startActivity(intent);
    }

    public void loadAlertDialogActivity(View view) {
        startActivity(AlertDialogActivity.class);
    }

    public void loadAutoCompleteActivity(View view) {
        startActivity(AutoCompleteActivity.class);
    }

    public void loadButtonActivity(View view) {
        startActivity(ButtonActivity.class);
    }

    public void loadCheckboxActivity(View view) {
        startActivity(CheckboxActivity.class);
    }

    public void loadDatePickerActivity(View view) {
        startActivity(DatePickerActivity.class);
    }

    public void loadGalleryActivity(View view) {
        startActivity(GalleryActivity.class);
    }

    public void loadListViewActivity(View view) {
        startActivity(ListViewActivity.class);
    }

    public void loadRadioButtonActivity(View view) {
        startActivity(RadioButtonActivity.class);
    }

    public void loadRatingsBarActivity(View view) {
        startActivity(RatingsBarActivity.class);
    }

    public void loadSpinnerActivity(View view) {
        startActivity(SpinnerActivity.class);
    }

    public void loadTextViewActivity(View view) {
        startActivity(TextViewActivity.class);
    }

    public void loadTimePickerActivity(View view) {
        startActivity(TimePickerActivity.class);
    }

    public void loadToggleButtonActivity(View view) {
        startActivity(ToggleButtonActivity.class);
    }

    public void loadViewPagerActivity(View view) {
        startActivity(ViewPagerActivity.class);
    }

    public void loadWebViewActivity(View view) {
        startActivity(WebViewActivity.class);
    }
}

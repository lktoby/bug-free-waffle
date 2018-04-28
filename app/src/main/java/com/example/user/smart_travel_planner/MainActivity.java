package com.example.user.smart_travel_planner;

import android.app.ActionBar;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.nfc.Tag;
import android.os.Build;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.Locale;

import com.example.user.smart_travel_planner.LanguageSelectActivity;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public static final String filename = "file_lang";
    public static final String keylang = "key_lang";

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadlanguage();
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
    }

    public boolean onlanguageselected(View view){
        switch (view.getId()) {
            case R.id.languageoption_eng:
                savelangauge("en");
                break;
            case R.id.languageoption_chi:
                savelangauge("zh-rHK");
                break;
        }
        return true;
    }

    public void loadlanguage(){
        Locale locale = new Locale(getlangcode());
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }


    public void savelangauge(String lang){
        SharedPreferences preferences = getSharedPreferences(filename, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(keylang, lang); //save into sharedpreferences
        editor.apply(); //refresh activity
        recreate();
    }

    private String getlangcode(){ //set english as default language
        SharedPreferences pref = getSharedPreferences(filename, MODE_PRIVATE);
        String langcode = pref.getString(keylang, "en");
        return langcode;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        return true;
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menusearch:
                Intent intents = new Intent(this, SearchListActivity.class);
                startActivity(intents);
                return true;
            case R.id.planicon:
                Intent intentp = new Intent(this, PlanActivity.class);
                startActivity(intentp);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

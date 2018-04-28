package com.example.user.smart_travel_planner;

import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SearchListActivity extends AppCompatActivity {
    private ListView lv;
    private LocationsAdapter adapter;
    String[] location;
    String[] region;
    int[] image;
    ArrayList<Location> arrayList = new ArrayList<Location>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);

        location = new String[]{getResources().getString(R.string.location_1),getResources().getString(R.string.location_2),
                getResources().getString(R.string.location_3),
                getResources().getString(R.string.location_4),
                getResources().getString(R.string.location_5),
                getResources().getString(R.string.location_5),
                getResources().getString(R.string.location_6),
                getResources().getString(R.string.location_7),
                getResources().getString(R.string.location_8),
                getResources().getString(R.string.location_9),
                getResources().getString(R.string.location_10),
                getResources().getString(R.string.location_11),
                getResources().getString(R.string.location_12),
                getResources().getString(R.string.location_13),
                getResources().getString(R.string.location_14),
                getResources().getString(R.string.location_15),
                getResources().getString(R.string.location_16),
                getResources().getString(R.string.location_17)};
        region = new String[]{getResources().getString(R.string.region_1),
                getResources().getString(R.string.region_2),
                getResources().getString(R.string.region_3),
                getResources().getString(R.string.region_4),
                getResources().getString(R.string.region_5),
                getResources().getString(R.string.region_6),
                getResources().getString(R.string.region_7),
                getResources().getString(R.string.region_8),
                getResources().getString(R.string.region_9),
                getResources().getString(R.string.region_10),
                getResources().getString(R.string.region_11),
                getResources().getString(R.string.region_12),
                getResources().getString(R.string.region_13),
                getResources().getString(R.string.region_14),
                getResources().getString(R.string.region_15),
                getResources().getString(R.string.region_16),
                getResources().getString(R.string.region_17)};
        image = new int[]{R.drawable.disney,
                R.drawable.tsingmabridge,
                R.drawable.laichiwo,
                R.drawable.clearwaterbaycountrypark,
                R.drawable.manmotemple,
                R.drawable.noahsark,
                R.drawable.lungkwutan,
                R.drawable.laufaushan,
                R.drawable.kowloonwalledcitypark,
                R.drawable.wilsontrailstage3,
                R.drawable.tinhautemple,
                R.drawable.wongtaisintemple,
                R.drawable.kowloonpark,
                R.drawable.cityhall,
                R.drawable.noondaygun,
                R.drawable.op,
                R.drawable.loversrock};

        lv = (ListView) findViewById(R.id.listview);
        for (int i = 0; i <location.length-1 ; i++) {
            Location l = new Location(location[i], region[i], image[i]);
            arrayList.add(l);
        }
        adapter = new LocationsAdapter(this, arrayList);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menusearch).getActionView();

        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    adapter.filter("");
                    lv.clearTextFilter();
                } else{
                    adapter.filter(newText);
                }
                return true;
            }
        });
        return true;
    }

    /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menusearch){
            return true;
        }
        return super.onOptionsItemSelected(item);
    } */
}

package com.example.user.smart_travel_planner;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

public class DetailsActivity extends Activity {
    private ImageView image;
    private TextView exactlocations;
    private TextView region;
    private TextView description;
    String location;
    String regions;
    int imagev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        location = intent.getStringExtra("locaiton");
        regions = intent.getStringExtra("region");
        imagev = intent.getIntExtra("image", imagev);

        image = (ImageView) findViewById(R.id.image);
        exactlocations = (TextView) findViewById(R.id.exactlocation);
        region = (TextView) findViewById(R.id.region);
        description = (TextView) findViewById(R.id.description);

        image.setImageResource(imagev);
        exactlocations.setText(location);
        region.setText(regions);
    }

}

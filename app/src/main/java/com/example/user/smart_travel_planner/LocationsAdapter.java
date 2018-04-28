package com.example.user.smart_travel_planner;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocationsAdapter extends BaseAdapter {
    private Context pcontext;
    private LayoutInflater inflater;
    private List<Location> locationList;
    private ArrayList<Location> arrayList;

    public LocationsAdapter(Context context, List<Location> locationList){
        pcontext = context;
        inflater = LayoutInflater.from(pcontext);
        this.locationList = locationList;
        this.arrayList = new ArrayList<Location>();
        this.arrayList.addAll(locationList);
    }

    @Override
    public int getCount() {
        return locationList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return locationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        viewholder holder;
        if (convertView == null){
            holder = new viewholder();
            inflater = (LayoutInflater) pcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder.locationview = convertView.findViewById(R.id.searchtextlocation);
            holder.regionview = convertView.findViewById(R.id.searchtextregion);
            holder.imageView = convertView.findViewById(R.id.searchimage);

            convertView.setTag(holder);
        } else {
            holder = (viewholder) convertView.getTag();
        }
        holder.locationview.setText(locationList.get(position).getLocation());
        holder.regionview.setText(locationList.get(position).getRegion());
        holder.imageView.setImageResource(locationList.get(position).getImage());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pcontext, DetailsActivity.class);
                intent.putExtra("location", locationList.get(position).getLocation());
                intent.putExtra("region", locationList.get(position).getRegion());
                intent.putExtra("image", locationList.get(position).getImage());
                pcontext.startActivity(intent);
            }
        });
        return convertView;
    }

    public void filter(String chartext){
        chartext = chartext.toLowerCase(Locale.getDefault());
        locationList.clear();
        if (chartext.length() == 0){
            locationList.addAll(arrayList);
        } else {
            for (Location l : arrayList) {
                if (l.getLocation().toLowerCase(Locale.getDefault()).contains(chartext)){
                    locationList.add(l);
                }
            }
        }
        notifyDataSetChanged();
    }

    private class viewholder{
        private ImageView imageView;
        private TextView locationview;
        private TextView regionview;
    }
}

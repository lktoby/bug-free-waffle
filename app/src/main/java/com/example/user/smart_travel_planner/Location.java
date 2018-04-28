package com.example.user.smart_travel_planner;

public class Location {
    private String location;
    private String region;
    private int image;

    public Location(String location, String region){
        this.location = location;
        this.region = region;
    }

    public Location(String location, String region, int image){
        this.location = location;
        this.region = region;
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public String getRegion() {
        return region;
    }

    public int getImage() {
        return image;
    }
}

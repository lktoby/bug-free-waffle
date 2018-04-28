package com.example.roadtripplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import com.example.user.smart_travel_planner.PlanActivity;



public class MainActivity extends AppCompatActivity {

    private int[][] timematrix = ArrayClass.timematrix;
    private ArrayList<String> locations = PlanActivity.locations;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


public class Project extends PlanActivity{
    public static void main(String[]args){

        ArrayList <Integer> Line = new ArrayList <Integer>();
        ArrayList <Integer> List = new ArrayList <Integer>();

        for (int i=1; i<19; i++){

            if (){
                locations[i] = i;
                List.add(locations[i]);
            }
        }

        for (int i=0; i<List.size(); i++){
            queue(Line, List, i);
        }
    }

    public static void queue(ArrayList <Integer> Line,  ArrayList <Integer> List, int i){
        int st_location =0;
        ArrayList <Integer> itinerary = new ArrayList <Integer>();
        int time = 0;
        int min_time = 0;
        Line[Line.size()] = List[i];
        if (List.size()> 0) {
            for (i=1; i<List.size(); i++){
                queue(Line, List, i);
            }
			else {
                Line[0] = st_location;
                Line[Line.size()] = st_location;
                time = calc_time(Line);
                if (time < min_time) {
                    min_time = time;
                    itinerary = Line;
                }
            }
        }
    }

    public static int calc_time (ArrayList <Integer> list){
        int needed_time = 0;
        for (int i=1; i <= list.size() -1; i++){
            needed_time += ArrayClass.timematrix[list[i-1]][list[i]]; //2D array
        }
        return needed_time;
    }

}
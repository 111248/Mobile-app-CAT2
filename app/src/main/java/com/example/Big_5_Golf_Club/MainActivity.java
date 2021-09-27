package com.example.Big_5_Golf_Club;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener((parent, v, groupPosition, id) -> false);

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(groupPosition -> Toast.makeText(getApplicationContext(),
                listDataHeader.get(groupPosition) + " Expanded",
                Toast.LENGTH_SHORT).show());

        // Listview Group collapsed listener
        expListView.setOnGroupCollapseListener(groupPosition -> Toast.makeText(getApplicationContext(),
                listDataHeader.get(groupPosition) + " Collapsed",
                Toast.LENGTH_SHORT).show());

        // Listview on child click listener
        expListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            // TODO Auto-generated method stub
            Toast.makeText(
                    getApplicationContext(),
                    listDataHeader.get(groupPosition)
                            + " : "
                            + Objects.requireNonNull(listDataChild.get(
                            listDataHeader.get(groupPosition))).get(
                            childPosition), Toast.LENGTH_SHORT)
                    .show();
            return false;
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Kenya Ndovu Golf Club");
        listDataHeader.add("Uganda Nyati Golf Club");
        listDataHeader.add("Tanzania Twiga Golf Club");

        // Adding child data
        List<String> KenyaNdovuGolfClub = new ArrayList<>();
        KenyaNdovuGolfClub.add("Driving Range");
        KenyaNdovuGolfClub.add("Short Game Range");
        KenyaNdovuGolfClub.add("Chipping Green");
        KenyaNdovuGolfClub.add("Putting Green");
        KenyaNdovuGolfClub.add("Electric Walk Behind Buggies");
        KenyaNdovuGolfClub.add("Pull Buggies");
        KenyaNdovuGolfClub.add("Golf Carts");

        List<String> UgandaNyatiGolfClub = new ArrayList<>();
        UgandaNyatiGolfClub.add("19th Nyati (Sports) Bar");
        UgandaNyatiGolfClub.add("Gym");
        UgandaNyatiGolfClub.add("Wellness Spa");
        UgandaNyatiGolfClub.add("Weddings");
        UgandaNyatiGolfClub.add("Corporate Golf Day");
        UgandaNyatiGolfClub.add("Meetings & Seminars");

        List<String> TanzaniaTwigaGolfClub = new ArrayList<>();
        TanzaniaTwigaGolfClub.add("Premium Golf Experience");
        TanzaniaTwigaGolfClub.add("Dining Venues");
        TanzaniaTwigaGolfClub.add("Gym");
        TanzaniaTwigaGolfClub.add("Spa");
        TanzaniaTwigaGolfClub.add("Swimming Pool");

        listDataChild.put(listDataHeader.get(0), KenyaNdovuGolfClub); // Header, Child data
        listDataChild.put(listDataHeader.get(1), UgandaNyatiGolfClub);
        listDataChild.put(listDataHeader.get(2), TanzaniaTwigaGolfClub);
    }
}


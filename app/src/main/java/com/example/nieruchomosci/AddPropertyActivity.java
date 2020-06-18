package com.example.nieruchomosci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddPropertyActivity extends AppCompatActivity {

    public List<String> propertyTypes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);

        propertyTypes.add("Dom");
        propertyTypes.add("Działka");
        propertyTypes.add("Mieszkanie");

        Spinner propertyTypeSpinner = findViewById(R.id.spinner);
    }

    public void onAddPropertyClick(View view) {
        //TODO: save new property in database
        NavUtils.navigateUpFromSameTask(this);
    }
}
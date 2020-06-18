package com.example.nieruchomosci;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class ViewPropertyActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ViewPropertyData[] dataset;

    public static final String EXTRA_PROPERTY_ID = "com.example.nieruchomosci.PROPERTY_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        loadPropertiesData();

        setContentView(R.layout.view_property);
        recyclerView = (RecyclerView) findViewById(R.id.property_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ViewPropertyDataAdapter(dataset, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        if (Session.instance.userType == Session.UserType.Anonymous) {
            inflater.inflate(R.menu.view_property_menu, menu);
        } else if (Session.instance.userType == Session.UserType.User) {
            inflater.inflate(R.menu.view_property_user_menu, menu);
        } else if (Session.instance.userType == Session.UserType.EstateManager) {
            inflater.inflate(R.menu.view_property_estate_manager_menu, menu);
        }

        return true;
    }

    void loadPropertiesData() {
        // TODO: load from database
        dataset = new ViewPropertyData[7];
        dataset[0] = new ViewPropertyData(1, "ul. Gdzieś Tam 123\n12-234 Tam Gdzieś", 1000, "Działka");
        dataset[1] = new ViewPropertyData(2, "ul. Kowalska 32\n12-234 Kowalowo", 162000, "Mieszkanie");
        dataset[2] = new ViewPropertyData(3, "ul. Kubusiowa 162\n12-234 Kubów", 11826, "Działka");
        dataset[3] = new ViewPropertyData(4, "ul. Biurkowa 12\n12-234 Pokój", 31244, "Mieszkanie");
        dataset[4] = new ViewPropertyData(5, "ul. Uliczna 222\n12-234 Miasto", 12304, "Dom");
        dataset[5] = new ViewPropertyData(6, "ul. Stroma 1212 Tam\n12-234 Góra", 1294812, "Dom");
        dataset[6] = new ViewPropertyData(7, "ul. Jakaś tam 111\n12-234 Miejscowość", 123812, "Mieszkanie");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_register:
                Intent registerIntent = new Intent(this, RegisterActivity.class);
                startActivity(registerIntent);
                return true;

            case R.id.menu_user_logout:
                Session.instance.userType = Session.UserType.Anonymous;
                finish();
                startActivity(getIntent());
                return true;

            case R.id.menu_manager_add_property:
                Intent addPropertyIntent = new Intent(this, AddPropertyActivity.class);
                startActivity(addPropertyIntent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
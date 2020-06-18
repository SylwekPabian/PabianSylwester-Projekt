package com.example.nieruchomosci;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewPropertyDetailsActivity extends AppCompatActivity {
    private Intent intent;
    private int propertyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property_details);

        intent = getIntent();
        propertyId = intent.getIntExtra(ViewPropertyActivity.EXTRA_PROPERTY_ID, -1);

        TextView txtPropertyAddress = (TextView) findViewById(R.id.txtPropertyDetailsAdress);
        txtPropertyAddress.setText(Session.instance.selectedPropertyData.propertyAddress);

        TextView txtPropertyPrice = findViewById(R.id.txtPropertyDetailsPrice);
        txtPropertyPrice.setText(String.valueOf(Session.instance.selectedPropertyData.propertyPrice) + " zł.");

        TextView txtPropertyType = findViewById(R.id.txtPropertyDetailsType);
        txtPropertyType.setText(Session.instance.selectedPropertyData.propertyType);

        if (Session.instance.userType != Session.UserType.EstateManager) {
            Button btnRemoveProperty = findViewById(R.id.btnRemoveProperty);
            btnRemoveProperty.setVisibility(View.GONE);
        }
    }

    public void onDeletePropertyClick(View view) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //TODO: remove property from database
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Czy na pewno usunąć nieruchomość?").setPositiveButton("Tak", dialogClickListener)
                .setNegativeButton("Nie", dialogClickListener).show();
    }
}
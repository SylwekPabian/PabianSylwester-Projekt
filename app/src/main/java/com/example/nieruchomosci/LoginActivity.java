package com.example.nieruchomosci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginClick(View view) {
        /*try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://10.0.2.2:59166/ProgUrzadzenMobilnych", "postgres", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM \"User\"");
            if (resultSet.next()) {
                if (resultSet.getString("login").equals("jan")) {
                    Session.instance.userType = Session.UserType.EstateManager;
                    NavUtils.navigateUpFromSameTask(this);
                    return;
               }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        TextView txtLogin = findViewById(R.id.txtLogin2);
        String login = txtLogin.getText().toString();
        if (login.equals("a")) {
            Session.instance.userType = Session.UserType.EstateManager;
        } else {
            Session.instance.userType = Session.UserType.User;
        }
        NavUtils.navigateUpFromSameTask(this);
    }
}
package com.example.testandroidprojekt;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import android.widget.Button;
import java.sql.*;

public class Otherpicture extends AppCompatActivity {
    EditText email;
    EditText password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otherpicture);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = findViewById(R.id.Email);
                password = findViewById(R.id.Password);
                String pas;
                String em;
                pas = password.getText().toString();
                em = email.getText().toString();



                System.out.println("String password ="+pas);
                System.out.println("email string = "+em);

                String url = "jdbc:mysql://localhost:3306/Konradtest";
                String user = "root";
                String pass = "";
                try {
                    // Verbindung aufbauen
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy); //Stackoverflow error anwser (didnt help alot)
                    Connection con = DriverManager.getConnection(url, user, pass);
                    System.out.println("Connecting compleate ");

                    String einfuegen =
                            "insert into users values ('"+pas+"', '"+em+"');";
                    Statement stm = con.createStatement();
                    stm.execute(einfuegen);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }//try



            }//on click


        });

    }
}
package com.example.recycleviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetaildActivity extends AppCompatActivity {
    private TextView name, description;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaild);

        extras=getIntent().getExtras();

        name = findViewById(R.id.nameID);
        description=findViewById(R.id.descriptionID);

        if(extras !=null){

            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
        }
    }
}
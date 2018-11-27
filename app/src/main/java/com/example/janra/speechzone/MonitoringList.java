package com.example.janra.speechzone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MonitoringList extends AppCompatActivity {
    EditText inputStudent1,inputStudent2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring_list);
        Toast.makeText(this, "Welcome to Speech Zone", Toast.LENGTH_SHORT).show();

        inputStudent1 = findViewById(R.id.et1);
        inputStudent2 = findViewById(R.id.et2);

    }

    public void backMain(View v){
        Intent i = new Intent(this, MainScreen.class);
        startActivity(i);
    }
    public void Save(View v){
        SharedPreferences preferences1 = getSharedPreferences("Pref1",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = preferences1.edit();
        editor1.putString("stud1", inputStudent1.getText().toString());
        SharedPreferences preferences2 = getSharedPreferences("Pref2",MODE_PRIVATE);
        SharedPreferences.Editor editor2 = preferences2.edit();
        editor2.putString("stud2", inputStudent2.getText().toString());
        editor1.commit();
        editor2.commit();
        Toast.makeText(this, "SAVE", Toast.LENGTH_SHORT).show();
    }
    public void load(View v){
        SharedPreferences sp1 = getSharedPreferences("Pref1",MODE_PRIVATE);
        SharedPreferences sp2 = getSharedPreferences("Pref2",MODE_PRIVATE);
        String name1 = sp1.getString("stud1",null);
        String name2 = sp2.getString("stud2",null);

        inputStudent1.setText(name1);
        inputStudent2.setText(name2);
        Toast.makeText(this, "LOAD", Toast.LENGTH_SHORT).show();
    }
    public void del1(View v){
        SharedPreferences sp1 = getSharedPreferences("Pref1",MODE_PRIVATE);
        sp1.edit().remove("stud1").commit();
        Toast.makeText(this, "Deleted Student 1", Toast.LENGTH_SHORT).show();
    }
    public void del2(View v){
        SharedPreferences sp1 = getSharedPreferences("Pref2",MODE_PRIVATE);
        Toast.makeText(this, "Deleted Student 2", Toast.LENGTH_SHORT).show();
        sp1.edit().remove("stud2").commit();
    }
}

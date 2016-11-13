package com.example.khoa.troyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class classinformation extends AppCompatActivity {
    Spinner spin;
    Button save;
    EditText text1,text2,text3;
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classinformation);
        spin=(Spinner) findViewById(R.id.spinner);
        String buildings[]={"Bibbs Graves","Patterson hall","Math and Science"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(classinformation.this,R.layout.support_simple_spinner_dropdown_item,buildings);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        save=(Button) findViewById(R.id.button3);
        spin.setAdapter(adapter);
        mydb=new DatabaseHelper(this);
        text1=(EditText) findViewById(R.id.editText);
        text2=(EditText) findViewById(R.id.editText2);
        text3=(EditText) findViewById(R.id.editText3);
        adddata();
    }
    public void adddata()
    {
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean results = mydb.insert(text1.getText().toString(), spin.getSelectedItem().toString(), text2.getText().toString(), text3.getText().toString());
                        if (results == true) {
                            Toast.makeText(classinformation.this, "save succesful", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(classinformation.this, "save fail try again pls", Toast.LENGTH_LONG).show();
                        }
                        Intent intent = new Intent(classinformation.this, Academic.class);
                        startActivity(intent);
                    }
                });
    }

}

package com.example.pappdominik_androidvarosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;


public class InsertActivity extends AppCompatActivity {

    private EditText nev;
    private EditText orszag;
    private EditText lakossag;
    private Button felvetelgomb;
    private Button visszagomb;
    private String base_url="https://retoolapi.dev/AAt5jw/varosok";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();
        visszagomb = (Button) findViewById(R.id.visszagomb);
        visszagomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InsertActivity.this, MainActivity.class));
                finish();
            }
        });
        felvetelgomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= String.valueOf(nev.getText());
                String orsz= String.valueOf(orszag.getText());
                String lakos= String.valueOf(lakossag.getText());
                if (name.isEmpty()) {
                    Toast.makeText(InsertActivity.this, "Name is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (orsz.isEmpty()) {
                    Toast.makeText(InsertActivity.this, "Country is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (lakos.isEmpty()) {
                    Toast.makeText(InsertActivity.this, "Population is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                Varos ujvaros=new Varos(name,orsz,lakos);
                Gson converter = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                String json = converter.toJson(ujvaros);
                try {
                    Response response = RequestHandler.post(base_url, json);
                    if (response.getResponseCode() == 201) {
                        Toast.makeText(InsertActivity.this, "City added", Toast.LENGTH_SHORT).show();

                    } else {
                        String content = response.getContent();
                        Toast.makeText(InsertActivity.this, content, Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void init(){
        nev=findViewById(R.id.nev);
        orszag=findViewById(R.id.orszag);
        lakossag=findViewById(R.id.lakossag);
        felvetelgomb=findViewById(R.id.felvetelgomb);
        visszagomb=findViewById(R.id.visszagomb);
    }
}
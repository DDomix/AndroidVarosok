package com.example.pappdominik_androidvarosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

public class ListActivity extends AppCompatActivity {

    private String base_url = "https://retoolapi.dev/AAt5jw/varosok";
    private Button back;
    private TextView data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListActivity.this, MainActivity.class));
                finish();
            }
        });
        //Response response = null;
        //try {
        //    response = RequestHandler.get(base_url);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        //String content = response.getContent();
        //Gson converter = new Gson();
        //Varos[] varos = converter.fromJson(content, Varos[].class);
        //for (Varos varos1 : varos) {
        //    data.setText((CharSequence) varos1);
        //}
    }
}
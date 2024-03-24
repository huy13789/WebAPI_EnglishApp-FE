package com.example.projectcn.View.lessonview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectcn.R;

import java.util.ArrayList;

public class VocabularyActivity extends AppCompatActivity {

    Button button;
    Button button3;
    Button btnpenw;
    Button btncommunicate;

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayCourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocabularyview);

        button3 = findViewById(R.id.button7);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyActivity.this, Vocabulary2.class);
                startActivity(intent);
            }
        });
        button = findViewById(R.id.btnimportant);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyActivity.this, Vocabulary3.class);
                startActivity(intent);
            }
        });
        btnpenw = findViewById(R.id.btnpenw);
        btnpenw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyActivity.this, Vocabulary4.class);
                startActivity(intent);
            }
        });
        btncommunicate = findViewById(R.id.btncommunicate);
        btncommunicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VocabularyActivity.this, Vocabulary5.class);
                startActivity(intent);
            }
        });

    }

}

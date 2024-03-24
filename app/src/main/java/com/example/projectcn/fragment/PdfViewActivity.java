package com.example.projectcn.fragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectcn.R;
import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewActivity extends AppCompatActivity {

    PDFView pdfView;
    TextView setName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);


        pdfView = findViewById(R.id.pdfView);
        setName = findViewById(R.id.Set);
        int pos = getIntent().getIntExtra("position",0);

        if (pos == 0){
            pdfView.fromAsset("pdf test1.pdf").load();
            setName.setText("lesson-1");
        } else if (pos == 1){
            pdfView.fromAsset("pdf test2.pdf").load();
            setName.setText("lesson-2");
        }
        else if (pos == 2){
            pdfView.fromAsset("pdf test3.pdf").load();
            setName.setText("lesson-3");
        }
        else if (pos == 3) {
            pdfView.fromAsset("pdf test4.pdf").load();
            setName.setText("lesson-4");
        }
        else if (pos == 4) {
            pdfView.fromAsset("pdf test5.pdf").load();
            setName.setText("lesson-5");
        }
        else if (pos == 5) {
            pdfView.fromAsset("pdf test6.pdf").load();
            setName.setText("lesson-6");
        }
        else if (pos == 6) {
            pdfView.fromAsset("pdf test7.pdf").load();
            setName.setText("lesson-7");
        }
        else if (pos == 7) {
            pdfView.fromAsset("pdf test8.pdf").load();
            setName.setText("lesson-8");
        }
        else if (pos == 8) {
            pdfView.fromAsset("pdf test9.pdf").load();
            setName.setText("lesson-9");
        }
        else if (pos == 9) {
            pdfView.fromAsset("pdf test10.pdf").load();
            setName.setText("lesson-10");
        }

    }
}
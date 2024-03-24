package com.example.projectcn.fragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectcn.R;
import com.github.barteksc.pdfviewer.PDFView;

public class pdfViewvocabularyActivity  extends AppCompatActivity {
    PDFView pdfView;
    TextView setName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view2);


        pdfView = findViewById(R.id.pdfView);
        setName = findViewById(R.id.set1);
        int pos = getIntent().getIntExtra("position",0);

        if (pos == 0){
            pdfView.fromAsset("vocabulary1.pdf").load();
            setName.setText("Abase");
        } else if (pos == 1){
            pdfView.fromAsset("vocabulary2.pdf").load();
            setName.setText("Abash");
        }
        else if (pos == 2){
            pdfView.fromAsset("vocabulary3.pdf").load();
            setName.setText("Abate");
        }
        else if (pos == 3) {
            pdfView.fromAsset("vocabulary4.pdf").load();
            setName.setText("Abbreviate");
        }
        else if (pos == 4) {
            pdfView.fromAsset("vocabulary5.pdf").load();
            setName.setText("Abbreviate");
        }
        else if (pos == 5) {
            pdfView.fromAsset("vocabulary6.pdf").load();
            setName.setText("Abdicate");
        }
        else if (pos == 6) {
            pdfView.fromAsset("vocabulary9.pdf").load();
            setName.setText("Abduction");
        }
        else if (pos == 7) {
            pdfView.fromAsset("vocabulary7.pdf").load();
            setName.setText("Aberrant");
        }
        else if (pos == 8) {
            pdfView.fromAsset("vocabulary8.pdf").load();
            setName.setText("Abet");
        }
        else if (pos == 9) {
            pdfView.fromAsset("Benevolent.pdf").load();
            setName.setText("Benevolent");
        }
        else if (pos == 10) {
            pdfView.fromAsset("Belligerent.pdf").load();
            setName.setText("Belligerent");
        }
        else if (pos == 11) {
            pdfView.fromAsset("Bifurcate.pdf").load();
            setName.setText("Bifurcate");
        }
        else if (pos == 12) {
            pdfView.fromAsset("Cacophony.pdf").load();
            setName.setText("Cacophony");
        }
        else if (pos == 13) {
            pdfView.fromAsset("Cajole.pdf").load();
            setName.setText("Cajole");
        }
        else if (pos == 14) {
            pdfView.fromAsset("Candid.pdf").load();
            setName.setText("Candid");
        }
        else if (pos == 15) {
            pdfView.fromAsset("Delineate.pdf").load();
            setName.setText("Delineate");
        }
        else if (pos == 16) {
            pdfView.fromAsset("Debilitate.pdf").load();
            setName.setText("Debilitate");
        }
        else if (pos == 17) {
            pdfView.fromAsset("Dichotomy.pdf").load();
            setName.setText("Dichotomy");
        }
        else if (pos == 18) {
            pdfView.fromAsset("Elucidate.pdf").load();
            setName.setText("Elucidate");
        }
        else if (pos == 19) {
            pdfView.fromAsset("Ephemeral.pdf").load();
            setName.setText("Ephemeral");
        }
        else if (pos == 20) {
            pdfView.fromAsset("Equivocate.pdf").load();
            setName.setText("Equivocate");
        }
        else if (pos == 21) {
            pdfView.fromAsset("Fervent.pdf").load();
            setName.setText("Fervent");
        }
        else if (pos == 22) {
            pdfView.fromAsset("Fluctuate.pdf").load();
            setName.setText("Fluctuate");
        }
        else if (pos == 23) {
            pdfView.fromAsset("Fortuitous.pdf").load();
            setName.setText("Fortuitous");
        }
        else if (pos == 24) {
            pdfView.fromAsset("Galvanize.pdf").load();
            setName.setText("Galvanize");
        }
        else if (pos == 25) {
            pdfView.fromAsset("Garrulous.pdf").load();
            setName.setText("Garrulous");
        }
        else if (pos == 26) {
            pdfView.fromAsset("Grandiloquent.pdf").load();
            setName.setText("Grandiloquent");
        }
        else if (pos == 27) {
            pdfView.fromAsset("Harangue.pdf").load();
            setName.setText("Harangue");
        }
        else if (pos == 28) {
            pdfView.fromAsset("Hedonistic.pdf").load();
            setName.setText("Hedonistic");
        }
        else if (pos == 29) {
            pdfView.fromAsset("Hapless.pdf").load();
            setName.setText("Hapless");
        }
        else if (pos == 30) {
            pdfView.fromAsset("Ineffable.pdf").load();
            setName.setText("Ineffable");
        }
        else if (pos == 31) {
            pdfView.fromAsset("Inscrutable.pdf").load();
            setName.setText("Inscrutable");
        }
        else if (pos == 32) {
            pdfView.fromAsset("Insidious.pdf").load();
            setName.setText("Insidious");
        }
    }
}

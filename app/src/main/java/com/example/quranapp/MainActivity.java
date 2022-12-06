package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    TextView tbxSurah,tbxAyat,tvxAyatDis, tvxPara;
    String paraName = "";

    QDH a1 = new QDH();

    QuranArabicText txt = new QuranArabicText();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        tbxSurah=findViewById(R.id.tnSurah);
        tbxAyat=findViewById(R.id.tnAyat);
        tvxAyatDis=findViewById(R.id.tvAyatDis);
        tvxPara=findViewById(R.id.tvPara);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(R.id.button == view.getId())
        {
            int surahNo = Integer.parseInt(tbxSurah.getText().toString());
            int ayatNo = Integer.parseInt(tbxAyat.getText().toString());
            if(surahNo>114 && surahNo<=0)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage("You enter invalid surah/ayat number!");
                builder.setTitle("Alert !");
            }
            int startingVerse = a1.SSP[surahNo - 1];
            int verseInd = startingVerse + ayatNo - 1;
            String verseStr = txt.QuranArabicText[verseInd];
            int i=0;
            while (i <30)
            {
                if(verseInd >= a1.PSP[i])
                {
                    paraName = a1.ParahName[i];
                }
                i++;
            }
            tvxPara.setText(paraName);
            tvxAyatDis.setText(verseStr);
        }
    }
}

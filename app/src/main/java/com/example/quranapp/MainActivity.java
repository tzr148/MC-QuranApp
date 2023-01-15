package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn, cmt, cmt2;

    TextView tbxSurah, tbxAyat, tvxAyatDis, tvxPara;

    String paraName = "";

    QDH a1 = new QDH();

    QuranArabicText ayat = new QuranArabicText();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        cmt = findViewById(R.id.button2);
///        cmt2 = findViewById(R.id.button3);
        tbxSurah=findViewById(R.id.tnSurah);
        tbxAyat=findViewById(R.id.tnAyat);
        tvxAyatDis=findViewById(R.id.tvAyatDis);
        tvxPara=findViewById(R.id.tvPara);

        btn.setOnClickListener(this);
        cmt.setOnClickListener(this);
//        cmt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(R.id.button == view.getId())
        {
            int surahNo = Integer.parseInt(tbxSurah.getText().toString());
            int ayatNo = Integer.parseInt(tbxAyat.getText().toString());

            int startingAyat = a1.SSP[surahNo - 1];
            int verseInd = startingAyat + ayatNo - 1;
            String strAyat = ayat.QuranArabicText[verseInd];
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
            tvxAyatDis.setText(strAyat);
        }
        else if(R.id.button2 == view.getId())
        {
            Uri uri = Uri.parse("https://github.com/tzr148");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
//        else if(R.id.button3 == view.getId())
//        {
//            Uri uri = Uri.parse("https://github.com/tzr148");
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(intent);
//        }
    }
}

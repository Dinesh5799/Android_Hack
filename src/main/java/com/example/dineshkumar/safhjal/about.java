package com.example.dineshkumar.safhjal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    public void karma(View v){
        Intent i=new Intent(getApplicationContext(),karmaActivity.class);
        startActivity(i);
    }
    public void movetoweb(View v){
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://swachhbharat.mygov.in/"));
        startActivity(i);
    }
    public void support(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://timesofindia.indiatimes.com/entertainment/hindi/bollywood/Narendra-Modi-Bollywood-celebrities-get-clicked-with-the-PM/Narendra-Modi-Bollywood-celebrities-get-clicked-with-the-PM/photostory/44968853.cms"));
        startActivity(i);
    }
    public void pledge(View v){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://swachhbharat.mygov.in/basic-page/take-pledge"));
        startActivity(i);
    }
    public void know(View v){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.indiawaterportal.org/articles/water-scarcity-and-security-india"));
        startActivity(i);
    }

}

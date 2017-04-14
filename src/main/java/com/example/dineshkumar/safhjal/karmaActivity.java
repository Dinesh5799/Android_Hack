package com.example.dineshkumar.safhjal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class karmaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karma);
    }
    public void karmause(View v){
        Intent i=new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://paytm.com/"));
        startActivity(i);
    }
}

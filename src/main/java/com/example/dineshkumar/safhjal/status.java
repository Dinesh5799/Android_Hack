package com.example.dineshkumar.safhjal;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class status extends AppCompatActivity {
    ComplainDb cd=new ComplainDb(this,false);
    EditText statusAadh;
    TextView showStat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        statusAadh=(EditText)findViewById(R.id.aad);
        showStat=(TextView)findViewById(R.id.showstat);
    }
    public void search(View v){
       /* Person p=new Person();
        p=cd.fetchComplaint(Long.parseLong(statusAadh.getText().toString()));
        showStat.setText("Aadhar no is:::"+String.valueOf(p.getAadhar())+"\nPhone no is :::"+p.getPhone()+"\nStatus is:::"+p.getStatus());
       */
        SharedPreferences sp=getSharedPreferences(statusAadh.getText().toString(),MODE_PRIVATE);
        String Aadhar=sp.getString("Aadhar","");
        String Contact=sp.getString("Phone","");
        String Address=sp.getString("Address","");
        String Status=sp.getString("Status","");
        if(statusAadh.getText().toString().equals(Aadhar))
        {
            showStat.setText("Aadhar no is:::"+Aadhar+"\nPhone no is :::"+Contact+"\nStatus is:::In Progress"+"\n Address is:::"+Address);
            Toast.makeText(this,"Fetching Data",Toast.LENGTH_LONG).show();
        }
        else
        {
            showStat.setText("");
            showStat.setText("Aadhar no is  not a valid Entry ");
        }
        Toast.makeText(this,"Fetching Data",Toast.LENGTH_LONG).show();
    }

}

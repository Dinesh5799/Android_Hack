package com.example.dineshkumar.safhjal;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    EditText aad,phone,address,complain;
    ComplainDb db=new ComplainDb(this,true);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        aad=(EditText)findViewById(R.id.aad);
        phone=(EditText)findViewById(R.id.phon);
        address=(EditText)findViewById(R.id.address);
        complain=(EditText)findViewById(R.id.realcomp);
    }
    public void submit(View v){
       /* Person p=new Person();
        p.setAadhar(Integer.parseInt(aad.getText().toString()));
        p.setPhone(Integer.parseInt(phone.getText().toString()));
        p.setAddress(address.getText().toString());
        p.setComp(complain.getText().toString());
        p.setStatus("Initiated");
       db.submitComplain(p);
       */
        SharedPreferences sp=getSharedPreferences(aad.getText().toString(),MODE_PRIVATE);
        SharedPreferences.Editor spe=sp.edit();
        spe.putString("Aadhar",aad.getText().toString());
        spe.putString("Phone", phone.getText().toString());
        spe.putString("Address",address.getText().toString());
        spe.putString("Complaint",complain.getText().toString());
        spe.putString("Status","Initiated");
        spe.commit();
       Toast.makeText(this,"Complaint Submitted Successfully",Toast.LENGTH_LONG).show();
    }
}

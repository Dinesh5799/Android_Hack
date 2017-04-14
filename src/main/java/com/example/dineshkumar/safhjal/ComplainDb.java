package com.example.dineshkumar.safhjal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dinesh Kumar on 13-04-2017.
 */

public class ComplainDb extends SQLiteOpenHelper {
    public static final int version=1;
    public static String name="Complain";
    Context context,ct1;
    EditText aadhar;
    public static boolean flag=true;
    ComplainDb(Context c,boolean b) {
        super(c, name, null, version);
        if(b==true){
        context=c;
        flag=b;}
        else{
            ct1=c;
            flag=b;
        }
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        if (flag) {
            Activity at = (Activity) context;
            aadhar = (EditText) at.findViewById(R.id.aad);
            Toast.makeText(context, "oncreate", Toast.LENGTH_SHORT).show();
            String s = "create table complain" + aadhar.getText().toString() + "(id number,phone number,compl text,status text,address text)";
            sqLiteDatabase.execSQL(s);
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public void submitComplain(Person p){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",p.getAadhar());
        cv.put("phone",p.getPhone());
        cv.put("address",p.getAddress());
        cv.put("compl",p.getComp());
        cv.put("status",p.getStatus());
        db.insert("complain"+aadhar.getText().toString(),null,cv);
        Toast.makeText(context,"Saved", Toast.LENGTH_SHORT).show();
    }
    public Person fetchComplaint(Long s1){
        Person p=new Person();
        SQLiteDatabase db=getReadableDatabase();
        String s="select *from "+s1;
        Cursor c1=db.rawQuery(s,null);
        if(c1.getLong(0)==s1){
            while(c1.moveToNext()){
                p.setAadhar(c1.getLong(0));
                p.setPhone(c1.getLong(1));
                p.setComp(c1.getString(2));
                p.setStatus(c1.getString(3));
                p.setAddress(c1.getString(4));
            }
        }
        else{
            p.setAadhar(0);
            p.setPhone(0);
            p.setComp("Wrong Aadhar Entered");
            p.setStatus(" ");
            p.setAddress(" ");
        }

        return p;
    }

}

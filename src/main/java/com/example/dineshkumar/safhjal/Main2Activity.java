package com.example.dineshkumar.safhjal;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dineshkumar.safhjal.DbHelper;

public class Main2Activity extends AppCompatActivity{
    private Button btnLogout;
    private Session session;
    private TextView tv1;
    // private static final String SELECT_SQL = "SELECT COLUMN_FIRST_NAME,COLUMN_LAST_NAME from USER_TABLE";
    // private SQLiteDatabase db;
    // private Cursor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Toolbar mToobar=(Toolbar)findViewById(R.id.toolbar);
        //  setSupportActionBar(mToobar);
        //tv1=(TextView)findViewById(R.id.tv1);

        //  c = db.rawQuery(SELECT_SQL, null);
        // c.moveToFirst();
        //showRecords();
        //ContentValues values = new ContentValues();

        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    /*  @Override
      public boolean onCreateOptionsMenu(Menu menu) {
          MenuInflater mi=getMenuInflater();
          mi.inflate(R.menu.my_menu,menu);

          return true;
      }

      @Override
      public boolean onOptionsItemSelected(MenuItem item) {
          if(item.getItemId()==R.id.setting)
          {
              Toast.makeText(Main2Activity.this,"Setting Clicked",Toast.LENGTH_SHORT).show();
          }
          if(item.getItemId()==R.id.aboutus)
          {
              Toast.makeText(Main2Activity.this,"About Us Clicked",Toast.LENGTH_SHORT).show();
          }
          return super.onOptionsItemSelected(item);
      }
  */
    /* protected void showRecords() {
                String id = c.getString(0);
                String name = c.getString(1);

                tv1.setText(id+name);


            }*/
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(Main2Activity.this,MainActivity.class));
    }
    public void comp(View v){
        Intent i=new Intent(this,Main3Activity.class);
        startActivity(i);
    }
    public void stat(View v){
        Intent i=new Intent(this,status.class);
        startActivity(i);
    }
    public void about(View v){
        Intent i=new Intent(this,about.class);
        startActivity(i);
    }
}
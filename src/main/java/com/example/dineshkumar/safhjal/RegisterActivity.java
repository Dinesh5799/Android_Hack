package com.example.dineshkumar.safhjal;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.dineshkumar.safhjal.R.color.white;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private Button reg;
    private TextView tvLogin,tvReg;
    private EditText etEmail, etPass,fn,ln;

    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DbHelper(this);
        reg = (Button)findViewById(R.id.btnReg);
        tvLogin = (TextView)findViewById(R.id.tvLogin);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);
        fn=(EditText)findViewById(R.id.fn);

        ln=(EditText)findViewById(R.id.ln);
        tvReg=(TextView)findViewById(R.id.tvReg);
        tvReg.setOnClickListener(this);
        reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnReg:
                if (fn.getText().toString().isEmpty()&&ln.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"First/Last Name Field empty", Toast.LENGTH_SHORT).show();
                }
                else if(fn.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"First Name Field empty", Toast.LENGTH_SHORT).show();

                }
                else if (ln.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Last Name Field empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    register();

                }
                break;
            case R.id.tvLogin:
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                finish();
                break;
            case R.id.tvReg:

                startActivity(new Intent(RegisterActivity.this, RegisterActivity.class));
                finish();

                break;
            default:

        }
    }

    private void register(){

        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
        String fn1=fn.getText().toString();
        String ln1=ln.getText().toString();

        if(email.isEmpty() && pass.isEmpty()){
            displayToast("Username/password field empty");

        }
        else{
            db.addUser(fn1,ln1,email,pass);
            displayToast("User registered");
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
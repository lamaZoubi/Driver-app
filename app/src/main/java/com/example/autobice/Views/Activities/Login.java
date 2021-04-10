package com.example.autobice.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.autobice.Models.LoginMessage;
import com.example.autobice.R;
import com.example.autobice.Utils.NetworkOperation;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText edEmail1 , edPassword1;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail1=findViewById(R.id.edEmail1);
        edPassword1 = findViewById(R.id.edPassword1);

    }


    private boolean validateEmailAddress(EditText email){
        String emailInput = email.getText().toString();
        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
            return true;
        else
            return false;
    }

    public void login(View view) {
        String email , password ;
        email=edEmail1.getText().toString();
        password =edPassword1.getText().toString();
        if(!email.equals("") && !password.equals("")){
            if(validateEmailAddress(edEmail1)) {

                Map<String,String> map =new HashMap<>();
                map.put("mail",email);
                map.put("password",password);
                Call<LoginMessage> call = NetworkOperation.getAPi().login(map);
                call.enqueue(new Callback<LoginMessage>() {
                    @Override
                    public void onResponse(Call<LoginMessage> call, Response<LoginMessage> response) {
                        LoginMessage message = response.body();
                        if (message.getCode()>0){

                            Toast.makeText(Login.this , message.getCode()+"",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                            Toast.makeText(Login.this,message.getCode()+"",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<LoginMessage> call, Throwable t) {


                    }
                });
            }
            else
                Toast.makeText(this,"Invalid Email Address!",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "missing  feild is requred", Toast.LENGTH_SHORT).show();
    }

    public void goToSingup(View view) {
        Intent intent = new Intent(getApplicationContext(), Singup.class);
        startActivity(intent);
        finish();
    }
}
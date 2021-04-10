package com.example.autobice.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.autobice.Models.SigupMessage;
import com.example.autobice.R;
import com.example.autobice.Utils.NetworkOperation;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Singup extends AppCompatActivity {
    EditText edFirstName, edLastName, edEmail, edPassword, edPhoneNumber;
    Button buttonSingup;
    ProgressBar pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        edFirstName = findViewById(R.id.edFirstName);
        edLastName = findViewById(R.id.edlastName);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edPhoneNumber = findViewById(R.id.edPhoneNumber);
        pro = findViewById(R.id.pro);
        Log.d("mario","lamama");
    }

    public void Singup(View view) {
        String firstName, lastName, email, password, phoneNumber;
        firstName = edFirstName.getText().toString();
        lastName = edLastName.getText().toString();
        email = edEmail.getText().toString();
        password = edPassword.getText().toString();
        phoneNumber = edPhoneNumber.getText().toString();

        if(validateInputs()){
            Map<String,String> map =new HashMap<>();
            pro.setVisibility(View.VISIBLE);
            map.put("firstName",firstName);
            map.put("lastName",lastName);
            map.put("email",email);
            map.put("password",password);
            map.put("userType","1");
            map.put("phoneNumber",phoneNumber);



            Call<SigupMessage> call = NetworkOperation.getAPi().signUp(map);
            call.enqueue(new Callback<SigupMessage>() {
                @Override
                public void onResponse(Call<SigupMessage> call, Response<SigupMessage> response) {
                    pro.setVisibility(View.GONE);
                    SigupMessage sg=response.body();
                    if(sg.getCode()>0){
                        //Sucree
                        Toast.makeText(Singup.this,sg.getMessageData().getName()+"" , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MachineRegistration.class);
                       startActivity(intent);
                       finish();

                    }else{
                        //Fail
                        Toast.makeText(Singup.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                    Log.d("Mariooo",sg.getCode()+"");
                    Log.d("Mariooo",sg.getMessage());
                }

                @Override
                public void onFailure(Call<SigupMessage> call, Throwable t) {
                    // rung thius Line
                    pro.setVisibility(View.GONE);

                }
            });
        }else {

        }


    }

    private boolean validateInputs() {
        String firstName, lastName, email, password, phoneNumber;
        boolean validEmail;

        firstName = edFirstName.getText().toString();
        lastName = edLastName.getText().toString();
        email = edEmail.getText().toString();
        validEmail=validateEmailAddress(edEmail);
        if(validEmail)
        {

        }
        else
            return false;
        password = edPassword.getText().toString();
        phoneNumber = edPhoneNumber.getText().toString();
        String[] inputs=  {firstName,lastName,email,password,phoneNumber};
        for (int i =0; i<inputs.length;i++){
            if(inputs[i].equals("")) {
                Toast.makeText(this, "missing  feild is requred", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    private boolean validateEmailAddress(EditText email){
        String emailInput = email.getText().toString();
        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
            return true;
        else{
            Toast.makeText(this,"Invalid Email Address!",Toast.LENGTH_SHORT).show();
                    return false;
        }
    }

    public void goToSingin(View view) {

        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
        finish();
    }
}
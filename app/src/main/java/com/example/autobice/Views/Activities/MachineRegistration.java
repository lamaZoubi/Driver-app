package com.example.autobice.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.autobice.Models.RegisterMessage;
import com.example.autobice.R;
import com.example.autobice.Utils.NetworkOperation;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MachineRegistration extends AppCompatActivity {
 EditText  edBusNumber , edPassengerCapacity , edPaymentAmount;
 Button btRegister;
 ProgressBar prog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_registration);


        edBusNumber=findViewById(R.id.edBusNumber);
        edPassengerCapacity=findViewById(R.id.edPassengerCapacity);
        edPaymentAmount=findViewById(R.id.edPaymentAmount);
        prog1  = findViewById(R.id.pro1);
    }

    public void register(View view) {

        String  busNumber, passengerCapacity,paymentAmount;

        busNumber=edBusNumber.getText().toString();
        passengerCapacity=edPassengerCapacity.getText().toString();
        paymentAmount=edPaymentAmount.getText().toString();

        if(validateInputs()){
            Map<String,String> map =new HashMap<>();
            prog1.setVisibility(View.VISIBLE);
            map.put("busNumber",busNumber);
            map.put("paymentAmount",paymentAmount);
            map.put("passengerCapacity",passengerCapacity);

            Call<RegisterMessage> call = NetworkOperation.getAPi().SaveMachine(map);
            call.enqueue(new Callback<RegisterMessage>() {
                @Override
                public void onResponse(Call<RegisterMessage> call, Response<RegisterMessage> response) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                   
                }

                @Override
                public void onFailure(Call<RegisterMessage> call, Throwable t) {
                    Toast.makeText(MachineRegistration.this, "fail", Toast.LENGTH_LONG).show();

                }
            });

        }

    }

    private boolean validateInputs(){
        String busNumber, passengerCapacity,paymentAmount;

        busNumber=edBusNumber.getText().toString();
        passengerCapacity=edPassengerCapacity.getText().toString();
        paymentAmount=edPaymentAmount.getText().toString();
        String[] inputs=  {busNumber,passengerCapacity,paymentAmount};
        for(int i=0;i<inputs.length;i++)
         if (inputs[i].equals(""))
                return false;
            return true;


    }
}
package com.tuantran.custombroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String MY_ACTION = "MY_ACTION";
    private static final String MY_KEY_NAME = "MY_KEY_NAME";
    private static final String MY_KEY_ADDRESS = "MY_KEY_ADDRESS";
    private static final String MY_KEY_PHONENUMBER = "MY_KEY_PHONENUMBER";
    private Button send;
    private EditText edtName,edtAddress,edtPhone;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = findViewById(R.id.btn_send);
        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        edtPhone = findViewById(R.id.edtPhone);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSendBroadcast();
            }
        });
    }

    private void clickSendBroadcast() {
        Intent intent = new Intent(MY_ACTION);
        intent.putExtra(MY_KEY_NAME,edtName.getText().toString().trim());
        intent.putExtra(MY_KEY_ADDRESS,edtAddress.getText().toString().trim());
        intent.putExtra(MY_KEY_PHONENUMBER,edtPhone.getText().toString().trim());
        sendBroadcast(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter  intentFilter =  new IntentFilter(MY_ACTION);
        registerReceiver(broadcastReceiver,intentFilter);
    }
    // huy broadcastReceiver
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}
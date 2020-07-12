package com.example.emailintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.lang.UScript;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variable Declaration

    private EditText text_to;
    private EditText text_Subject;
    private EditText text_Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variable Initialization

        text_to = (EditText) findViewById(R.id.text_to);
        text_Subject = (EditText) findViewById(R.id.text_subject);
        text_Message = (EditText) findViewById(R.id.text_Message);

        Button send_btn = (Button) findViewById(R.id.send_btn);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

    }

    //Main Function to send Email

    private void sendMail() {

        String recipientsList = text_to.getText().toString();
        //example1@gmail.com , example2@gmail.com
        String[] recipients = recipientsList.split(",");

        String subject = text_Subject.getText().toString();
        String message  = text_Message.getText().toString();

        Intent intent = new Intent (Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        //message type  A Multi-Purpose Internet Mail Extension
        intent.setType("message/rfc882");
        startActivity(Intent.createChooser(intent,"Choose an Email client :"));
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent in1= new Intent(Intent.ACTION_VIEW);
                EditText ed =findViewById(R.id.editText);
                final String net= ed.getText().toString();
                if(!net.equals("")&&net != ""){
                    in1.setData(Uri.parse(net));
                    startActivity(in1);
                }else {
                    Toast.makeText(getApplicationContext(),"please enter Url",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
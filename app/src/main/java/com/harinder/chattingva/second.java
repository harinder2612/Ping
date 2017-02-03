package com.harinder.chattingva;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class second extends AppCompatActivity {
EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        e1= (EditText) findViewById(R.id.editText4);
        e2= (EditText) findViewById(R.id.editText5);
    }

    public void load(View v)
    {String username,pwd;
        SharedPreferences share=getSharedPreferences("mydata", Context.MODE_PRIVATE);
       username=e1.getText().toString();

       pwd=e2.getText().toString();

        if(username.equals( share.getString("username","not found"))&&pwd.equals( share.getString("password","not found")))
        { Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"enter valid credentials",Toast.LENGTH_SHORT).show();
        }
    }

    public void previous(View view)
    {
        Intent intent=new Intent(this,first.class);
        startActivity(intent);
    }


}

package com.harinder.chattingva;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class first extends AppCompatActivity {
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        e1= (EditText) findViewById(R.id.editText);
        e2= (EditText) findViewById(R.id.editText2);

    }

public void signin (View v)
{String username,pwd;
    username=e1.getText().toString();
    pwd=e2.getText().toString();
    SharedPreferences share=getSharedPreferences("mydata",Context.MODE_PRIVATE);
    SharedPreferences.Editor edi=share.edit();
    edi.putString("username", username);
    edi.putString("password", pwd);
    edi.commit();
    Toast.makeText(this,"saved successfully",Toast.LENGTH_SHORT).show();
    next();
}

    public void next()
    {
        Intent intent=new Intent(this,second.class);
        startActivity(intent);
    }


}

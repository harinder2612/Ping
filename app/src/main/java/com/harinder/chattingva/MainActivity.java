package com.harinder.chattingva;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    DatabaseReference myref= FirebaseDatabase.getInstance().getReferenceFromUrl("https://chattingva.firebaseio.com/");
    ArrayList<String> users=new ArrayList<>();
    ListView l1;
    EditText e1;
    static int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1= (ListView) findViewById(R.id.list);
        e1= (EditText) findViewById(R.id.editText);
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,users);
        l1.setAdapter(arrayAdapter);

        myref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue(String.class);
                users.add(value);
                i=users.size();
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    public void enter(View v)
    {
        SharedPreferences share=getSharedPreferences("mydata", Context.MODE_PRIVATE);
        String username=share.getString("username","not found");
        i++;
        DatabaseReference chi = myref.child(""+i);
        chi.setValue(""+username.toUpperCase()+": "+e1.getText().toString());
        Toast.makeText(this, "Sent", Toast.LENGTH_SHORT).show();
        e1.setText("");

    }


}

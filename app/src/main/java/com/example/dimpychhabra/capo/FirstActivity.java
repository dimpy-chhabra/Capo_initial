package com.example.dimpychhabra.capo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FirstActivity extends AppCompatActivity {
    ImageButton ib1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ib1=(ImageButton)findViewById(R.id.dummy_button);

                ib1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences spref = getSharedPreferences(Utils.MyPref, Context.MODE_PRIVATE);
                String a = spref.getString(Utils.Name, null); // getting String
                String b = spref.getString(Utils.Phone, null);
                String c = spref.getString(Utils.IS_LOGIN, "false");

                Log.e("in FullScreen Activity ","name : "+a+" phone : "+b+" isloggedin? : "+c);
                if(c.equals("true")){
                    Log.e("in  Activity in if","name : "+a+" phone : "+b+" isloggedin? : "+c);
                    Intent i  = new Intent(FirstActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else {
                    Intent i  = new Intent(FirstActivity.this, LoginBaseActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}



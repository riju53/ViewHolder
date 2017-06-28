package com.example.rijunath.viewholder_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by RIJU NATH on 6/28/2017.
 */
public class Second extends AppCompatActivity {
    ImageView im1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        im1=(ImageView)findViewById(R.id.im1);
        int p=getIntent().getExtras().getInt("pic");
        im1.setBackgroundResource(p);
    }
}

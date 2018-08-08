package com.example.cesarbernasoli.party2tonight3;


import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;

import android.support.v7.app.AppCompatActivity;


import android.support.v4.view.ViewPager;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity {
    Button btnReader,btnGenerator;

    private static final String TAG = "MainActivity";

    private SectionpageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReader = (Button) findViewById(R.id.btnReader);
        btnGenerator = (Button) findViewById(R.id.btnGenerator);




        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionpageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);










    }

    private void setupViewPager(ViewPager viewPager) {
        SectionpageAdapter adapter = new SectionpageAdapter(getSupportFragmentManager());
        adapter.addFragment(new tab1Fragment(), "Home");
        adapter.addFragment(new tab2Fragment(), "Chat");
        adapter.addFragment(new tab3Fragment(), "QR Code");
        viewPager.setAdapter(adapter);
    }

    private void alert(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }

}

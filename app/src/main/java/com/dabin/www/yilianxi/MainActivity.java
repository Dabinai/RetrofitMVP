package com.dabin.www.yilianxi;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import fragments.Shouye;
import fragments.Zixun;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout frameLayout;
    private RadioButton shouye;
    private RadioButton zixuan;
    private RadioButton hangqing;
    private RadioButton zixun;
    private RadioButton jiaoyi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = (FrameLayout) findViewById(R.id.framlayout);
        shouye = (RadioButton) findViewById(R.id.shouye);
        zixuan = (RadioButton) findViewById(R.id.zixuan);
        hangqing = (RadioButton) findViewById(R.id.hangqing);
        zixun = (RadioButton) findViewById(R.id.zixun);
        jiaoyi = (RadioButton) findViewById(R.id.jiaoyi);

        shouye.setOnClickListener(this);
        zixuan.setOnClickListener(this);
        hangqing.setOnClickListener(this);
        zixun.setOnClickListener(this);
        jiaoyi.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shouye:
                Shouye shouye = new Shouye();
                FragmentManager sp = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = sp.beginTransaction();
                fragmentTransaction.replace(R.id.framlayout,shouye);
                fragmentTransaction.commit();
                break;
            case R.id.zixuan:
                Shouye shouye1 = new Shouye();
                FragmentManager sp1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = sp1.beginTransaction();
                fragmentTransaction1.replace(R.id.framlayout,shouye1);
                fragmentTransaction1.commit();
                break;
            case R.id.hangqing:
                Shouye shouye2 = new Shouye();
                FragmentManager sp2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = sp2.beginTransaction();
                fragmentTransaction2.replace(R.id.framlayout,shouye2);
                fragmentTransaction2.commit();
                break;
            case R.id.zixun:
                Zixun zixun = new Zixun();
                FragmentManager s4 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction4 = s4.beginTransaction();
                fragmentTransaction4.replace(R.id.framlayout,zixun);
                fragmentTransaction4.commit();
                break;
            case R.id.jiaoyi:
                Shouye shouye3 = new Shouye();
                FragmentManager sp3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = sp3.beginTransaction();
                fragmentTransaction3.replace(R.id.framlayout,shouye3);
                fragmentTransaction3.commit();
                break;
        }
    }
}

package com.example.exp7p2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonAddF = findViewById(R.id.button);
        Button buttonAddS = findViewById(R.id.button2);
        Button buttonRemoveF = findViewById(R.id.button3);
        Button buttonRemoveS = findViewById(R.id.button4);
        Button buttonAttachF = findViewById(R.id.button5);
        Button buttonDetachF = findViewById(R.id.button6);
        Button buttonReplaceFwithS = findViewById(R.id.button7);
        Button buttonReplaceSwithF = findViewById(R.id.button8);

        final FragmentFirst firstFragment = new FragmentFirst();
        final FragmentSecond secondFragment = new FragmentSecond();
        final FragmentManager fragmentManager = getSupportFragmentManager();
        buttonAddF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.root_layout, firstFragment, "FirstFrag"); fragmentTransaction.commit();
            } });

        buttonAddS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.root_layout, secondFragment, "SecondFrag");
                fragmentTransaction.commit();
            } });

        buttonRemoveF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = fragmentManager.findFragmentByTag("FirstFrag");
                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(fragment);
                    fragmentTransaction.commit();
                }
            }
        });
        // Remove Second Fragment
        buttonRemoveS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = fragmentManager.findFragmentByTag("SecondFrag");
                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.remove(fragment);
                    fragmentTransaction.commit();
                }
            }
        });

// Attach First Fragment
        buttonAttachF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = fragmentManager.findFragmentByTag("FirstFrag");
                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.attach(fragment);
                    fragmentTransaction.commit();
                }
            }
        });

// Detach First Fragment
        buttonDetachF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = fragmentManager.findFragmentByTag("FirstFrag");
                if (fragment != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.detach(fragment);
                    fragmentTransaction.commit();
                }
            }
        });

// Replace First with Second
        buttonReplaceFwithS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.root_layout, secondFragment, "SecondFrag");
                fragmentTransaction.commit();
            }
        });

// Replace Second with First
        buttonReplaceSwithF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.root_layout, firstFragment, "FirstFrag");
                fragmentTransaction.commit();
            }
        });
    }
}
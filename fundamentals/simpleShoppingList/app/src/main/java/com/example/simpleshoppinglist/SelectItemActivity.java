package com.example.simpleshoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SelectItemActivity extends AppCompatActivity {
    public static final String RETURN_NUMBER = "return_number";
    public static final String RETURN_PRODUCT = "product";
    public static final String REPLY_CHEESE = "Cheese";
    public static final String REPLY_RICE = "Rice";
    public static final String REPLY_GUM = "Gum";
    public static final String REPLY_SANDWICH = "Sandwich";
    public static final String REPLY_WAFFLES = "Waffles";
    public static final String REPLY_COCACOLA = "Coca Cola";
    public static final String REPLY_PIZZA = "Pizza";
    public static final String REPLY_SPAGGETI = "Spaggeti";
    public static final String REPLY_SALT = "Salt";
    public static final String REPLY_SHUGAR = "Shugar";
    public static final String EXTRA_REPLY = "replyProduct";

    Button cheese, rice, gum, sandwich, waffles, cocaCola, pizza, spaggeti, salt, shugar;
    ArrayList<String> listOfAddedPdoucts = new ArrayList<String>();
    String listNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_item);
        cheese = findViewById(R.id.cheese);
        rice = findViewById(R.id.rice);
        gum = findViewById(R.id.gum);
        sandwich = findViewById(R.id.sandwich);
        waffles = findViewById(R.id.waffles);
        cocaCola = findViewById(R.id.coca_cola);
        pizza = findViewById(R.id.pizza);
        spaggeti = findViewById(R.id.spaggeti);
        salt = findViewById(R.id.salt);
        shugar = findViewById(R.id.shugar);
        Intent intent = getIntent();
        listNumber = intent.getStringExtra(MainActivity.VIEW_NUMBER_EXTRA);
        listOfAddedPdoucts = intent.getStringArrayListExtra(MainActivity.LIST_OF_ADDED_PRODUCTS);

        cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentResponse(REPLY_CHEESE);
            }
        });

        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentResponse(REPLY_RICE);
            }
        });

        gum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentResponse(REPLY_GUM);
            }
        });

        sandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentResponse(REPLY_SANDWICH);
            }
        });

        waffles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentResponse(REPLY_WAFFLES);
            }
        });

        cocaCola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentResponse(REPLY_COCACOLA);
            }
        });

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentResponse(REPLY_PIZZA);
            }
        });

        spaggeti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentResponse(REPLY_SPAGGETI);
            }
        });

        salt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentResponse(REPLY_SALT);
            }
        });

        shugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentResponse(REPLY_SHUGAR);
            }
        });

        cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentResponse(REPLY_CHEESE);
            }
        });

    }

    private void sentResponse(String reply) {
        Intent repplyIntent = new Intent();
        repplyIntent.putExtra(MainActivity.VIEW_NUMBER_EXTRA, listNumber);
        repplyIntent.putExtra(MainActivity.LIST_OF_ADDED_PRODUCTS, listOfAddedPdoucts);
        repplyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, repplyIntent);
        Log.d(REPLY_CHEESE, String.format("send intent with %s", listNumber));
        finish();
    }

}
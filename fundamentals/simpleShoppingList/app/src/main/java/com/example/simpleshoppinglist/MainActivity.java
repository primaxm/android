package com.example.simpleshoppinglist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    public static final String VIEW_NUMBER_EXTRA = "ListNumber";
    public static final String LIST_OF_ADDED_PRODUCTS = "ListOfAddedProducts";
    Button chooseItemButton;
    private String freeView = String.valueOf(R.string.text_one);
    TextView one, two, three, four, five, six, seven, eight, nine, ten;
    private ArrayList<String> listOFAddedProducts = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chooseItemButton = findViewById(R.id.choose_item_btn);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ten = findViewById(R.id.ten);

        freeView = "one";

        if (savedInstanceState != null) {
            freeView = savedInstanceState.getString("free_view");
            listOFAddedProducts = savedInstanceState.getStringArrayList("listOFAddedProducts");
            if (savedInstanceState.getBoolean("reply_visble_one")) {
                one.setText(savedInstanceState.getString("reply_text_one"));
                one.setVisibility(View.VISIBLE);
                Log.d("ONE", one.getText().toString());
            }
            if (savedInstanceState.getBoolean("reply_visble_two")) {
                two.setText(savedInstanceState.getString("reply_text_two"));
                two.setVisibility(View.VISIBLE);
            }
            if (savedInstanceState.getBoolean("reply_visble_three")) {
                three.setText(savedInstanceState.getString("reply_text_three"));
                three.setVisibility(View.VISIBLE);
            }
            if (savedInstanceState.getBoolean("reply_visble_four")) {
                four.setText(savedInstanceState.getString("reply_text_four"));
                four.setVisibility(View.VISIBLE);
            }
            if (savedInstanceState.getBoolean("reply_visble_five")) {
                five.setText(savedInstanceState.getString("reply_text_five"));
                five.setVisibility(View.VISIBLE);
            }
            if (savedInstanceState.getBoolean("reply_visble_six")) {
                six.setText(savedInstanceState.getString("reply_text_six"));
                six.setVisibility(View.VISIBLE);
            }
            if (savedInstanceState.getBoolean("reply_visble_seven")) {
                seven.setText(savedInstanceState.getString("reply_text_seven"));
                seven.setVisibility(View.VISIBLE);
            }
            if (savedInstanceState.getBoolean("reply_visble_eight")) {
                eight.setText(savedInstanceState.getString("reply_text_eight"));
                eight.setVisibility(View.VISIBLE);
            }
            if (savedInstanceState.getBoolean("reply_visble_nine")) {
                nine.setText(savedInstanceState.getString("reply_text_nine"));
                nine.setVisibility(View.VISIBLE);
            }
            if (savedInstanceState.getBoolean("reply_visble_ten")) {
                ten.setText(savedInstanceState.getString("reply_text_ten"));
                ten.setVisibility(View.VISIBLE);
            }
        }

        chooseItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectItemActivity.class);
                intent.putExtra(VIEW_NUMBER_EXTRA, freeView);
                intent.putExtra(LIST_OF_ADDED_PRODUCTS, listOFAddedProducts);
                startActivityForResult(intent, TEXT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST && resultCode == RESULT_OK) {
            String viewNumberToSet = data.getStringExtra(VIEW_NUMBER_EXTRA);
            listOFAddedProducts = data.getStringArrayListExtra(LIST_OF_ADDED_PRODUCTS);
            String product = data.getStringExtra(SelectItemActivity.EXTRA_REPLY);

            boolean isAlreadySelect = false;
            for (String val: listOFAddedProducts) {
                if(val.equals(product)) {
                    isAlreadySelect = true;
                    break;
                }
            }

            if(!isAlreadySelect) {
                listOFAddedProducts.add(product);

                switch (viewNumberToSet) {
                    case "one":
                        one.setText(product);
                        one.setVisibility(View.VISIBLE);
                        freeView = "two";
                        break;
                    case "two":
                        two.setText(product);
                        two.setVisibility(View.VISIBLE);
                        freeView = "three";
                        break;
                    case "three":
                        three.setText(product);
                        three.setVisibility(View.VISIBLE);
                        freeView = "four";
                        break;
                    case "four":
                        four.setText(product);
                        four.setVisibility(View.VISIBLE);
                        freeView = "five";
                        break;
                    case "five":
                        five.setText(product);
                        five.setVisibility(View.VISIBLE);
                        freeView = "six";
                        break;
                    case "six":
                        six.setText(product);
                        six.setVisibility(View.VISIBLE);
                        freeView = "seven";
                        break;
                    case "seven":
                        seven.setText(product);
                        seven.setVisibility(View.VISIBLE);
                        freeView = "eight";
                        break;
                    case "eight":
                        eight.setText(product);
                        eight.setVisibility(View.VISIBLE);
                        freeView = "nine";
                        break;
                    case "nine":
                        nine.setText(product);
                        nine.setVisibility(View.VISIBLE);
                        freeView = "ten";
                        break;
                    case "ten":
                        ten.setText(product);
                        ten.setVisibility(View.VISIBLE);
                        freeView = "one";
                        break;
                    default:

                }
            } else {
                Toast.makeText(MainActivity.this, R.string.toast_messages_selected_product, Toast.LENGTH_LONG).show();
            }

        }
    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("free_view", freeView);
        savedInstanceState.putStringArrayList("listOFAddedProducts", listOFAddedProducts);
        if(one.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean("reply_visble_one", true);
            savedInstanceState.putString("reply_text_one", one.getText().toString());
        }
        if(two.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean("reply_visble_two", true);
            savedInstanceState.putString("reply_text_two", two.getText().toString());
        }
        if(three.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean("reply_visble_three", true);
            savedInstanceState.putString("reply_text_three", three.getText().toString());
        }
        if(four.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean("reply_visble_four", true);
            savedInstanceState.putString("reply_text_four", four.getText().toString());
        }
        if(five.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean("reply_visble_five", true);
            savedInstanceState.putString("reply_text_five", five.getText().toString());
        }
        if(six.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean("reply_visble_six", true);
            savedInstanceState.putString("reply_text_six", six.getText().toString());
        }
        if(seven.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean("reply_visble_seven", true);
            savedInstanceState.putString("reply_text_seven", seven.getText().toString());
        }
        if(eight.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean("reply_visble_eight", true);
            savedInstanceState.putString("reply_text_eight", eight.getText().toString());
        }
        if(nine.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean("reply_visble_nine", true);
            savedInstanceState.putString("reply_text_nine", nine.getText().toString());
        }
        if(ten.getVisibility() == View.VISIBLE) {
            savedInstanceState.putBoolean("reply_visble_ten", true);
            savedInstanceState.putString("reply_text_ten", ten.getText().toString());
        }
    }
}
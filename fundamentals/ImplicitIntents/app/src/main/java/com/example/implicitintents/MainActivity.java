package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText websiteEdittext, locationEdittext, shareEdittext;
    private Button openWebsiteButton, openLocationButton, shareTextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        websiteEdittext = (EditText) findViewById(R.id.website_edittext);
        locationEdittext = (EditText) findViewById(R.id.location_edittext);
        shareEdittext = (EditText) findViewById(R.id.share_edittext);
        openWebsiteButton = (Button) findViewById(R.id.open_website_button);
        openLocationButton = (Button) findViewById(R.id.open_location_button);
        shareTextButton = (Button) findViewById(R.id.share_text_button);

        openWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = websiteEdittext.getText().toString();
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can`t handle this intent!");
                }
            }
        });

        openLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loc = locationEdittext.getText().toString();
                Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can`t handle this intent!");
                }
            }
        });

        shareTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = shareEdittext.getText().toString();
                String mimeType = "text/plain";
                new ShareCompat.IntentBuilder(MainActivity.this).setType(mimeType).setChooserTitle("Share this text with: ")
                        .setText(txt).startChooser();
            }
        });
    }
}
package edu.monash.fit2081.countryinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WebWiki extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_wiki);

        // change the toolbar name to "Wikipedia Details" in strings.xml
        getSupportActionBar().setTitle(R.string.title_activity_web_wiki);

        // get the country name that is passed from CountryDetails
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("key");

        // web view to Wikipedia
        WebView webView = findViewById(R.id.webWiki);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://en.wikipedia.org/wiki/" + name);

        // go back to Country Details when click on floating action button
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CountryDetails.class);
                intent.putExtra("country", name);
                startActivity(intent);
                finish();
            }
        });
    }
}

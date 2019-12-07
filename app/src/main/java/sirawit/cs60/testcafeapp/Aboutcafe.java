package sirawit.cs60.testcafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Aboutcafe extends AppCompatActivity {

    TextView localTextView,telTextView, fbTextView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutcafe);

        fbTextView = findViewById(R.id.tv_fb);
        fbTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fbIntent = new Intent(Intent.ACTION_VIEW);
                fbIntent.setData(Uri.parse("https://www.facebook.com/indicatcafebkk/"));
                startActivity(fbIntent);
            }
        });
        localTextView = findViewById(R.id.tv_add);
        final Uri location = Uri.parse("http://maps.google.com/maps?z=10&q=loc:13.786702,100.488942('อินดี้แมวคาเฟ่')");
        localTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent localIntent = new Intent(Intent.ACTION_VIEW,location);
                localIntent.setPackage("com.google.android.apps.maps");
                startActivity(localIntent);
            }
        });
        telTextView = findViewById(R.id.tv_tell);
        telTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telIntent = new Intent(Intent.ACTION_DIAL);
                telIntent.setData(Uri.parse("tel:090 887 9960"));
                startActivity(telIntent);
            }
        });
        backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

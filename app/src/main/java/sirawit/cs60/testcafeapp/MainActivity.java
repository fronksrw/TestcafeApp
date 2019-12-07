package sirawit.cs60.testcafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button aboutcafeButton;
    int[] ints = new int[]{R.drawable.cat_01,R.drawable.cat_02,
            R.drawable.cat_03,R.drawable.cat_04,R.drawable.cat_05,};
    ListView listView;
    String[] titleStrings, detailStrings, subStrings;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutcafeButton = findViewById(R.id.btn_aboutcafe);
        listView = findViewById(R.id.list_view);

        titleStrings = getResources().getStringArray(R.array.titile);
        detailStrings = getResources().getStringArray(R.array.detail);

        subStrings = new String[detailStrings.length];
        for (int i = 0; i < detailStrings.length; i++) {
            subStrings[i] = detailStrings[i].substring(0, 20) + "....";

        }
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, ints, titleStrings, subStrings);
        listView.setAdapter(myAdapter);
        //กำหนดให้คลิก Item แล้วเปิดไปหน้า Detail
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("Title", titleStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Icon", ints[i]);
                startActivity(intent);
            }
        });
        aboutcafeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboucafeIntent = new Intent(MainActivity.this, Aboutcafe.class);
                startActivity(aboucafeIntent);
            }
        });


    }
}

package com.lazday.retrofit.second;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.lazday.retrofit.R;
import com.lazday.retrofit.network.Constant;
import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        bundle = getIntent().getExtras();

        textView.setText(bundle.getString( getString(R.string.intent_overview) ));
        Picasso.get().load(Constant.BACKDROP_PATH + bundle.getString(getString(R.string.intent_backdrop_path)))
                .placeholder(R.drawable.ic_placeholder).into(imageView);

        getSupportActionBar().setTitle( bundle.getString( getString(R.string.intent_title) ) );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}

package com.nizardan.tugasakhir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Detail extends AppCompatActivity {

    public static String EXTRA_PHOTO = "photo";
    public static String EXTRA_NAME = "nama";
    public static String EXTRA_DESC = "desc";

    TextView name, desc;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Detail");

        imageView = findViewById(R.id.img_item_photo);
        name = findViewById(R.id.nama_wisata);
        desc = findViewById(R.id.desc_wisata);


        String nama = getIntent().getStringExtra(EXTRA_NAME);
        String desk = getIntent().getStringExtra(EXTRA_DESC);
        String photo = getIntent().getStringExtra(EXTRA_PHOTO);


        name.setText(nama);
        desc.setText(desk);
        Glide.with(this).load(photo).apply( new RequestOptions().override(200,300)).into(imageView);


    }

}

package com.nizardan.tugasakhir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvWisata;
    private ArrayList<Wisata> list = new ArrayList<>();


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Wisata Pekalongan");

        rvWisata = findViewById(R.id.rv_wisata);
        rvWisata.setHasFixedSize(true);

        list.addAll(DataWisata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        ListDataAdapter listDataAdapter = new ListDataAdapter(list);
        rvWisata.setAdapter(listDataAdapter);

        listDataAdapter.setOnItemClickCallBack(new ListDataAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Wisata data) {
                showSelectedWisata(data);
            }
        });

    }

    private void showSelectedWisata(Wisata data) {
        Intent intent = new Intent(MainActivity.this, Detail.class);
        intent.putExtra(Detail.EXTRA_PHOTO, data.getPhoto());
        intent.putExtra(Detail.EXTRA_NAME, data.getName());
        intent.putExtra(Detail.EXTRA_DESC, data.getDesc());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

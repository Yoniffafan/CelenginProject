package me.yoniffafan.android.celengin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MimpiActivity extends AppCompatActivity {
    Button tambah;
    EditText mimpi, total, gambar;
    Data data;

    public List<String> mimpiList;
    public List<String> gambarList;
    public List<Integer> totalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mimpi);

        mimpiList = new ArrayList<>();
        gambarList = new ArrayList<>();
        totalList = new ArrayList<>();

        tambah = (Button) findViewById(R.id.btn_add_mimpi);
        mimpi = (EditText) findViewById(R.id.mimpi);
        total = (EditText) findViewById(R.id.total);
        gambar = (EditText) findViewById(R.id.gambar);
        data = new Data();

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mimpiList.add(mimpi.getText().toString());
                gambarList.add(gambar.getText().toString());
                totalList.add(Integer.parseInt(total.getText().toString()));
//                data.setGambar(gambar.getText().toString());
//                data.setMimpi(mimpi.getText().toString());
//                data.setTotal(Integer.parseInt(total.getText().toString()));
                data.setGambar(gambarList);
                data.setMimpi(mimpiList);
                data.setTotal(totalList);
//                finish();
                startActivity(new Intent(MimpiActivity.this, MainActivity.class));
            }
        });
    }
}

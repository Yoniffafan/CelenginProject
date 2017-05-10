package me.yoniffafan.android.celengin;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;

    List<String> gambar, mimpi;
    List<Integer> total;

    Context mContext = this;
    MyListAdapter adapter;
    EditText pemasukan, tambahMimpi, tambahTotal, tambahGambar;
    Button tambah, tambahBtn;
    Dialog dialog;
    Dialog tambahDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mimpi = new ArrayList<>();
        gambar = new ArrayList<>();
        total = new ArrayList<>();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        listView = (ListView) findViewById(R.id.listview);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        tambah = (Button) dialog.findViewById(R.id.simpan);
        pemasukan = (EditText) dialog.findViewById(R.id.pemasukan);

        tambahDialog = new Dialog(this);
        tambahDialog.setContentView(R.layout.dialog_tambah);
        tambahMimpi = (EditText) tambahDialog.findViewById(R.id.mimpi);
        tambahGambar = (EditText) tambahDialog.findViewById(R.id.gambar);
        tambahTotal = (EditText) tambahDialog.findViewById(R.id.total);
        tambahBtn = (Button) tambahDialog.findViewById(R.id.btn_add_mimpi);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        updateUI();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahDialog.show();
                tambahBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mimpi.add(tambahMimpi.getText().toString());
                        gambar.add(tambahGambar.getText().toString());
                        total.add(Integer.parseInt(tambahTotal.getText().toString()));
                        tambahDialog.dismiss();
                        updateUI();
                    }
                });
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                dialog.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_save) {
            // Handle the camera action
        } else if (id == R.id.nav_impian) {

        } else if (id == R.id.nav_pengeluaran) {

        } else if (id == R.id.nav_calendar) {

        } else if (id == R.id.nav_history) {

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_logout){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void updateUI() {
        MyListAdapter adapter = new MyListAdapter(gambar, mimpi, total, mContext);
        listView.setAdapter(adapter);
    }
}

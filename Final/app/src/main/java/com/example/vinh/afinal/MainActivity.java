package com.example.vinh.afinal;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.vinh.afinal.Adapter.ListViewAdapter;
import com.example.vinh.afinal.Model.ItemContent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,Serializable {
    public static final String KEY_BUNDLE = "key_bundle";
    ItemContent itemContent;
    ArrayList<ItemContent> arrlist69;
    ArrayList<ItemContent.Chapter> superChapter;

    public ArrayList<ItemContent.Chapter> getSuperChapter() {
        return superChapter;
    }

    public void setSuperChapter(ArrayList<ItemContent.Chapter> superChapter) {
        this.superChapter = superChapter;
    }

    ListView lv,lv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//23232323232
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new readJSON().execute("https://api.myjson.com/bins/2mhru");
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class readJSON extends AsyncTask<String, Integer, String > {

        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            arrlist69 = new ArrayList<>();
            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                    arrlist69.add(new ItemContent(
//                            jsonObject.getString("title"),
//                            jsonObject.getString("content"),
//                            jsonObject.getString("image"),
//                          for(int j=0;j<jsonObject.getJSONArray("").length();j++){
//
//                    }
//                    ));

                    itemContent = new ItemContent();
                    itemContent.setTitle(jsonObject.getString("title"));
                    itemContent.setContent(jsonObject.getString("content"));
                    itemContent.setImage(jsonObject.getString("image"));

                    ArrayList<ItemContent.Chapter> listChapter = new ArrayList<>();
                    for (int j= 0;j<jsonObject.getJSONArray("chapter").length();j++){

                        ItemContent.Chapter chapter = new ItemContent.Chapter();
                        chapter.setTitleC(jsonObject.getJSONArray("chapter").getJSONObject(j).getString("titlec"));
                        chapter.setLink(jsonObject.getJSONArray("chapter").getJSONObject(j).getString("link"));

                        listChapter.add(chapter);
                    }
                    itemContent.setListChapter(listChapter);
                    arrlist69.add(itemContent);
                }

                ListViewAdapter adapter69 = new ListViewAdapter(arrlist69,getApplicationContext());
                lv = (ListView)findViewById(R.id.lstChapter);
                lv.setAdapter(adapter69);

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ItemContent itemContent = arrlist69.get(position);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(KEY_BUNDLE,itemContent);
                        Intent intent =  new Intent(MainActivity.this, ChapterActivity.class);
//                        intent.putParcelableArrayListExtra("ok", (ArrayList<? extends Parcelable>) itemContent.getListChapter());
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();

//                        superChapter.add(itemContent.getListChapter());
//                        superChapter = new ArrayList<ItemContent.Chapter>();
//                        superChapter.equals(itemContent.getListChapter());
//                        ChapterAdapter chapterAdapter = new ChapterAdapter(itemContent.getListChapter(),getApplicationContext());
////                        Toast.makeText(MainActivity.this, ""+itemContent.getListChapter(), Toast.LENGTH_SHORT).show();
//                        lv2=(ListView)findViewById(R.id.lstSuperChapter1);
//                        lv2.setAdapter(chapterAdapter);
//                        ChapterAdapter adapter = new ChapterAdapter(arrlist69,getApplicationContext());
//                        lv2=(ListView)findViewById(R.id.lstSuperChapter1);
//                        lv2.setAdapter(adapter);
                    }
                });

//                detailFragmentChapter.getListView69().setAdapter(adapter69);
            } catch (JSONException e) {
                e.printStackTrace();
            }
//            Toast.makeText(getApplicationContext(), ""+s, Toast.LENGTH_SHORT).show();
        }

    }
    private static String docNoiDung_Tu_URL(String theUrl) {
        StringBuilder content = new StringBuilder();

        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

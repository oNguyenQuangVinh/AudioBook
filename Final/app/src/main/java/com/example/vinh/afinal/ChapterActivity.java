package com.example.vinh.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vinh.afinal.Adapter.ChapterAdapter;
import com.example.vinh.afinal.Model.ItemContent;

import java.util.ArrayList;

public class ChapterActivity extends AppCompatActivity{

    ItemContent itemContent;
    ArrayList<ItemContent.Chapter> arrayList ;

    private ListView lv;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        itemContent = (ItemContent)getIntent().getExtras().getSerializable(MainActivity.KEY_BUNDLE);
//        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        if(getSupportActionBar()!=null){
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//        }
//        arrayList = (ArrayList<ItemContent.Chapter extends Parcelable >) getIntent().getParcelableArrayListExtra("ok");
        init();
    }

    private void init() {
        lv = (ListView)findViewById(R.id.lstSuperChapter);
        textView = (TextView)findViewById(R.id.textView3);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChapterActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
//        textView.setText(itemContent.getTitle());
////        setArrayList((ArrayList<ItemContent.Chapter>) itemContent.getList());
//        arrayList = (ArrayList<ItemContent.Chapter>) itemContent.getListChapter();
        ChapterAdapter adapter = new ChapterAdapter(itemContent.getListChapter(),getApplicationContext());

//        Toast.makeText(getApplicationContext(),""+arrayList.size(),Toast.LENGTH_SHORT).show();
        lv.setAdapter(adapter);
//        AdapterView
//        ListViewAdapter adapter = new ListViewAdapter(arrayList,getApplicationContext());
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId()==android.R.id.home)
//            finish();
//        return super.onOptionsItemSelected(item);
//    }
}

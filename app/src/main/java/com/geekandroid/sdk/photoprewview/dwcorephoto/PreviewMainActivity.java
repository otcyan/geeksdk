package com.geekandroid.sdk.photoprewview.dwcorephoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.geekandroid.sdk.photoprewview.adapter.MainListAdapter;
import com.geekandroid.sdk.photoprewview.model.MainInfo;
import com.geekandroid.sdk.sample.R;

import java.util.ArrayList;


public class PreviewMainActivity extends BasePhotoPrewviewActivity implements  AdapterView.OnItemClickListener{

    private ListView main_list;
    private MainListAdapter adapter;
    private ArrayList<MainInfo> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_list);
        findID();
        inData();
        adapter = new MainListAdapter(this,data);
        main_list.setAdapter(adapter);
        AddToolbar();
    }

    protected void findID(){
        main_list = (ListView)findViewById(R.id.main_list);
        main_list.setOnItemClickListener(this);
    }

    protected void inData() {
        data = new ArrayList<MainInfo>();
        MainInfo info = new MainInfo();
        info.content = "SingleShow";
        data.add(info);

        MainInfo info1 = new MainInfo();
        info1.content = "TableViewShow";
        data.add(info1);

        MainInfo info2 = new MainInfo();
        info2.content = "CollectionShow";
        data.add(info2);

        MainInfo info3 = new MainInfo();
        info3.content = "MixShow";
        data.add(info3);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (position){
            case 0:
                intent = new Intent(PreviewMainActivity.this,SingleShow.class);
                break;
            case 1:
                intent = new Intent(PreviewMainActivity.this,ListViewActivity .class);
                break;
            case 2:
                intent = new Intent(PreviewMainActivity.this,GridViewActivity.class);
                break;
            case 3:
                intent = new Intent(PreviewMainActivity.this,MixShowActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

}

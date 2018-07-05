package com.aiwinn.orange.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aiwinn.orange.R;
import com.aiwinn.orange.adapter.GirlAdapter;
import com.aiwinn.orange.bean.Girl;
import com.aiwinn.orange.dagger.GirlPrecenterModule;
import com.aiwinn.orange.presenter.DaggerGirlComponent;
import com.aiwinn.orange.presenter.GirlPresenter;
import com.aiwinn.orange.screen_match.ScreenActivity;
import com.aiwinn.orange.view.IGirlView;
import com.sj.mycore.net.rx.databus.RxBus;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IGirlView {

    ListView listView;
    GirlAdapter adapter;

    @Inject
    GirlPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mian);
        listView = findViewById(R.id.listview);
//        precenter=new GirlPrecenter(this);
//        new GirlPrecenter(this).fetch();


        DaggerGirlComponent
                .builder()
                .girlPrecenterModule(new GirlPrecenterModule(this))
                .build()
                .inject(this);
        RxBus.getInstance().register(presenter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unRegister(presenter);
    }

    @Override
    public void showGirls(List<Girl> girls) {
        //model层的数据在girls中返回了
        adapter = new GirlAdapter(this, girls);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listener);
    }

    AdapterView.OnItemClickListener listener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            startActivity(new Intent(MainActivity.this, ScreenActivity.class));
        }
    };

}

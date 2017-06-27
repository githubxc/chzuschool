package com.example.chzuschool;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.chzuschool.entity.UrlEntity;
import com.example.chzuschool.fragment.FragmentOfChange;
import com.example.chzuschool.fragment.HomeOfWebView;
import com.example.chzuschool.receiver.MyNetworkReceiver;
import com.example.materialtest.R;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private FragmentOfChange fragmentOfChange;
    private ActionBar actionBar;
    private Toolbar toolbar;
    private NavigationView navView;
    MyNetworkReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();

        fragmentChange(new HomeOfWebView());//设置首页

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        navView.setCheckedItem(R.id.nav_sy);//侧边栏监听
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //设置页面跳转
                mDrawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.nav_sy://首页
                        fgClick(item.getTitle(), UrlEntity.indexUrl);
                        break;
                    case R.id.nav_xxjj://简介
                        fgClick(item.getTitle(), UrlEntity.xxjjUrl);
                        break;
                    case R.id.nav_czxw://滁中新闻
                        fgClick(item.getTitle(),UrlEntity.czxwUrl);
                        break;
                    case R.id.nav_xwgk://校务管理
                        fgClick(item.getTitle(), UrlEntity.xwgkUrl);
                        break;
                    case R.id.nav_dqgz://党群工作
                        fgClick(item.getTitle(), UrlEntity.dqgzUrl);
                        break;
                    case R.id.nav_dytd://德育天地
                        fgClick(item.getTitle(), UrlEntity.dytdUrl);
                        break;
                    case R.id.nav_jxzh://教学纵横
                        fgClick(item.getTitle(), UrlEntity.jxzhUrl);
                        break;
                    case R.id.nav_jyky://教育科研
                        fgClick(item.getTitle(), UrlEntity.jykyUrl);
                        break;
                    case R.id.nav_hqfw://后勤服务
                        fgClick(item.getTitle(), UrlEntity.hqwfUrl);
                        break;
                    case R.id.nav_xyaq://校园安全
                        fgClick(item.getTitle(), UrlEntity.xyaqUrl);
                        break;
                    case R.id.nav_jzxx://家长学校
                        fgClick(item.getTitle(), UrlEntity.jzxxUrl);
                        break;
                    case R.id.nav_zszp://招生招聘
                        fgClick(item.getTitle(), UrlEntity.zszpUrl);
                        break;
                }

                return true;
            }
        });

    }

    private void initView(){
        //获取控件
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.nav_view);
    }

    private void initData(){

        //注册网络监听广播
        receiver = new MyNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver,intentFilter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this, "You clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    /**
     * 页面变换
     * @param fragment
     */
    private void fragmentChange(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment).commit();
    }

    /**
     * 返回监听，如果是webview返回至前一页
     */
    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }


    private void fgClick(CharSequence title, String url){
        actionBar.setTitle(title);
        fragmentOfChange = new FragmentOfChange();
        fragmentOfChange.FragmentOfChange(url);
        fragmentChange(fragmentOfChange);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}

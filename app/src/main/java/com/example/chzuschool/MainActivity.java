package com.example.chzuschool;

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
import com.example.chzuschool.fragment.HomeOfWebView;
import com.example.materialtest.R;
import com.example.chzuschool.fragment.FragmentOfXxjj;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private FragmentOfXxjj fragmentOfXxjj;
    private ActionBar actionBar;
    private Toolbar toolbar;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();

        fragmentChange(new HomeOfWebView());

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        navView.setCheckedItem(R.id.nav_sy);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                mDrawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.nav_sy:
                        fgClick(item.getTitle(), UrlEntity.indexUrl);
                        break;
                    case R.id.nav_xxjj:
                        fgClick(item.getTitle(), UrlEntity.xxjjUrl);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_czxw:
                        fgClick(item.getTitle(),UrlEntity.czxwUrl);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_xwgk:
                        fgClick(item.getTitle(), UrlEntity.xwgkUrl);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_dqgz:
                        fgClick(item.getTitle(), UrlEntity.dqgzUrl);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_dytd:
                        fgClick(item.getTitle(), UrlEntity.dytdUrl);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_jxzh:
                        fgClick(item.getTitle(), UrlEntity.jxzhUrl);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_jyky:
                        fgClick(item.getTitle(), UrlEntity.jykyUrl);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_hqfw:
                        fgClick(item.getTitle(), UrlEntity.hqwfUrl);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_xyaq:
                        fgClick(item.getTitle(), UrlEntity.xyaqUrl);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_jzxx:
                        fgClick(item.getTitle(), UrlEntity.jzxxUrl);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_zszp:
                        fgClick(item.getTitle(), UrlEntity.zszpUrl);
                        Toast.makeText(MainActivity.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
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

    private void fragmentChange(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment).commit();
    }

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
        fragmentOfXxjj = new FragmentOfXxjj();
        fragmentOfXxjj.FragmentOfXxjj(url);
        fragmentChange(fragmentOfXxjj);
    }

}

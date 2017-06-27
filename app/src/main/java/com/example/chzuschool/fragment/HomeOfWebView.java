package com.example.chzuschool.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.chzuschool.entity.UrlEntity;
import com.example.materialtest.R;
import com.example.chzuschool.utils.WebViewUtils;

/**
 * Created by XC on 2017/6/21.
 */

public class HomeOfWebView extends Fragment {

    private WebViewUtils webViewUtils;

    private WebView webView;

    private WebSettings webSettings;

    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.webview_home, container, false);

        initView();

        initData();

        return v;
    }

    private void initView(){
        webView = (WebView) v.findViewById(R.id.home_webview);
        webSettings = webView.getSettings();
    }

    private void initData(){

        webView.setWebViewClient(new webViewClient());
        webViewUtils = new WebViewUtils(webView, webSettings);
        webView.loadUrl(UrlEntity.indexUrl);

        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {  //表示按返回键
                        webView.goBack();   //后退
                        //webview.goForward();//前进
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
    }


    private class webViewClient extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

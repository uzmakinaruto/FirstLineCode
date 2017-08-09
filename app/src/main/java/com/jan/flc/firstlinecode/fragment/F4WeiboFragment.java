package com.jan.flc.firstlinecode.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.data.DouyuF4;

/**
 * Created by huangje on 17-3-14.
 */

public class F4WeiboFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int id = getArguments().getInt("Id");
        View root = inflater.inflate(R.layout.fragment_f4weibo, container, false);
        WebView webView = (WebView) root.findViewById(R.id.wv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(DouyuF4.WEIBO_URLS[id]);
        return root;
    }
}

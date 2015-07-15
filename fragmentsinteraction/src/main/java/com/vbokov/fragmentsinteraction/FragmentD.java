package com.vbokov.fragmentsinteraction;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by vladimirbokov on 15/07/15.
 */
public class FragmentD extends Fragment {

    private static WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d,
                container, false);
        webView = (WebView) view.findViewById(R.id.webView);

        return view;
    }

    public void showWebPage(String url) {
        webView.setWebViewClient(new InnerWebViewClient());
        webView.loadUrl(url);
    }

    /* To ensure links open within the application */
    private class InnerWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}

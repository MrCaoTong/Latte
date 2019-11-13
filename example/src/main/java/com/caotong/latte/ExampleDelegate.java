package com.caotong.latte;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.latte.core.delegates.LatteDelegate;
import com.latte.core.global.Latte;
import com.latte.core.net.RestClient;
import com.latte.core.net.callback.IError;
import com.latte.core.net.callback.IFailure;
import com.latte.core.net.callback.IRequest;
import com.latte.core.net.callback.ISuccess;

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.example_delegate;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @Nullable View rootView) {
        testBuilder();
    }

    public void testBuilder() {
        RestClient
                .builder()
                .url("https://www.baidu.com/")
                .request(new IRequest() {
                    @Override
                    public void onRequestStart() {
                        Log.i("request:", " start ");
                    }

                    @Override
                    public void onRequestEnd() {

                    }
                })
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Log.i("error:", msg + " ");
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.i("failure:", "");
                    }
                })
                .build()
                .get();
    }
}

package com.caotong.latte;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.latte.core.delegates.LatteDelegate;

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.example_delegate;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @Nullable View rootView) {

    }
}

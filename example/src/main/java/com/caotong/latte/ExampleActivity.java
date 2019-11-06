package com.caotong.latte;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.latte.core.activitys.ProxyActivity;
import com.latte.core.delegates.LatteDelegate;


public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }


}

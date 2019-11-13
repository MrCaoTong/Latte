package com.caotong.latte;

import com.latte.core.activitys.ProxyActivity;
import com.latte.core.delegates.LatteDelegate;


public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}

package com.latte.core.global;

import android.app.Application;
import android.content.Context;

public final class Latte {

    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfigurator(key);
    }

    public static Application getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }
}

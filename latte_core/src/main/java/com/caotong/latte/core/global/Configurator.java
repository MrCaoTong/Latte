package com.caotong.latte.core.global;

import java.util.HashMap;

public final class Configurator {
    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>();

    private Configurator() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), false);
    }

    static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    final HashMap<Object, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    public final void configure() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), true);
    }

    private void checkConfigurator() {
        boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configurator is not ready,call Configure");
        }
    }

    final <T> T getConfigurator(Object key) {
        checkConfigurator();
        final Object value = LATTE_CONFIGS.get(key);
        if(value == null){
            throw new NullPointerException(key.toString()+" IS NULL " );
        }
        return (T) value;
    }
}

package com.latte.core.global;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

public final class Configurator {
    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

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
        initIcons();
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigKeys.API_HOST.name(), host);
        return this;
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer iconifyInitializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                iconifyInitializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
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
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL ");
        }
        return (T) value;
    }
}

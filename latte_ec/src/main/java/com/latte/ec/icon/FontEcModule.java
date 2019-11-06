package com.latte.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

public class FontEcModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return null;
    }

    @Override
    public Icon[] characters() {
        return EcIcons.values();
    }
}

package com.vgroupinc.assignment3.base;

import android.content.Context;
import android.support.annotation.Nullable;

/**
 * Created by DELL on 12/12/2017.
 */

public class BoldTextView extends android.support.v7.widget.AppCompatTextView {
    public BoldTextView(Context context) {
        super(context);
    }

    @Override
    public void setFontFeatureSettings(@Nullable String fontFeatureSettings) {
        super.setFontFeatureSettings(fontFeatureSettings);
    }
}

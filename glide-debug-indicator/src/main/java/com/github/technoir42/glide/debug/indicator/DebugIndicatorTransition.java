package com.github.technoir42.glide.debug.indicator;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

import androidx.annotation.ColorInt;
import androidx.annotation.Px;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

final class DebugIndicatorTransition implements Transition<Drawable> {
    private static final float DEFAULT_INDICATOR_SIZE_DP = 16.0f;

    private final DataSource dataSource;
    private final int indicatorSize;

    DebugIndicatorTransition(DataSource dataSource, @Px int indicatorSize) {
        this.dataSource = dataSource;
        this.indicatorSize = indicatorSize;
    }

    @Override
    public boolean transition(Drawable current, ViewAdapter adapter) {
        int indicatorColor = getIndicatorColor(dataSource);
        int indicatorSize = this.indicatorSize;
        if (indicatorSize == -1) {
            indicatorSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_INDICATOR_SIZE_DP,
                    adapter.getView().getResources().getDisplayMetrics());
        }
        adapter.setDrawable(new DebugIndicatorDrawable(current, indicatorColor, indicatorSize));
        return true;
    }

    @ColorInt
    private int getIndicatorColor(DataSource dataSource) {
        switch (dataSource) {
            case LOCAL:
                return Color.YELLOW;
            case REMOTE:
                return Color.RED;
            case DATA_DISK_CACHE:
            case RESOURCE_DISK_CACHE:
                return 0xff0066ff;
            case MEMORY_CACHE:
                return Color.GREEN;
            default:
                throw new AssertionError("Unhandled enum value " + dataSource);
        }
    }
}

package com.github.technoir42.glide.debug.indicator;

import android.graphics.drawable.Drawable;

import androidx.annotation.Px;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.TransitionFactory;

public final class DebugIndicatorTransitionFactory implements TransitionFactory<Drawable> {
    public static final DebugIndicatorTransitionFactory DEFAULT = new DebugIndicatorTransitionFactory();

    private final int indicatorSize;

    private DebugIndicatorTransitionFactory() {
        this.indicatorSize = -1;
    }

    public DebugIndicatorTransitionFactory(@Px int indicatorSize) {
        if (indicatorSize <= 0) {
            throw new IllegalArgumentException("indicatorSize must be greater than 0, but was " + indicatorSize);
        }
        this.indicatorSize = indicatorSize;
    }

    @Override
    public Transition<Drawable> build(DataSource dataSource, boolean isFirstResource) {
        return new DebugIndicatorTransition(dataSource, indicatorSize);
    }
}

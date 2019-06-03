@file:JvmName("-Extensions")

package com.github.technoir42.glide.debug.indicator

import android.graphics.drawable.Drawable
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun GlideBuilder.enableDebugIndicators(): GlideBuilder {
    return setDefaultTransitionOptions(Drawable::class.java, DrawableTransitionOptions.with(DebugIndicatorTransitionFactory.DEFAULT))
}

fun <T : RequestBuilder<Drawable>> T.withDebugIndicator(): T {
    @Suppress("UNCHECKED_CAST")
    return transition(DrawableTransitionOptions.with(DebugIndicatorTransitionFactory.DEFAULT)) as T
}

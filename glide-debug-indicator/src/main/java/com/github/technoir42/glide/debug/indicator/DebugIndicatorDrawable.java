package com.github.technoir42.glide.debug.indicator;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.Px;
import androidx.appcompat.graphics.drawable.DrawableWrapper;

@SuppressLint("RestrictedApi")
final class DebugIndicatorDrawable extends DrawableWrapper {
    private final Matrix currentMatrix = new Matrix();
    private final Matrix inverseMatrix = new Matrix();
    private final Paint paint = new Paint();
    private final Path triangle;
    private final int indicatorSize;

    DebugIndicatorDrawable(Drawable drawable, @ColorInt int indicatorColor, @Px int indicatorSize) {
        super(drawable);
        this.indicatorSize = indicatorSize;
        paint.setColor(indicatorColor);
        triangle = createTriangle(indicatorSize);
    }

    @Override
    @SuppressLint("CanvasSize")
    @SuppressWarnings("deprecation")
    public void draw(Canvas canvas) {
        super.draw(canvas);

        int saveCount = canvas.save();

        // Set transformation matrix to identity
        canvas.getMatrix(currentMatrix);
        currentMatrix.invert(inverseMatrix);
        canvas.concat(inverseMatrix);

        canvas.translate(canvas.getWidth() - indicatorSize, 0.0f);
        canvas.drawPath(triangle, paint);

        canvas.restoreToCount(saveCount);
    }

    private Path createTriangle(float size) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(size, 0.0f);
        path.lineTo(size, size);
        path.close();
        return path;
    }
}

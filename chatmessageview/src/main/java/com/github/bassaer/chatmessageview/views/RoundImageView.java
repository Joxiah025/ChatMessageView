package com.github.bassaer.chatmessageview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.github.bassaer.chatmessageview.R;

/**
 * Round Image view for picture on message
 * Created by nakayama on 2017/03/08.
 */
public class RoundImageView extends ImageView {
    private Path mClipPath;

    public RoundImageView(Context context) {
        super(context);
        initClipPath();
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initClipPath();
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initClipPath();
    }

    private void initClipPath() {
        mClipPath = new Path();
        RectF rect = new RectF(0, 0, getWidth(), getHeight());
        float radius = getResources().getDimensionPixelSize(R.dimen.view_radius_normal);
        mClipPath.addRoundRect(rect, radius, radius, Path.Direction.CW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initClipPath();
        canvas.clipPath(mClipPath);
        super.onDraw(canvas);
    }
}
package com.example.formhelp.practical10;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

import com.example.formhelp.R;

public class CustomDrawableView extends View {
    private ShapeDrawable drawable;

    public CustomDrawableView(Context context) {
        super(context);

        int x = 10;
        int y = 10;
        int width = 300;
        int height = 50;
        setContentDescription(context.getResources().getString(
                R.string.my_view_desc));

        drawable = new ShapeDrawable(new OvalShape());
        // If the color isn't set, the shape uses black as the default.
        drawable.getPaint().setColor(0xff74AC23);
        // If the bounds aren't set, the shape can't be drawn.
        drawable.setBounds(x, y, x + width, y + height);
    }

    protected void onDraw(Canvas canvas) {
        drawable.draw(canvas);
    }
}
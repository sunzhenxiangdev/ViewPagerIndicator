package com.xiang.viewpagerindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by szx on 2017/09/12.
 * EMAIL:sunzhenxiangvip@gmail.com
 */

public class IndicatorView extends View implements ViewPager.OnPageChangeListener {

    private Path path;
    private Paint paint;
    private Paint bgPaint;

    private ViewPager vp;
    private int width;
    private int borderWidth = 10;
    //ViewPager滚动时偏移量
    private int offsetX = 0;
    private int borderColder = Color.RED;
    private int bgColor = Color.parseColor("#662b2b2b");

    private int triangleWidth = 30;//三角形高度

    ///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////

    public IndicatorView(Context context) {
        super(context);
        init();
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }
    ///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w / getViewPagerCount();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSize = borderWidth + 30;
        int measureSpec = MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, measureSpec);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        myDraw(canvas);

    }

    ///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 进行必要初始化
     */
    private void init() {
        path = new Path();
        paint = new Paint();
        paint.setColor(borderColder);
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

        bgPaint = new Paint();
        bgPaint.setColor(bgColor);
        bgPaint.setStrokeWidth(1);
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.FILL);

    }

    private void myDraw(Canvas canvas) {
        path.reset();//清屏
        //绘制背景指示线
        //先绘制高亮线左边
        canvas.drawRect(0, getHeight() - borderWidth, offsetX , getHeight(), bgPaint);
        //再绘制高亮线右边
        canvas.drawRect(offsetX + width, getHeight() - borderWidth, getWidth(), getHeight(), bgPaint);

        //绘制高亮指示线
        path.moveTo(offsetX, getHeight() - borderWidth);
        path.lineTo(offsetX + width / 2 - triangleWidth, getHeight() - borderWidth);
        path.lineTo(offsetX + width / 2, getHeight() - borderWidth - triangleWidth);
        path.lineTo(offsetX + width / 2 + triangleWidth, getHeight() - borderWidth);
        path.lineTo(offsetX + width, getHeight() - borderWidth);

        path.lineTo(offsetX + width, getHeight());
        path.lineTo(offsetX + width / 2 + triangleWidth, getHeight());
        path.lineTo(offsetX + width / 2, getHeight() - triangleWidth);
        path.lineTo(offsetX + width / 2 - triangleWidth, getHeight());
        path.lineTo(offsetX, getHeight());
        path.lineTo(offsetX, getHeight() - borderWidth);

        canvas.drawPath(path, paint);
//        path.close();


    }

    public void setViewPager(ViewPager vp) {
        this.vp = vp;
        this.vp.addOnPageChangeListener(this);
    }

    /**
     * 获取ViewPager当前位置
     */
    public int getViewPagerCurrentPosition() {
        if (null == vp) {
            return 0;
        }
        return vp.getCurrentItem();
    }

    /**
     * 获取ViewPager页面个数
     */
    public int getViewPagerCount() {
        if (null == vp) return 1;
        return vp.getAdapter().getCount();
    }

    /**
     * 设置线高度
     */
    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        invalidate();
    }

    public int getBorderColder() {
        return borderColder;
    }

    public void setBorderColder(int borderColder) {
        this.borderColder = borderColder;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    /**
     * 设置三角形高度
     */
    public void setTriangleWidth(int triangleWidth) {
        this.triangleWidth = triangleWidth;
        invalidate();
    }

    ///////////////////////////////////////////////////////////////////////////
    // 实现接口中的方法
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        offsetX = (int) (position * width + positionOffset * width);
        Log.e("TAG", "offsetX = " + offsetX);
        invalidate();
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

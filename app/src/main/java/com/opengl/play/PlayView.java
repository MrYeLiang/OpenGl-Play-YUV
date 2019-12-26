package com.opengl.play;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by yeliang on 2019/12/27.
 */

public class PlayView extends GLSurfaceView implements Runnable, SurfaceHolder.Callback,GLSurfaceView.Renderer {

    public PlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void run() {
        open("/storage/emulated/0/out.yuv", getHolder().getSurface());
    }

    public native void open(String url, Surface surfaceView);

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            setRenderer(this);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void startPlay() {
        new Thread(this).start();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {

    }
}

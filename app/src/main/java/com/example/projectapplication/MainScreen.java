package com.example.projectapplication;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

public class MainScreen extends AppCompatActivity
{
    private GLSurfaceView glSurfaceView;
    private MainMenuGLRenderer mainMenuGLRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mainMenuGLRenderer = new MainMenuGLRenderer(this);
        this.glSurfaceView = new MainGLSurfaceView(this);
        this.glSurfaceView.setRenderer(this.mainMenuGLRenderer);
        glSurfaceView.setBackgroundResource(R.drawable.background1);

        this.setContentView(this.glSurfaceView);
    }

    @Override
    protected void onPause()
    {
        // Call default Activity's onPause
        super.onPause();
        // gl's onPause method
        glSurfaceView.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        glSurfaceView.onResume();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        this.mainMenuGLRenderer.onTouchEvent(e.getX(), e.getY());
        return true;
    }
}

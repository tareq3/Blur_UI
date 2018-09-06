package com.mti.blur_ui;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.eightbitlab.supportrenderscriptblur.SupportRenderScriptBlur;

import eightbitlab.com.blurview.BlurView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        float radius = 2f;

        View decorView = getWindow().getDecorView();
        //ViewGroup you want to start blur from. Choose root as close to BlurView in hierarchy as possible.
        ViewGroup rootView = (ViewGroup) decorView.findViewById(R.id.container);
        //set background, if your root layout doesn't have one
        Drawable windowBackground = decorView.getBackground();

        BlurView blurView=findViewById(R.id.blurView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            blurView.setupWith(rootView)
                    .windowBackground(windowBackground)
                    .blurAlgorithm(new SupportRenderScriptBlur(this))
                    .blurRadius(radius)
                    .setHasFixedTransformationMatrix(true);

            ((BlurView) findViewById(R.id.blurView2)).setupWith(rootView).windowBackground(windowBackground).blurAlgorithm(new SupportRenderScriptBlur(this))
                    .blurRadius(radius)
                    .setHasFixedTransformationMatrix(true);

            ((BlurView) findViewById(R.id.blurview3)).setupWith(rootView).windowBackground(windowBackground).blurAlgorithm(new SupportRenderScriptBlur(this))
                    .blurRadius(radius)
                    .setHasFixedTransformationMatrix(true);
        }
    }
}

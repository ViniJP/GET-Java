package com.example.get;

import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class SlidesActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setButtonBackVisible(false);
        addSlide(new FragmentSlide.Builder()
                .background(R.color.branco)
                .fragment(R.layout.slide1)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(R.color.branco)
                .fragment(R.layout.slide2)
                .build()
        );

        addSlide(new FragmentSlide.Builder()
                .background(R.color.branco)
                .fragment(R.layout.slide3)
                .build()
        );

    }
}
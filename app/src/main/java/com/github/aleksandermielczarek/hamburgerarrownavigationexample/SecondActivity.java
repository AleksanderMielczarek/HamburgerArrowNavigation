package com.github.aleksandermielczarek.hamburgerarrownavigationexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.aleksandermielczarek.hamburgerarrownavigation.HamburgerArrowNavigation;
import com.github.aleksandermielczarek.hamburgerarrownavigation.HamburgerArrowNavigator;

/**
 * Created by Aleksander Mielczarek on 09.09.2016.
 */
public class SecondActivity extends AppCompatActivity {

    private HamburgerArrowNavigator hamburgerArrowNavigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        hamburgerArrowNavigator = HamburgerArrowNavigation.getDefault().getHamburgerArrowNavigator(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        hamburgerArrowNavigator.setupWithToolbar(toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        hamburgerArrowNavigator.animateToArrow();
    }

}

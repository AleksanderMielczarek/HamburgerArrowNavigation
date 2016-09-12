package com.github.aleksandermielczarek.hamburgerarrownavigationexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.github.aleksandermielczarek.hamburgerarrownavigation.HamburgerArrowNavigation;
import com.github.aleksandermielczarek.hamburgerarrownavigation.HamburgerArrowNavigator;

/**
 * Created by Aleksander Mielczarek on 09.09.2016.
 */
public class FirstActivity extends AppCompatActivity {

    private HamburgerArrowNavigator hamburgerArrowNavigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        hamburgerArrowNavigator = HamburgerArrowNavigation.getDefault().getHamburgerArrowNavigator(this);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        hamburgerArrowNavigator.setupWithToolbar(toolbar);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(FirstActivity.this, toolbar, "toolbar");
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent, options.toBundle());
            }
        });
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        hamburgerArrowNavigator.animateToHamburger();
    }

}


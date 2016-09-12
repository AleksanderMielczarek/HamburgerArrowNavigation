package com.github.aleksandermielczarek.hamburgerarrownavigation;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.view.animation.LinearInterpolator;

/**
 * Created by Aleksander Mielczarek on 09.09.2016.
 */
public class HamburgerArrowNavigator {

    public static final float SHOW_BURGER = 0.0f;
    public static final float SHOW_ARROW = 1.0f;

    private final long animationDuration;
    private final long delayDuration;
    private final DrawerArrowDrawable hamburgerArrowDrawable;
    private final HamburgerArrowNavigation hamburgerArrowNavigation;
    private final AppCompatActivity context;

    HamburgerArrowNavigator(AppCompatActivity context, long animationDuration, long delayDuration, HamburgerArrowNavigation hamburgerArrowNavigation) {
        this.context = context;
        this.delayDuration = delayDuration;
        this.animationDuration = animationDuration;
        hamburgerArrowDrawable = new DrawerArrowDrawable(context);
        this.hamburgerArrowNavigation = hamburgerArrowNavigation;
    }

    public void setupWithToolbar(Toolbar toolbar) {
        toolbar.setNavigationIcon(hamburgerArrowDrawable);
    }

    public void animateToArrowNow() {
        animateNow(SHOW_ARROW);
    }

    public void animateToHamburgerNow() {
        animateNow(SHOW_BURGER);
    }

    public void animateToArrow() {
        animate(SHOW_ARROW);
    }

    public void animateToHamburger() {
        animate(SHOW_BURGER);
    }

    public void animateToArrow(long delay) {
        animate(SHOW_ARROW, delay);
    }

    public void animateToHamburger(long delay) {
        animate(SHOW_BURGER, delay);
    }

    public void animateNow(float target) {
        animate(target, 0L);
    }

    public void animate(float target) {
        animate(target, delayDuration);
    }

    public void animate(float target, long delay) {
        hamburgerArrowNavigation.stopAnimations();
        if (isProgress(target)) {
            return;
        }
        final ValueAnimator anim = ValueAnimator.ofFloat(hamburgerArrowNavigation.getProgress(), target);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float slideOffset = (Float) valueAnimator.getAnimatedValue();
                hamburgerArrowDrawable.setProgress(slideOffset);
                hamburgerArrowNavigation.setProgress(slideOffset);
            }
        });
        anim.setInterpolator(new LinearInterpolator());
        anim.setDuration(animationDuration);
        hamburgerArrowNavigation.addValueAnimator(anim);
        context.getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                anim.start();
            }
        }, delay);
    }

    public void setProgress(float progress) {
        hamburgerArrowNavigation.stopAnimations();
        hamburgerArrowDrawable.setProgress(progress);
        hamburgerArrowNavigation.setProgress(progress);
    }

    public void setHamburger() {
        setProgress(SHOW_BURGER);
    }

    public void setArrow() {
        setProgress(SHOW_ARROW);
    }

    public boolean isProgress(float progress) {
        return Float.valueOf(progress).equals(hamburgerArrowNavigation.getProgress());
    }

    public boolean isArrow() {
        return isProgress(SHOW_ARROW);
    }

    public boolean isHamburger() {
        return isProgress(SHOW_BURGER);
    }

    public DrawerArrowDrawable getHamburgerArrowDrawable() {
        return hamburgerArrowDrawable;
    }

}

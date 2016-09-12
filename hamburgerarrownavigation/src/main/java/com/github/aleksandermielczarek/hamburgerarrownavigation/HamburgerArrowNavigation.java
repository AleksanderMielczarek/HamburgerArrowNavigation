package com.github.aleksandermielczarek.hamburgerarrownavigation;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Aleksander Mielczarek on 09.09.2016.
 */
public class HamburgerArrowNavigation {

    public static final long ANIMATION_DURATION = 600;
    public static final long DELAY_DURATION = 50;

    private static volatile HamburgerArrowNavigation defaultInstance;

    private final long animationDuration;
    private final long delayDuration;
    private float progress = HamburgerArrowNavigator.SHOW_BURGER;
    private final List<WeakReference<ValueAnimator>> valueAnimators = new ArrayList<>();

    private HamburgerArrowNavigation(Builder builder) {
        animationDuration = builder.animationDuration;
        delayDuration = builder.delayDuration;
    }

    public static HamburgerArrowNavigation getDefault() {
        if (defaultInstance == null) {
            synchronized (HamburgerArrowNavigation.class) {
                if (defaultInstance == null) {
                    defaultInstance = new Builder().build();
                }
            }
        }
        return defaultInstance;
    }

    public static void setDefault(HamburgerArrowNavigation defaultInstance) {
        HamburgerArrowNavigation.defaultInstance = defaultInstance;
    }

    public static Builder builder() {
        return new Builder();
    }

    public HamburgerArrowNavigator getHamburgerArrowNavigator(AppCompatActivity context) {
        return new HamburgerArrowNavigator(context, animationDuration, delayDuration, this);
    }

    void setProgress(float progress) {
        this.progress = progress;
    }

    float getProgress() {
        return progress;
    }

    void addValueAnimator(ValueAnimator valueAnimator) {
        WeakReference<ValueAnimator> valueAnimatorWeakReference = new WeakReference<>(valueAnimator);
        valueAnimators.add(valueAnimatorWeakReference);
    }

    public void stopAnimations() {
        Iterator<WeakReference<ValueAnimator>> iterator = valueAnimators.iterator();
        while (iterator.hasNext()) {
            WeakReference<ValueAnimator> valueAnimatorWeakReference = iterator.next();
            ValueAnimator valueAnimator = valueAnimatorWeakReference.get();
            if (valueAnimator != null) {
                valueAnimator.cancel();
                valueAnimator.removeAllUpdateListeners();
            }
            iterator.remove();
        }
    }

    public static class Builder {

        private long animationDuration = ANIMATION_DURATION;
        private long delayDuration = DELAY_DURATION;

        private Builder() {

        }

        public Builder animationDuration(long animationDuration) {
            this.animationDuration = animationDuration;
            return this;
        }

        public Builder delayDuration(long delayDuration) {
            this.delayDuration = delayDuration;
            return this;
        }

        public HamburgerArrowNavigation build() {
            return new HamburgerArrowNavigation(this);
        }
    }

}

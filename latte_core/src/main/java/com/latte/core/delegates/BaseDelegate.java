package com.latte.core.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragmentDelegate;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public abstract class BaseDelegate extends Fragment implements ISupportFragment {

    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState, @Nullable View rootView);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("type of setLayout() must be int or View!");
        }
        onBindView(savedInstanceState, rootView);
        return rootView;
    }


    @Override
    public SupportFragmentDelegate getSupportDelegate() {
        return null;
    }

    @Override
    public ExtraTransaction extraTransaction() {
        return null;
    }

    @Override
    public void enqueueAction(Runnable runnable) {

    }

    @Override
    public void post(Runnable runnable) {

    }

    @Override
    public void onEnterAnimationEnd(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onSupportVisible() {

    }

    @Override
    public void onSupportInvisible() {

    }

    @Override
    public boolean isSupportVisible() {
        return false;
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return null;
    }

    @Override
    public FragmentAnimator getFragmentAnimator() {
        return null;
    }

    @Override
    public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {

    }

    @Override
    public void setFragmentResult(int resultCode, Bundle bundle) {

    }

    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {

    }

    @Override
    public void onNewBundle(Bundle args) {

    }

    @Override
    public void putNewBundle(Bundle newBundle) {

    }

    @Override
    public boolean onBackPressedSupport() {
        return false;
    }
}

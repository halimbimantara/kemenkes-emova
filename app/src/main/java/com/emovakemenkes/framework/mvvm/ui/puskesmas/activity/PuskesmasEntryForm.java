package com.emovakemenkes.framework.mvvm.ui.puskesmas.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.androidnetworking.error.ANError;
import com.emovakemenkes.framework.mvvm.BR;
import com.emovakemenkes.framework.mvvm.R;
import com.emovakemenkes.framework.mvvm.ViewModelProviderFactory;
import com.emovakemenkes.framework.mvvm.databinding.ActivityPuskesmasEntryBinding;
import com.emovakemenkes.framework.mvvm.ui.base.BaseActivity;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.adapter.AdapterStepFormEntryPuskesmas;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.navigator.PuskesmasEntryNavigator;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.viewmodels.PuskesmasEntryFormViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class PuskesmasEntryForm extends BaseActivity<ActivityPuskesmasEntryBinding, PuskesmasEntryFormViewModel> implements PuskesmasEntryNavigator, HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProviderFactory factory;
    private PuskesmasEntryFormViewModel mViewModel;
    private ActivityPuskesmasEntryBinding mBinding;
    private int pageNumber = 0;
    private Context mContext;

    public static Intent newIntent(Context context) {
        return new Intent(context, PuskesmasEntryForm.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_puskesmas_entry;
    }

    @Override
    public PuskesmasEntryFormViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, factory).get(PuskesmasEntryFormViewModel.class);
        return mViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        mViewModel.setNavigator(this);
        mBinding.stepperLayout.setAdapter(new AdapterStepFormEntryPuskesmas(getSupportFragmentManager(), getBaseContext()));
    }

    @Override
    public void handleError(Throwable throwable, String TAG) {

    }

    @Override
    public void handleErrorNetwork(ANError anError, String TAG) {

    }

    @Override
    public void hideShimmer() {

    }

    @Override
    public void startShimmer() {

    }

    @Override
    public void ShowMessages(String title, String Messages, int type) {
        if (type == 1) {
            ShowMessages(this, title + "\n" + Messages);
        } else {
            ShowSnackBar(mBinding.root, title + "\n" + Messages);
        }
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}


package com.emovakemenkes.framework.mvvm.ui.puskesmas.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.androidnetworking.error.ANError;
import com.emovakemenkes.framework.mvvm.BR;
import com.emovakemenkes.framework.mvvm.R;
import com.emovakemenkes.framework.mvvm.ViewModelProviderFactory;
import com.emovakemenkes.framework.mvvm.databinding.FragmentStepOneBinding;
import com.emovakemenkes.framework.mvvm.databinding.MainMenuBinding;
import com.emovakemenkes.framework.mvvm.ui.base.BaseFragment;
import com.emovakemenkes.framework.mvvm.ui.main.navigator.MainFragmentNavigator;
import com.emovakemenkes.framework.mvvm.ui.main.viewmodel.MainFragmentViewModel;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.activity.PuskesmasActivity;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.navigator.PuskesmasEntryNavigator;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.viewmodels.PuskesmasEntryFormViewModel;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import javax.inject.Inject;


public class StepOneFragmentPuskesmas extends BaseFragment<FragmentStepOneBinding, PuskesmasEntryFormViewModel> implements PuskesmasEntryNavigator, Step {

    public static final String TAG = StepOneFragmentPuskesmas.class.getSimpleName();
    @Inject
    ViewModelProviderFactory factory;

    PuskesmasEntryFormViewModel mAboutViewModel;
    FragmentStepOneBinding binding;

    public static StepOneFragmentPuskesmas newInstance() {
        Bundle args = new Bundle();
        StepOneFragmentPuskesmas fragment = new StepOneFragmentPuskesmas();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_step_one;
    }

    @Override
    public PuskesmasEntryFormViewModel getViewModel() {
        mAboutViewModel = ViewModelProviders.of(this, factory).get(PuskesmasEntryFormViewModel.class);
        return mAboutViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = getViewDataBinding();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAboutViewModel.setNavigator(this);
    }


    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

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

    }
}

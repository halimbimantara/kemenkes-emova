
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
import com.emovakemenkes.framework.mvvm.databinding.FragmentStepTwoBinding;
import com.emovakemenkes.framework.mvvm.ui.base.BaseFragment;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.navigator.PuskesmasEntryNavigator;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.viewmodels.PuskesmasEntryFormViewModel;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import javax.inject.Inject;


public class StepTwoFragmentPuskesmas extends BaseFragment<FragmentStepTwoBinding, PuskesmasEntryFormViewModel> implements PuskesmasEntryNavigator, Step {

    public static final String TAG = StepTwoFragmentPuskesmas.class.getSimpleName();
    @Inject
    ViewModelProviderFactory factory;
    private PuskesmasEntryFormViewModel mAboutViewModel;
    FragmentStepTwoBinding binding;

    public static StepTwoFragmentPuskesmas newInstance() {
        Bundle args = new Bundle();
        StepTwoFragmentPuskesmas fragment = new StepTwoFragmentPuskesmas();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_step_two;
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

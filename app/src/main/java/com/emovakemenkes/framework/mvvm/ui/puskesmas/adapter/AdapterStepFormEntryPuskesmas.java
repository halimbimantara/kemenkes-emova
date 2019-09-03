package com.emovakemenkes.framework.mvvm.ui.puskesmas.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.emovakemenkes.framework.mvvm.R;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.fragment.StepOneFragmentPuskesmas;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.fragment.StepTwoFragmentPuskesmas;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.adapter.AbstractStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

public class AdapterStepFormEntryPuskesmas extends AbstractFragmentStepAdapter {
    private static final String CURRENT_STEP_POSITION_KEY = "position";
    public AdapterStepFormEntryPuskesmas(FragmentManager fm,Context context) {
        super(fm,context);
    }

    @Override
    public Step createStep(int position) {
        switch (position) {
            case 0:
                return new StepOneFragmentPuskesmas();
            case 1:
                return new StepTwoFragmentPuskesmas();
            default:
                return new StepOneFragmentPuskesmas();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(int position) {
        return new StepViewModel.Builder(context)
                .setTitle(R.string.title) //can be a CharSequence instead
                .create();
    }
}

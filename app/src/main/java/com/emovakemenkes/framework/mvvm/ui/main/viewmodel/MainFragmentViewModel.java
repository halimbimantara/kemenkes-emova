package com.emovakemenkes.framework.mvvm.ui.main.viewmodel;

import com.emovakemenkes.framework.mvvm.data.DataManager;
import com.emovakemenkes.framework.mvvm.ui.base.BaseViewModel;
import com.emovakemenkes.framework.mvvm.ui.main.navigator.MainFragmentNavigator;
import com.emovakemenkes.framework.mvvm.utils.rx.SchedulerProvider;

public class MainFragmentViewModel extends BaseViewModel<MainFragmentNavigator> {

    private static final String TAG = "MainFragmentViewModel";

    public MainFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void openPuskesmas() {
        getNavigator().openPuskesmas();
    }
}

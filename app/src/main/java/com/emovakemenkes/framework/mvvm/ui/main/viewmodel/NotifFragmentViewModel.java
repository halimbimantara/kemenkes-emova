package com.emovakemenkes.framework.mvvm.ui.main.viewmodel;

import com.emovakemenkes.framework.mvvm.data.DataManager;
import com.emovakemenkes.framework.mvvm.ui.base.BaseViewModel;
import com.emovakemenkes.framework.mvvm.ui.main.navigator.MainFragmentNavigator;
import com.emovakemenkes.framework.mvvm.ui.main.navigator.NotifFragmentNavigator;
import com.emovakemenkes.framework.mvvm.utils.rx.SchedulerProvider;

public class NotifFragmentViewModel extends BaseViewModel<NotifFragmentNavigator> {

    private static final String TAG = "MainFragmentViewModel";

    public NotifFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}

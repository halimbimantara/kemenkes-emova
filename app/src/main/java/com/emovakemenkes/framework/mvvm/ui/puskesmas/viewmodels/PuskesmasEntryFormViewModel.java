package com.emovakemenkes.framework.mvvm.ui.puskesmas.viewmodels;

import com.emovakemenkes.framework.mvvm.data.DataManager;
import com.emovakemenkes.framework.mvvm.ui.base.BaseViewModel;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.navigator.PuskesmasEntryNavigator;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.navigator.PuskesmasNavigator;
import com.emovakemenkes.framework.mvvm.utils.rx.SchedulerProvider;

/**
 * Created by mhbx
 */

public class PuskesmasEntryFormViewModel extends BaseViewModel<PuskesmasEntryNavigator> {

    public PuskesmasEntryFormViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}

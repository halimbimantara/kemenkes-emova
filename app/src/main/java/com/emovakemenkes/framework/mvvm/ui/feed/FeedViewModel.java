package com.emovakemenkes.framework.mvvm.ui.feed;

import com.emovakemenkes.framework.mvvm.ui.base.BaseViewModel;
import com.emovakemenkes.framework.mvvm.data.DataManager;
import com.emovakemenkes.framework.mvvm.utils.rx.SchedulerProvider;

/**
 * Created by Jyoti on 29/07/17.
 */

public class FeedViewModel extends BaseViewModel {

    public FeedViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}

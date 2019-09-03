package com.emovakemenkes.framework.mvvm.ui.puskesmas.viewmodels;

import com.emovakemenkes.framework.mvvm.data.DataManager;
import com.emovakemenkes.framework.mvvm.ui.base.BaseViewModel;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.navigator.PuskesmasNavigator;
import com.emovakemenkes.framework.mvvm.utils.rx.SchedulerProvider;

/**
 * Created by mhbx
 */

public class PuskesmasViewModel extends BaseViewModel<PuskesmasNavigator> {

    public PuskesmasViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void getListPuskesmas(String RoleID, String UserID, int pageNumber) {
        if (pageNumber > 0)
            pageNumber = pageNumber;
        else
            pageNumber = 1;
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getListPuskesmas(pageNumber, getDataManager().getKodeProv(), getDataManager().getKodeKabKot())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(blogResponse -> {
                    if (blogResponse != null && blogResponse.getResults() != null) {
//                        blogListLiveData.setValue(blogResponse.getData());
                        getNavigator().UpdateData(blogResponse.getResults());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable, "GET LIST");
                }));
    }
}

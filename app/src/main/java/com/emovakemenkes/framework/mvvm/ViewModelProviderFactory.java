package com.emovakemenkes.framework.mvvm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.emovakemenkes.framework.mvvm.data.DataManager;
import com.emovakemenkes.framework.mvvm.ui.about.AboutViewModel;
import com.emovakemenkes.framework.mvvm.ui.feed.FeedViewModel;
import com.emovakemenkes.framework.mvvm.ui.feed.blogs.BlogViewModel;
import com.emovakemenkes.framework.mvvm.ui.feed.opensource.OpenSourceViewModel;
import com.emovakemenkes.framework.mvvm.ui.login.LoginViewModel;
import com.emovakemenkes.framework.mvvm.ui.main.MainViewModel;
import com.emovakemenkes.framework.mvvm.ui.main.rating.RateUsViewModel;
import com.emovakemenkes.framework.mvvm.ui.main.viewmodel.MainFragmentViewModel;
import com.emovakemenkes.framework.mvvm.ui.main.viewmodel.NotifFragmentViewModel;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.viewmodels.PuskesmasEntryFormViewModel;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.viewmodels.PuskesmasViewModel;
import com.emovakemenkes.framework.mvvm.ui.splash.SplashViewModel;
import com.emovakemenkes.framework.mvvm.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jyotidubey on 22/02/19.
 */
@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager,
                                    SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AboutViewModel.class)) {
            //noinspection unchecked
            return (T) new AboutViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(FeedViewModel.class)) {
            //noinspection unchecked
            return (T) new FeedViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(BlogViewModel.class)) {
            //noinspection unchecked
            return (T) new BlogViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(RateUsViewModel.class)) {
            //noinspection unchecked
            return (T) new RateUsViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(OpenSourceViewModel.class)) {
            //noinspection unchecked
            return (T) new OpenSourceViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(SplashViewModel.class)) {
            //noinspection unchecked
            return (T) new SplashViewModel(dataManager, schedulerProvider);
        }

        //main
        else if (modelClass.isAssignableFrom(MainFragmentViewModel.class)) {
            //noinspection unchecked
            return (T) new MainFragmentViewModel(dataManager, schedulerProvider);
        }  else if (modelClass.isAssignableFrom(NotifFragmentViewModel.class)) {
            //noinspection unchecked
            return (T) new NotifFragmentViewModel(dataManager, schedulerProvider);
        }


        //Puskesmas
        else if (modelClass.isAssignableFrom(PuskesmasViewModel.class)) {
            //noinspection unchecked
            return (T) new PuskesmasViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(PuskesmasEntryFormViewModel.class)) {
            //noinspection unchecked
            return (T) new PuskesmasEntryFormViewModel(dataManager, schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
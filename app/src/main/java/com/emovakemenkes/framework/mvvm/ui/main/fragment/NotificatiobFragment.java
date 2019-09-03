/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.emovakemenkes.framework.mvvm.ui.main.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.emovakemenkes.framework.mvvm.BR;
import com.emovakemenkes.framework.mvvm.R;
import com.emovakemenkes.framework.mvvm.ViewModelProviderFactory;
import com.emovakemenkes.framework.mvvm.databinding.FragmentNotificationBinding;
import com.emovakemenkes.framework.mvvm.databinding.MainMenuBinding;
import com.emovakemenkes.framework.mvvm.ui.base.BaseFragment;
import com.emovakemenkes.framework.mvvm.ui.main.navigator.MainFragmentNavigator;
import com.emovakemenkes.framework.mvvm.ui.main.navigator.NotifFragmentNavigator;
import com.emovakemenkes.framework.mvvm.ui.main.viewmodel.MainFragmentViewModel;
import com.emovakemenkes.framework.mvvm.ui.main.viewmodel.NotifFragmentViewModel;

import javax.inject.Inject;


public class NotificatiobFragment extends BaseFragment<FragmentNotificationBinding, NotifFragmentViewModel> implements NotifFragmentNavigator {

    public static final String TAG = NotificatiobFragment.class.getSimpleName();
    @Inject
    ViewModelProviderFactory factory;
    NotifFragmentViewModel mAboutViewModel;
    FragmentNotificationBinding binding;

    public static NotificatiobFragment newInstance() {
        Bundle args = new Bundle();
        NotificatiobFragment fragment = new NotificatiobFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_notification;
    }

    @Override
    public NotifFragmentViewModel getViewModel() {
        mAboutViewModel = ViewModelProviders.of(this, factory).get(NotifFragmentViewModel.class);
        return mAboutViewModel;
    }

//    @Override
//    public void goBack() {
//        getBaseActivity().onFragmentDetached(TAG);
//    }


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

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void openLoginActivity() {

    }
}

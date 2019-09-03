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

package com.emovakemenkes.framework.mvvm.ui.login;

import android.content.Intent;
import android.text.TextUtils;

import com.emovakemenkes.framework.mvvm.data.model.api.emova.main.login.LoginRequestEmova;
import com.emovakemenkes.framework.mvvm.ui.base.BaseViewModel;
import com.emovakemenkes.framework.mvvm.data.DataManager;
import com.emovakemenkes.framework.mvvm.data.model.api.LoginRequest;
import com.emovakemenkes.framework.mvvm.utils.CommonUtils;
import com.emovakemenkes.framework.mvvm.utils.rx.SchedulerProvider;

/**
 * Created by amitshekhar on 08/07/17.
 */

public class LoginViewModel extends BaseViewModel<LoginNavigator> {

    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false;
        }
//        if (!CommonUtils.isEmailValid(email)) {
//            return false;
//        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }

    public void login(String email, String password,String Firebase) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .Login(new LoginRequestEmova(email, password,Firebase))
                .doOnSuccess(response -> getDataManager()
                        .updateUserInfoSession(
                                Integer.parseInt(response.getData().get(0).getSession_id_users()),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getData().get(0).getSession_username(),
                                response.getData().get(0).getSession_id_user_group(),
                                email,
                                "",
                                response.getData().get(0).getKd_prov(),
                                response.getData().get(0).getKd_kabkot()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().openMainActivity();
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public void onFbLoginClick() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doFacebookLoginApiCall(new LoginRequest.FacebookLoginRequest("test3", "test4"))
                .doOnSuccess(response -> getDataManager()
                        .updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_FB,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().openMainActivity();
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public void onGoogleLoginClick() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doGoogleLoginApiCall(new LoginRequest.GoogleLoginRequest("test1", "test1"))
                .doOnSuccess(response -> getDataManager()
                        .updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_GOOGLE,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl()))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().openMainActivity();
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public void onServerLoginClick() {
        getNavigator().login();
    }
}

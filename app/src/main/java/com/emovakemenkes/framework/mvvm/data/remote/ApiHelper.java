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

package com.emovakemenkes.framework.mvvm.data.remote;

import com.emovakemenkes.framework.mvvm.data.model.api.BlogResponse;
import com.emovakemenkes.framework.mvvm.data.model.api.LoginRequest;
import com.emovakemenkes.framework.mvvm.data.model.api.LogoutResponse;
import com.emovakemenkes.framework.mvvm.data.model.api.OpenSourceResponse;
import com.emovakemenkes.framework.mvvm.data.model.api.LoginResponse;
import com.emovakemenkes.framework.mvvm.data.model.api.emova.main.login.LoginRequestEmova;
import com.emovakemenkes.framework.mvvm.data.model.api.emova.main.login.LoginResponseEmova;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.models.ResponseListPuskesmas;

import io.reactivex.Single;

/**
 * Created by amitshekhar on 07/07/17.
 */

public interface ApiHelper {

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    ApiHeader getApiHeader();

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSourceResponse> getOpenSourceApiCall();

    Single<LoginResponseEmova> Login(LoginRequestEmova requestEmova);

    //@[Puskesmas]
    Single<ResponseListPuskesmas> getListPuskesmas(int page, String KD_PROV, String KD_KABKOT);

}

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
import com.emovakemenkes.framework.mvvm.data.model.api.LoginResponse;
import com.emovakemenkes.framework.mvvm.data.model.api.LogoutResponse;
import com.emovakemenkes.framework.mvvm.data.model.api.OpenSourceResponse;
import com.emovakemenkes.framework.mvvm.data.model.api.emova.main.login.LoginRequestEmova;
import com.emovakemenkes.framework.mvvm.data.model.api.emova.main.login.LoginResponseEmova;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.models.ResponseListPuskesmas;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by amitshekhar on 07/07/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(LogoutResponse.class);
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(BlogResponse.class);
    }

    @Override
    public Single<OpenSourceResponse> getOpenSourceApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(OpenSourceResponse.class);
    }

    @Override
    public Single<LoginResponseEmova> Login(LoginRequestEmova requestEmova) {
        return Rx2AndroidNetworking.post(ApiEndPoint.EMOVA_POST_SERVER_LOGIN)
                .addBodyParameter(requestEmova)
                .build()
                .getObjectSingle(LoginResponseEmova.class);
    }

    @Override
    public Single<ResponseListPuskesmas> getListPuskesmas(int page, String KD_PROV, String KD_KABKOT) {
        return Rx2AndroidNetworking.post(ApiEndPoint.EMOVA_GET_SERVER_LIST_PUSKESMAS)
                .addBodyParameter("offset", String.valueOf(page))
                .addBodyParameter("kabkot",KD_KABKOT)
                .addBodyParameter("provinsi",KD_PROV)
                .build()
                .getObjectSingle(ResponseListPuskesmas.class);
    }


}

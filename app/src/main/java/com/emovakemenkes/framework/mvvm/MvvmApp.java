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

package com.emovakemenkes.framework.mvvm;

import android.app.Activity;
import android.app.Application;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.emovakemenkes.framework.mvvm.di.component.DaggerAppComponent;
import com.emovakemenkes.framework.mvvm.utils.AppLogger;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import kotlin.collections.CollectionsKt;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by amitshekhar on 07/07/17.
 */

public class MvvmApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        AppLogger.init();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .cache(null)
//                .connectionSpecs(CollectionsKt.listOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT))
                .build();
        AndroidNetworking.initialize(getApplicationContext(),okHttpClient);
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

}

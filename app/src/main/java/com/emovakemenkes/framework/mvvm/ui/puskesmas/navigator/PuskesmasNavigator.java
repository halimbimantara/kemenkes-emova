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

package com.emovakemenkes.framework.mvvm.ui.puskesmas.navigator;

import com.androidnetworking.error.ANError;
import com.emovakemenkes.framework.mvvm.ui.puskesmas.models.ModelListPuskesmas;

import java.util.List;

/**
 * Created by amitshekhar on 08/07/17.
 */

public interface PuskesmasNavigator {
    void handleError(Throwable throwable, String TAG);
    void handleErrorNetwork(ANError anError, String TAG);
    void hideShimmer();
    void startShimmer();
    void ShowMessages(String title,String Messages,int type);//type 1 toast,2 snack
    void UpdateData(List<ModelListPuskesmas> modelListPuskesmas);
}

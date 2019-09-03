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
import com.emovakemenkes.framework.mvvm.BuildConfig;

public final class ApiEndPoint {

    public static final String BASE_URI = "http://emova.bit.co.id/index.php/api/";
    public static final String ENDPOINT_BLOG = BuildConfig.BASE_URL + "/5926ce9d11000096006ccb30";

    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL + "/588d15d3100000ae072d2944";

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL + "/588d14f4100000a9072d2943";

    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL + "/588d161c100000a9072d2946";

    public static final String ENDPOINT_OPEN_SOURCE = BuildConfig.BASE_URL + "/5926c34212000035026871cd";

    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL + "/588d15f5100000a8072d2945";

    public static final String EMOVA_POST_SERVER_LOGIN = BASE_URI+"signin/in";
    public static final String EMOVA_GET_SERVER_KETERSEDIAANOBAT = BASE_URI+"getKetersediaanObat";
    public static final String EMOVA_GET_SERVER_LIST_PUSKESMAS = BASE_URI+"get_historyPuskesmas";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}

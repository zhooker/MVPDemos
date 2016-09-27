package com.example.mvpdemos.model.http;

import com.example.mvpdemos.model.bean.GankItemBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class RetrofitHelper {

    private static OkHttpClient okHttpClient = null;
    private static GankApis gankApiService = null;

    private void init() {
        initOkHttp();
        gankApiService = getGankApiService();
    }

    public RetrofitHelper() {
        init();
    }

    private static void initOkHttp() {
        // http://www.jianshu.com/p/93153b34310e
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        okHttpClient = builder.build();
    }

    public static GankApis getGankApiService() {
        Retrofit gankRetrofit = new Retrofit.Builder()
                .baseUrl(GankApis.HOST)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return gankRetrofit.create(GankApis.class);
    }

    public Observable<GankHttpResponse<List<GankItemBean>>> fetchTechList(String tech, int num, int page) {
        return gankApiService.getTechList(tech, num, page);
    }

    public Observable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page) {
        return gankApiService.getGirlList(num, page);
    }
}

package com.latte.core.net;

import com.latte.core.net.callback.IError;
import com.latte.core.net.callback.IFailure;
import com.latte.core.net.callback.IRequest;
import com.latte.core.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.RequestBody;

public class RestClientBuilder {

    private String mUrl;
    private WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    private IRequest mRequest;
    private ISuccess mSuccess;
    private IError mError;
    private IFailure mFailure;
    private RequestBody mBody;

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder request(IRequest request) {
        this.mRequest = request;
        return this;
    }

    public final RestClientBuilder success(ISuccess success) {
        this.mSuccess = success;
        return this;
    }

    public final RestClientBuilder error(IError error) {
        this.mError = error;
        return this;
    }

    public final RestClientBuilder failure(IFailure failure) {
        this.mFailure = failure;
        return this;
    }

    public final RestClientBuilder body(RequestBody body) {
        this.mBody = body;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mRequest, mSuccess, mError, mFailure, mBody);
    }
}

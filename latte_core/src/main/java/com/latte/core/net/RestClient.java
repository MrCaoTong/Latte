package com.latte.core.net;

import com.latte.core.net.callback.IError;
import com.latte.core.net.callback.IFailure;
import com.latte.core.net.callback.IRequest;
import com.latte.core.net.callback.ISuccess;
import com.latte.core.net.callback.RequestCallbacks;

import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public final class RestClient {

    private final String URL;
    private final WeakHashMap<String, Object> PARAMS;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final RequestBody BODY;

    RestClient(String url,
               WeakHashMap<String, Object> params,
               IRequest request,
               ISuccess success,
               IError error,
               IFailure failure,
               RequestBody body) {
        this.URL = url;
        this.PARAMS = params;
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.BODY = body;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService restService = RestCreator.getRestService();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        switch (method) {
            case GET:
                restService.get(URL, PARAMS);
                break;
            case PUT:
                restService.put(URL, PARAMS);
                break;
            case POST:
                restService.post(URL, PARAMS);
                break;
            case DELETE:
                restService.delete(URL, PARAMS);
                break;
            default:
                break;
        }
        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new RequestCallbacks(REQUEST, SUCCESS, ERROR, FAILURE);
    }

    public final void get(){
        request(HttpMethod.GET);
    }

    public final void post(){
        request(HttpMethod.POST);
    }

    public final void put(){
        request(HttpMethod.PUT);
    }
    public final void delete(){
        request(HttpMethod.DELETE);
    }
}

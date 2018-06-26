package com.example.leidong.webfoundation;

import android.content.Context;

import com.example.leidong.webfoundation.callback.IError;
import com.example.leidong.webfoundation.callback.IFailure;
import com.example.leidong.webfoundation.callback.IRequest;
import com.example.leidong.webfoundation.callback.ISuccess;
import com.example.leidong.webfoundation.callback.RequestCallbacks;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Lei Dong on 2018/6/26.
 */
public class RestClient {
    private final String URL;
    private final Map<String, Object> PARAMS = RestCreater.getParams();

    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private final File FILE;
    private final Context CONTEXT;


    public RestClient(
            String url,
            Map<String, Object> params,
            IRequest request,
            ISuccess success,
            IFailure failure,
            IError error,
            RequestBody body,
            Context context,
            File file,
            String downloadDir,
            String extension,
            String name) {
        this.URL = url;
        this.PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
        this.CONTEXT = context;
        this.FILE = file;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.NAME = name;
    }

    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }

    public void request(HttpMethods method){
        final RestService restService = RestCreater.getRestService();
        Call<String> call = null;

        if(REQUEST != null){
            REQUEST.onRequestStart();
        }

        switch(method){
            case GET:
                call = restService.get(URL, PARAMS);
                break;
            case POST:
                call = restService.post(URL, PARAMS);
                break;
            case POST_RAM:
                call = restService.postRaw(URL, BODY);
                break;
            case PUT:
                call = restService.put(URL, PARAMS);
                break;
            case PUT_RAM:
                call = restService.putRaw(URL, BODY);
                break;
            case DELETE:
                call = restService.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                call = RestCreater.getRestService().upload(URL, body);
                break;
            default:
                break;
        }

        if(call != null){
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback(){
        return new RequestCallbacks(REQUEST, SUCCESS, FAILURE, ERROR);
    }

    public final void get(){
        request(HttpMethods.GET);
    }

    public final void post(){
        if(BODY == null) {
            request(HttpMethods.POST);
        }
        else{
            if(!PARAMS.isEmpty()){
                throw new RuntimeException("Params must be null.");
            }
            request(HttpMethods.POST_RAM);
        }
    }

    public final void put(){
        if(BODY == null) {
            request(HttpMethods.PUT);
        }
        else{
            if(!PARAMS.isEmpty()){
                throw new RuntimeException("Params must be null.");
            }
            request(HttpMethods.PUT_RAM);
        }
    }

    public final void delete(){
        request(HttpMethods.DELETE);
    }

//    public final void download(){
//        new DownloadHandler(URL, REQUEST, DOWNLOAD_DIR, EXTENSION, NAME, SUCCESS, FAILURE, ERROR)
//                .handleDowmload();
//    }
}

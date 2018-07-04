package com.sj.mycore.net;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Date: 2018/6/7
 * Author: sj
 * Description:  retrofit的所有功能
 */
public interface RestService {

    /**
     *  get 请求
     * @param url
     * @param params  参数
     * @return
     */
    @GET
    Call<String> get(@Url String url, @QueryMap Map<String,Object> params);

    /**
     *  post请求
     *    @FormUrlEncoded 发送数据表示以表单方式提交
     * @param url
     * @param params 参数
     * @return
     */
    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String,Object> params);

    /**
     * 本质是post请求
     *     @FormUrlEncoded 发送数据表示以表单方式提交
     * @param url
     * @param params 参数
     * @return
     */
    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap Map<String,Object> params);


    /**
     *
     * @param url
     * @param params 参数
     * @return
     */
    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String,Object> params);


    /**
     * 下载是直接到内存,所以需要 @Streaming
     * @param url
     * @param params 参数
     * @return
     */
    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url, @QueryMap Map<String,Object> params);


    /**
     * //上传
     * @param url
     * @param file  参数
     * @return
     */
    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);


    /////////////////////////////////原始数据///////////////////////////////////
    /**
     * 其他原始数据 请求
     * @param url
     * @param body
     * @return
     */
    @POST
    Call<String> postRaw(@Url String url, @Body RequestBody body);

    /**
     * 其他原始数据 请求
     * @param url
     * @param body
     * @return
     */
    @PUT
    Call<String> putRaw(@Url String url,@Body RequestBody body);

}

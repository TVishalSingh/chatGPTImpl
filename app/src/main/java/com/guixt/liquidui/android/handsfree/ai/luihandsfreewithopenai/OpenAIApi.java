package com.guixt.liquidui.android.handsfree.ai.luihandsfreewithopenai;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OpenAIApi {
    @Headers("Authorization: Bearer sk-my-android-service-test-Z7sbFhlIzZCoi8yv6TlET3BlbkFJ23D2WfFg6avANA4VpQDM")
    @POST("v1/chat/completions")
    Call<ChatCompletionResponse> getChatCompletion(@Body ChatCompletionRequest request);
}


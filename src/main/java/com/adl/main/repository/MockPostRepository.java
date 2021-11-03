package com.adl.main.repository;

import com.adl.main.model.MockPostModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MockPostRepository {

	@POST("posts")
	Call<MockPostModel> inputMock(@Body MockPostModel model);
}

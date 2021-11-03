package com.adl.main.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adl.main.model.MockPostModel;
import com.adl.main.repository.AllCovidRepository;
import com.adl.main.repository.MockPostRepository;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class MockPostService {

	private MockPostRepository service;
	
	public MockPostService () {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		service = retrofit.create(MockPostRepository.class);
	}
	
	public MockPostModel inputModel(MockPostModel model) {
		Call<MockPostModel> call = service.inputMock(model);
		Response<MockPostModel> response = null;
		try {
			response = call.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.body();
		
	}
}

package com.adl.main.repository;

import java.util.List;

import com.adl.main.model.AllCovidInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AllCovidRepository {
	@GET("v1")
	Call<List<AllCovidInfo>> getAll();
	
	@GET("v1/{country}")
	Call<AllCovidInfo> getByCountry(@Path("country") String country);
}

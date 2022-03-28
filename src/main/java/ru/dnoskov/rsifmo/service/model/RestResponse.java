package ru.dnoskov.rsifmo.service.model;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.Data;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Data
public class RestResponse {

	int code;
	Map<String, Object> responseBody;
	
	public RestResponse(Response response) throws IOException {
		code = response.code();
		
		ResponseBody body = response.body();
		
		if (body != null) {
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, Object>>(){}.getType();
			
			String jsonString = body.string();
			responseBody = gson.fromJson(jsonString, type);
		} else {
			responseBody = new HashMap<>();
		}
	}

}

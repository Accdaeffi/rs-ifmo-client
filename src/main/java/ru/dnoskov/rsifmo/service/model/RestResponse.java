package ru.dnoskov.rsifmo.service.model;

import java.io.IOException;

import org.bson.Document;

import lombok.Data;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Data
public class RestResponse {

	int code;
	Document body;
	
	public RestResponse(Response response) throws IOException {
		code = response.code();
		
		ResponseBody responseBody = response.body();
		
		if (responseBody != null) {
			String responseBodyString = responseBody.string();
			
			if (!responseBodyString.isBlank()) {
				body = Document.parse(responseBodyString);
			} else {
				body = new Document();
			}
		} else {
			body = new Document();
		}
	}

}

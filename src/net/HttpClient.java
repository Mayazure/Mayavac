package net;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import util.Const;

public class HttpClient {
	
	private static HttpClient httpClientInstance = new HttpClient();
	private HttpClient(){
		client = new OkHttpClient();
	}
	
	public static HttpClient getHttpClientInstance(){
		return httpClientInstance;
	}
	
	private OkHttpClient client;
	private Response response = null;
	private Request request = null;
	
	public void setRequest(String URL){
		
		Request.Builder builder = new Request.Builder();
		builder.addHeader("cookie", Const.Cookie);
		builder.addHeader("User-Agent", Const.User_Agent);
		builder.url(URL);
		request = builder.build();
	}
	
	public String getResponseBodyAsString(){
		
		try {
			response = client.newCall(request).execute();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String htmll = null;
		try {
			htmll = response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return htmll;
	}
	
	
}

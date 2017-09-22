package testOxford;

public class Test {

	public static void main(String[] args) {
		HttpClient httpClient = HttpClient.getHttpClientInstance();
		String url = "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/" + "discrete";
		httpClient.setRequest(url);
		String resString = httpClient.getResponseBodyAsString();
		System.out.println(resString);
	}
}

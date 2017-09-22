package test;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestGeneral {
	
	public static void main(String[] args){
		
		OkHttpClient client = new OkHttpClient();
		Response response = null;
		Request request = new Request.Builder()
				.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36")
				.header("cookie","ipv6=hit=1; MUID=132548BAD72366321D4E4296D32365B0; SRCHD=AF=NOFORM; SRCHUSR=DOB=20170311; SRCHUID=V=2&GUID=5B318773E4BD4224B4D909834FB5AE69; MUIDB=132548BAD72366321D4E4296D32365B0; SRCHHPGUSR=CW=1536&CH=744&DPR=1.25&UTC=600; WLS=TS=63631821719; _SS=SID=1088E204CA62619E3368E897CBE4604F&HV=1496224922; _EDGE_S=mkt=zh-cn&SID=1088E204CA62619E3368E897CBE4604F; SNRHOP=I=&TS=")
                .url("http://cn.bing.com/dict/search?q=depart")
                .build();
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
//		System.out.println(htmll);
		
		Document doc = Jsoup.parse(htmll);
		/*try {
//			doc = Jsoup.connect("http://cn.bing.com/dict/search?q=traversing").get();
//			doc = Jsoup.connect("file://C://Users//mayaz//Desktop//bing-traversing.html").get();
			doc = Jsoup.parse(new File("C://Users//mayaz//Desktop//bing-traversing.html"), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String content = null;
		for(Element meta : doc.select("meta")) {
			if(meta.attr("name").equals("description")){
				content = meta.attr("content");
				break;
			}
		}
		System.out.println(content);
	}

}

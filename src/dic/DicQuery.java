package dic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import net.HttpClient;
import util.Const;

public class DicQuery {

	private static DicQuery dicQueryInstance = new DicQuery(); 
	
	public static DicQuery getDicQueryInstance(){
		return dicQueryInstance;
	}

	private DicQuery(){
		httpClient = HttpClient.getHttpClientInstance();
	}
	
	private HttpClient httpClient;
	
	public String search(String word){
		
		httpClient.setRequest(Const.URL+word);
		String htmll = httpClient.getResponseBodyAsString();
		
		Document doc = Jsoup.parse(htmll);
		
		String content = null;
		for(Element meta : doc.select("meta")) {
			if(meta.attr("name").equals("description")){
				content = meta.attr("content");
				break;
			}
		}

//		System.out.println(content);
		
		if(content.equals("词典")){
			content = "No online result.";
		}
		else{
			content = content.replace("必应词典为您提供"+word+"的释义，", "");
			if(!content.startsWith("网络释义")){
				content = content.replace("网络释义：", "\r\n网络释义：");
			}
//			content = content.replace("n.", "\r\nn.");
//			content = content.replace("adj.", "\r\nadj.");
//			content = content.replace("adv.", "\r\nadv.");
//			content = content.replace("v.", "\r\nv.");
//			content = content.replace("prep.", "\r\nprep.");
//			content = content.replace("int.", "\r\nint.");
//			content = content.replace("abbr.", "\r\nabbr.");
//			content = content.replaceFirst("，", "\r\n");
//			content = content.replace("；", "\r\n");
		}
		
		return content;
	}
}

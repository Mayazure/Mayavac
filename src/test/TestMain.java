package test;

import java.util.Scanner;

import dic.DicQuery;

public class TestMain {

	public static void main(String[] args) {
		DicQuery dic = DicQuery.getDicQueryInstance();
//		String resString = dic.search("car");
//		System.out.println(resString);
		Scanner scanner = new Scanner(System.in);

		while(true){
			String data = scanner.nextLine();
			if(data.equals("&&&")){
				break;
			}
			else{
				String res = dic.search(data);
				System.out.println(res);
			}
		}
		scanner.close();

	}
}

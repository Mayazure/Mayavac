package note;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

import fileOperator.FileOperator;

public class Note {
	
	private FileOperator fileOperator;
	
	public Note(){
		fileOperator = new FileOperator();
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File file = fsv.getDefaultDirectory();
		String filePath = file.getAbsolutePath();
		filePath += "\\Mayavac";
		File dir = new File(filePath);
		if(!dir.exists()||!dir.isDirectory()){
			fileOperator.createFileDir(filePath);
		}
		filePath += "\\vacnote.vn";
		fileOperator.loadWriteFile(filePath);
		fileOperator.loadReadFile(filePath);
	}
	
	public String checkNote(String word){
		String str;
		while((str=fileOperator.nextLine())!=null){
			if(str.startsWith(word)){
				int start = str.indexOf("#");
				str = str.substring(start+1);
				return str;
			}
		}
		return "#";
	}
	
	public void addNote(String word, String data){
		String out = word+"#"+data;
		fileOperator.writeToFile(out);
	}
	
	
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class FileList {
	private static ArrayList<String> store = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		listFile("S:\\Camera Backup");
		writeOut();
		System.out.println("List written");
	}
	
	public static void listFile(String folder){
		File dir = new File(folder);	// points to the directory
		File[] files = dir.listFiles();	// list the files in the dir given
		
		for(File f : files){
			if(f.isDirectory())
				listFile(f.toString());
			else{
				Date d = new Date(f.lastModified());	// converts to regular date
				//System.out.println(f.toString() + "	" + d); // prints out name and date
				store.add(f.toString() + "	" + d);	// add info to array
			}
		}
		store.add(""); // add an empty line separate folders
	}
	
	public static void writeOut() throws IOException{
		 PrintWriter out = new PrintWriter(new FileWriter("./output.txt"));
		 for(String s : store){
			 //System.out.println(s);
			 out.println(s);
		 }
		 out.close();
	}
}

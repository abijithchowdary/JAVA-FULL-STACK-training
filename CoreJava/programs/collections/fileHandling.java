import java.io.*;

public class fileHandling {

	public static void main(String[] args) {
		File a = new File("billa.txt");
		File folder = new File("bill");
		if(folder.mkdir()){
			System.out.println("File created");
		}
		System.out.println(folder.getAbsolutePath());
		File ab = new File("abijith/chowdary");
		ab.mkdirs();
		ab.delete();
		folder.renameTo("billaAbijithChowdary");
	}
}
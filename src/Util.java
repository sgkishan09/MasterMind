import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Util {
	public static ArrayList<String> wordList;
	static {
		try {
			wordList = readFile("C:\\Projects\\sowpods.txt");
		} catch (Exception e) {
		}
	}

	public static ArrayList<String> readFile(String path) throws Exception {
		return (ArrayList<String>) Files.readAllLines(Paths.get(path));
	}

	public static String getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
}

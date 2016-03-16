import java.util.*;
import java.io.File;

class Test{
	public static void main(String[] args) throws Exception {
		Scanner filleser = new Scanner(new File("dataset.txt"));

		while(filleser.hasNextLine()){
			System.out.println(filleser.nextLine());
		}
	}
}

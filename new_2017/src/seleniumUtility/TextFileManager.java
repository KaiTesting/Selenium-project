
package seleniumUtility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileManager {

	private String fileName = null;

	public TextFileManager(String filePath) {
		fileName = filePath;
	}

	public String read() {
		String finalText = null;
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();

			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			finalText = sb.toString();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return finalText;
	}

	public void write(String text) {
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(text);
			bufferedWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		TextFileManager tfm = new TextFileManager("C:/Users/pulatiy/Desktop/TextFileManager/testingFile.txt");

		String value = tfm.read().toString();
		System.out.println("Result: \n" + value);
	}

}

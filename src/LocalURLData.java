import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;

public class LocalURLData {

	private String filePath;
	private BufferedWriter writer;
	private BufferedReader reader;
	private LinkedHashMap<String, String> result;

	public LocalURLData() {
		
		filePath = "data.txt";
		result = new LinkedHashMap<String, String>();
		try {
			writer = new BufferedWriter(new FileWriter(filePath, true));
			reader = new BufferedReader(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void writeToFile(String content) {
		
		try {
			writer.newLine();
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public LinkedHashMap<String, String> getResult() {

		String line;

		try {
			while ((line = reader.readLine()) != null) {
				if (!line.equals("")) {
					String[] res = line.split(" _-_ ");
					result.put(res[0], res[1]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
		
	}

	public Object[] getTitle() {
		return getResult().keySet().toArray();
	}

	public String getLink(Object object) {

		return getResult().get(object);
	}

}

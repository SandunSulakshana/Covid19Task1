package covid19SL;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataReader {
	private static final String JSON_ARRAY = "records";
	private static final String ID = "geoId";
	private static final String DATE = "dateRep";
	private static final String CASES = "cases";
	private static final String DEATHS = "deaths";
    
    /**
     * This method reads the contents form a JSON file and prints the required data.
     * 
     * @param filePath the path to JSON file.
     */
    public void readData(String filePath) {
        try {
            String fileContent = Files.readString(Paths.get(filePath));
            JSONObject obj  = new JSONObject(fileContent);
            JSONArray arr = obj.getJSONArray(JSON_ARRAY);
            
            System.out.println("Date\t\tReported Cases\t\tDeaths");
            
            for(int i = 0; i < arr.length(); i ++) {
            	if(arr.getJSONObject(i).getString(ID).equals("LK")) {
            		System.out.print(arr.getJSONObject(i).getString(DATE) + "\t\t");
            		System.out.print(arr.getJSONObject(i).getString(CASES) + "\t\t");
            		System.out.println(arr.getJSONObject(i).getString(DEATHS));
            	}
            }
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}

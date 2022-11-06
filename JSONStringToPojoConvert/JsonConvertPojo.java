package urlConnection;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvertPojo {

	public static void main(String[] args) throws ParseException {
		URL obj = null;
		try {
			//obj = new URL("https://reqres.in/api/unknown");
			obj = new URL("https://reqres.in/api/users?page=2");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) obj.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStreamReader reader;
		try {
			reader = new InputStreamReader(connection.getInputStream());
			int value = reader.read();
			boolean isValied = true;
			boolean isValied1 = false;
			char ch;
			String data = "";
			while (value != -1 && isValied) {
				ch = (char) value;
				if ((ch + "").equals("[")) {
					isValied1 = true;
				}
				if ((ch + "").equals("]")) {
					isValied1 = false;
					isValied = false;
				}
				if (isValied1) {
					data += ch;
				}
				value = reader.read();
			}
			data += "]";
			String dataObject = "";
			// to Store moreObject value store in JSONArray::
			// JsonArray convert String convert to jsonArray:
			JSONArray arr = new JSONArray(data);
			
			for (int i = 0; i < arr.length(); i++) {
				JSONObject json = arr.getJSONObject(i);
				dataObject = json.toString();
				
				// objectMapper class
				ObjectMapper mapper = new ObjectMapper();
				// mapping the json one object to map pojo class dataType;
				Customer customer = mapper.readValue(dataObject,Customer.class);
				// call customer pojo class display method
				customer.display();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

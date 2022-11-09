package urlConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvertPojo {

	public static void main(String[] args) {
		URL obj = null;
		try {
			obj = new URL("https://reqres.in/api/unknown");
			// obj = new URL("https://reqres.in/api/users?page=2");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) obj.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedReader bureader;
		try {
			bureader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			JSONObject json1 = new JSONObject(bureader.readLine());
			System.out.println(json1);
			String dataObject = "";
			// to Store moreObject value store in JSONArray::
			// JsonArray convert String convert to jsonArray:
			JSONArray arr = json1.getJSONArray("data");
			ArrayList<Datum> customerDetails = new ArrayList<Datum>();
			for (int i = 0; i < arr.length(); i++) {
				JSONObject json = arr.getJSONObject(i);
				dataObject = json.toString();
				// objectMapper class
				ObjectMapper mapper = new ObjectMapper();
				// mapping the json one object to map pojo class dataType;
				Datum customer = mapper.readValue(dataObject, Datum.class);
				// call customer pojo class display method
				customerDetails.add(customer);
				customer.display();

			}
			Solve solve = new Solve();
			solve.swingDisplay(customerDetails);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

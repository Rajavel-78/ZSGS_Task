package urlConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionExample {
	
	
	public static void main(String[] arg)  {
		URL obj = null;
		try {
			obj = new URL("https://reqres.in/api/users?page=2");
		} catch (MalformedURLException e) {
			System.out.println("Url not found");
		}
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection)obj.openConnection();
			System.out.println(con.getInputStream());
		} catch (IOException e1) {
			System.out.println("connection faield");
		}
		
		BufferedReader read;
		try {
			read = new BufferedReader(new InputStreamReader(con.getInputStream()));
			System.out.println(read.readLine());
		} catch (IOException e) {
			System.out.println("File not fount");
		}
		
	}
}
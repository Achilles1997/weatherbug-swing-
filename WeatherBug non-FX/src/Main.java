import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JFrame;
import java.util.List;
import com.google.gson.*;
import com.sun.net.httpserver.Authenticator.Result;


public class Main{


	public static void main(String[] args) throws IOException {

		String cityName = "San Antonio";
		String statecode ="";
		StringBuilder result = new StringBuilder();

		if (cityName != "") {
			String urlString = "https://api.openweathermap.org/data/2.5/weather?q="+cityName+","+statecode+"&appid=0af5178f8376b8678fe822262118962b"+"&units=imperial"+"&lang=eng"; 
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty(cityName, "c56e487609213c23f52e0f3082e31018");
		
		
			//StringBuilder result = new StringBuilder();
			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = rd.readLine() ) !=null) {
				result.append(line);
				//System.out.println(line);
				//System.out.println(result);
			}
		}
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
	
		JsonInfo weather = gson.fromJson(result.toString(), JsonInfo.class);
		System.out.println("Longitude: " + weather.coord.getLon() 
							+ "	Latitiude: " + weather.coord.getLat()); 
		System.out.println("weather main Id: " + weather.weather.get(0).getId());
		System.out.println("weather main: " + weather.weather.get(0).getMain());
		System.out.println("weather main description: " + weather.weather.get(0).getDescription());
		System.out.println("weather main Icon: " + weather.weather.get(0).getIcon());
		System.out.println("Base: " + weather.base);
		System.out.println("Temperature: " + weather.main.getTemp() 
						+ "		Feels Like: " + weather.main.getFeels_like()
						+ "		Low for the day: " + weather.main.getTemp_min()	
						+ "\nHigh for the day: " + weather.main.getTemp_max()
						+ "		Air Pressure: " + weather.main.getPressure()
						+ "		Humidity: " + weather.main.getHumidity() + "%");
		System.out.println("Visibility: " + weather.visibility);
		System.out.println("Wind Speed: " + weather.wind.getSpeed() 
						+ "		Wind Direction: " + weather.wind.getDeg());
		System.out.println("Cloud Cover: " + weather.clouds.isClouds());
		System.out.println("dt: " + weather.dt);
		System.out.println("Type: " + weather.sys.getType() 
						+ "		Cloud-Id: " + weather.sys.getId() 
						+ "		Country: " + weather.sys.getCountry() 
						+ "\nSunrise: " + weather.sys.getSunrise()
						+ "		Sunset: " + weather.sys.getSunset());
		System.out.println("Timezone: " + weather.timezone);
		System.out.println("Id: " + weather.id);
		System.out.println("City Name: " + weather.name);
		System.out.println("City Code: " + weather.cod);
		
		JFrame frame = new JFrame("Weather on the dot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,300);
       JTextArea JTextArea1 = new JTextArea(
    		   "Current weather stats for: " + weather.name
    		   +"\n\n"
    		   +
    		   ("Longitude: " + weather.coord.getLon() 
				+ "	Latitiude: " + weather.coord.getLat())
    		   + "\n\n"
    		   +  "weather main description: " + weather.weather.get(0).getDescription()
    		   + "\n\n"
    		   + "Temperature: " + weather.main.getTemp() 
				+ "	Feels Like: " + weather.main.getFeels_like()
				+ "\n"
				+ "Low for the day: " + weather.main.getTemp_min()	
				+ "	High for the day: " + weather.main.getTemp_max()
				+ "\n"
				+ "Air Pressure: " + weather.main.getPressure()
				+ "	Humidity: " + weather.main.getHumidity() + "%"
    		   + "\n\n"
				+ "Wind Speed: " + weather.wind.getSpeed() 
    		   
    		   
    		   );
       JTextArea1.setEditable(false);
       frame.getContentPane().add(JTextArea1);
       frame.setVisible(true);

	}
}


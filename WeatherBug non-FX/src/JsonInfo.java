import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class JsonInfo {
	
	Coord coord; //works
	List<Weather> weather; //
	String base; //works
	MainTemp main; //works
	int visibility; //works
	Wind wind; //works
	Clouds clouds; //works
	int dt; 
	Sys sys;
	int timezone;
	int id;
	String name;
	int cod;
	
}

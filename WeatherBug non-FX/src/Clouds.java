
public class Clouds {
	int all;

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public String isClouds() {
		String result;
		switch (all) {
			case 1:{
				result = "Cirro- curl of hair, high.";  
				break;
			}
			case 2:{
				result = "Alto- mid.";
				break;
			}
			case 3:{
				result = "Strato- layer.";
				break;
			}
			case 4:{
				result = "Nimbo- rain, precipitation.";
				break;
			}
			case 5:{
				result = "Cumulo- heap.";
				break;
			}
			default:
				result = "There are currently no clouds";
		}
		return result;
	}
	
	
}

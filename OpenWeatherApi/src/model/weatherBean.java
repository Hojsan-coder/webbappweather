package model;

public class weatherBean {

	private String cityStre,countryStr,CloudsStr,dateStr;
	
public weatherBean(String cityStre, String countryStr) {
		
	
	this.cityStre=cityStre;
	this.countryStr=countryStr;

}
	
	
	
	public String getCityStre() {
		return cityStre;
	}




	public String getCountryStre() {
		return countryStr;
	}


	public String getCloudsStr() {
		return CloudsStr;
	}

	

    public void setCloudsStr(String xMLClouds) {
		
		this.CloudsStr=xMLClouds;
	}



	public String getDateStr() {
		return dateStr;
	}



	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

  

}

package model;

import javax.servlet.http.Cookie;

public class ChocolateCookie {

	public static Cookie eatCookie(weatherBean wBean) {
		int min = 60;
		Cookie ck = new Cookie(wBean.getCityStre()+wBean.getCountryStre() ,wBean.getCityStre()+"/"+wBean.getCountryStre()+"/"+
				wBean.getDateStr());
		
		ck.setMaxAge(min * 15);
		return ck;
		
	
	}

}

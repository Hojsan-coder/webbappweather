package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ChocolateCookie;
import model.GettheWeather;
import model.weatherBean;

/**
 * Servlet implementation class OWservlet
 */
@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OWservlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	String cityStre =request.getParameter("city");
	String countryStr =request.getParameter("country");	
			
		
	weatherBean wBean = new weatherBean(cityStre,countryStr);
	
	
	GettheWeather.getWeather(wBean);
	
	
	request.setAttribute("wBean", wBean);
	
	
	
	response.addCookie(ChocolateCookie.eatCookie(wBean));
	
	RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
	
	rd.forward(request, response);
	
	
	
	
	
	}

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

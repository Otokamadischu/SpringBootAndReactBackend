package shop.global;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Component;

@Component
public class GlobalAdvice {
	
	public String[] getPathArray(HttpServletRequest request) {
		
		URL url = null;
		try {
			url = new URL(request.getRequestURL().toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    String path = url.getPath();
	    String[] paths = path.split("/");
		
		return paths;
	}

}

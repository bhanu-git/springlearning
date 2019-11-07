package com.sb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	//localhost:8080/home?name=bhanu
	//Lagacy Servelt concept
	@RequestMapping("/home")
	public String getHome(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		session.setAttribute("name", name);
		return "Home";
	}
	
	//localhost:8080/home1?name=bhanu
	@RequestMapping("/home1")
	public String getHome1(String name,HttpSession session) {
		session.setAttribute("name", name);
		return "Home";
	}
	
	//localhost:8080/home2?name=bhanu
	@RequestMapping("/home2")
	public String getHome2(@RequestParam("name") String myname,HttpSession session) {
		session.setAttribute("name", myname);
		return "Home";
	}
	
	//localhost:8080/home3?name=bhanu
		@RequestMapping("/home3")
		public ModelAndView getHome3(@RequestParam("name") String myname) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("name", myname);
			mv.setViewName("Home");
			return mv;
		}
		
		//localhost:8080/home4?eid=1&ename=bhanu&eage=29
				@RequestMapping("/home4")
				public ModelAndView getHome4(Employee emp) {
					ModelAndView mv = new ModelAndView();
					mv.addObject("obj", emp);
					mv.setViewName("EmpDetails");
					return mv;
				}

}

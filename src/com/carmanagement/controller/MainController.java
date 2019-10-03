package com.carmanagement.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.carmanagement.domain.HibernateSessionBean;
import com.carmanagement.domain.UserBean;

@Controller

public class MainController {
	@Autowired
	@Qualifier("myTemplate")
	HibernateSessionBean sessionFactory;
	
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView("AfterLogin");
	}

	@RequestMapping(name = "/loginAction", method = RequestMethod.GET)
	public ModelAndView loginAction(@ModelAttribute("loginBean") UserBean userBean, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		ModelAndView mav1 = new ModelAndView();
		mav1.addObject("uname", userBean.getName());
		HttpSession sess = request.getSession();
		sess.setAttribute("uname", userBean.getName());
		sess.setAttribute("upass", userBean.getPass());
		try {

			if (sessionFactory.loginCheck(userBean)) {

				mav1.setViewName("Success");
				// out.println("<script>alert('Login Success');</script>");
			} else
				mav1.setViewName("Fail");
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return mav1;
	}
	@RequestMapping("/featureelite")
	public ModelAndView bookingClick() {
		return new ModelAndView("featureelite");
	}
}

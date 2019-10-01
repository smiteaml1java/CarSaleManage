package com.carmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.carmanagement.domain.HibernateSessionBean;

@Controller

public class MainController {
	@Autowired
	@Qualifier("myTemplate")
	HibernateSessionBean sessionFactory;
}

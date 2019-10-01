package com.carmanagement.domain;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class HibernateSessionBean {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}

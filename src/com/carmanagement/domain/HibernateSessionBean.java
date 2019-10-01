package com.carmanagement.domain;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.carmanagement.domain.UserBean;

public class HibernateSessionBean {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean loginCheck(UserBean lb) {
		boolean a = false;
		try {
			String query = "from UserBean where name=:name1 and pass=:pass1";
			String queryParamName[] = { "name1", "pass1" };
			String queryValue[] = { lb.getName(), lb.getPass() };
			List<UserBean> login = (List) hibernateTemplate.findByNamedParam(query, queryParamName, queryValue);

			if (!login.isEmpty()) {
				a = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error  ; " + e);
		}
		return a;
	}
}

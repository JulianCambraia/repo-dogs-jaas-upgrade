package br.com.jfac.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.jfac.dao.UserDAO;
import br.com.jfac.model.User;

@Stateless
public class UserFacadeImpl implements UserFacade {

	@EJB
	private UserDAO userDAO;
	
	@Override
	public User findUserByEmail(String email) {
		
		return userDAO.findUserByEmail(email);
	}
}

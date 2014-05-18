package br.com.jfac.facade;

import javax.ejb.Local;

import br.com.jfac.model.User;

@Local
public interface UserFacade {
	
	public User findUserByEmail(String email); 

}

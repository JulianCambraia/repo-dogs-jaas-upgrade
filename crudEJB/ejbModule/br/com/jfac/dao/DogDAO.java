package br.com.jfac.dao;

import javax.ejb.Stateless;

import br.com.jfac.model.Dog;

@Stateless
public class DogDAO extends GenericDAO<Dog> {
	public DogDAO() {
		super(Dog.class);
	}

	public void delete(Dog dog) {
		super.delete(dog.getId(),Dog.class);
	}
}

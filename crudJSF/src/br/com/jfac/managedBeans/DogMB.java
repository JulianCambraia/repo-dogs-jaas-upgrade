package br.com.jfac.managedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.jfac.facade.DogFacade;
import br.com.jfac.model.Dog;

@ManagedBean
@RequestScoped
public class DogMB {
	
	@EJB
	private DogFacade dogFacade;
	
	private static final String CREATE_DOG = "createDog";
	private static final String DELETE_DOG = "deleteDog";
	private static final String UPDATE_DOG = "updateDog";
	private static final String LIST_ALL_DOGS = "listAllDogs";
	private static final String STAY_IN_THE_SAME_PAGE = null;
	
	private Dog dog;

	public Dog getDog() {
		if (dog == null) {
			dog = new Dog();
		}
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
	public List<Dog> getAllDogs() {
		return dogFacade.findAll();
	}
	
	public String updateDogStart() {
		return UPDATE_DOG;
	}
	
	public String updateDogEnd() {
		try {
			dogFacade.update(dog);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Verifique se o tamanho está abaixo de 0 ou contacte o administrador." );
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação completada: Dados Atualizados.");
		return LIST_ALL_DOGS;
	}
	
	public String deleteDogStart() {
		return DELETE_DOG;
	}
	
	public String deleteDogEnd() {
		try {
			dogFacade.delete(dog);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Ao tentar excluir os dados do cachorro. Contacte o administrador.");
			
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação completada: Dados Atualizados.");
		return LIST_ALL_DOGS;
	}
	
	public String createDogStart() {
		return CREATE_DOG;
	}
	
	public String createDogEnd() {
		try {
			dogFacade.save(dog);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Verifique se o tamanho é maior que 0 ou contacte o administrador.");
			
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operação completada: Dados Atualizados.");
		return LIST_ALL_DOGS;
	}
	
	public String listAllDogs() {
		return LIST_ALL_DOGS;
	}
	
	private void sendInfoMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	private void sendErrorMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
		
	}
	
	private FacesContext getContext() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		return context;
	}
}

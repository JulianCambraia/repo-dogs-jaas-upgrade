package br.com.jfac.managedBeans;

import java.security.Principal;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SessionScoped
@ManagedBean
public class LoginMB {

	private String username;

	private String password;

	private Date currenteDate = new Date();

	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

	public LoginMB() {
		if (session != null) {
			//session.invalidate();
		}
	}

	public String login() {
		String message = "";
		String navigator = "";

		try {

			request.login(username, password);
			Principal principal = request.getUserPrincipal();

			if (request.isUserInRole("Administrator")) {
				message = "Usuário : "
						+ principal.getName()
						+ " Você é Administrador e tem direito a todos as funcionalidades!";
				navigator = "admin";
			} else if (request.isUserInRole("Manager")) {
				message = "Usuário : "
						+ principal.getName()
						+ "Você é um Diretor e pode visualizar todos os relatórios gerenciais!";
				navigator = "manager";
			} else if (request.isUserInRole("Operator")) {
				message = "Usuário : " + principal.getName()
						+ "Você é um Operador, Por Favor Atenda bem o cliente!";
				navigator = "operator";
			}

			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,message, null));
			
			return navigator;
			
		} catch (ServletException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu algum problema e o Login Falhou!", null));
			e.printStackTrace();
		}
		
		return "failure";
	}

	public String logout(){
	   if (session != null) {
	     session.invalidate();
	   }                                                                                                                                                     
	   return "logout";
	 }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCurrenteDate() {
		return currenteDate;
	}

	public void setCurrenteDate(Date currenteDate) {
		this.currenteDate = currenteDate;
	}
}
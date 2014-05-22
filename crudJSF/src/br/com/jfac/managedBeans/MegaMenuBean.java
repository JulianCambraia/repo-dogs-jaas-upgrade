package br.com.jfac.managedBeans;

import javax.faces.bean.ManagedBean;

import org.primefaces.component.column.Column;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@ManagedBean
public class MegaMenuBean {
	private MenuModel menuModel;

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public MegaMenuBean() {
		this.menuModel = new DefaultMenuModel();

		Submenu cadastrosMenu = new Submenu();
		cadastrosMenu.setLabel("Cadastros");

		Submenu cadBasicoMenu = new Submenu();
		cadBasicoMenu.setLabel("Básicos");

		MenuItem item = new MenuItem();
		item.setValue("Criar Cachorro");
		item.setOutcome("createDog");
		cadBasicoMenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Atualizar Cachorro");
		item.setOutcome("listAllDogs");
		cadBasicoMenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Excluir Cachoro");
		item.setOutcome("listAllDogs");
		cadBasicoMenu.getChildren().add(item);

		Submenu cadAvancadoMenu = new Submenu();
		cadAvancadoMenu.setLabel("Área Restrita à Gerência");

		item = new MenuItem();
		item.setValue("Gráficos");
		item.setOutcome("manager.graficos3D");
		cadAvancadoMenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Balancete Anual");
		item.setOutcome("manager.balancete");
		cadAvancadoMenu.getChildren().add(item);

		Submenu adminMenu = new Submenu();
		adminMenu.setLabel("Área do Administrador");

		item = new MenuItem();
		item.setValue("Listagem Geral de Cães");
		item.setOutcome("listAllDogs");
		adminMenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Listagem de Usuários");
		item.setOutcome("listAllUsers");
		adminMenu.getChildren().add(item);

		Column cadastrosColuna1 = new Column();
		cadastrosColuna1.getChildren().add(cadBasicoMenu);
		cadastrosColuna1.getChildren().add(cadAvancadoMenu);
		cadastrosMenu.getChildren().add(cadastrosColuna1);

		Column cadastrosColuna2 = new Column();
		cadastrosColuna2.getChildren().add(adminMenu);
		cadastrosMenu.getChildren().add(cadastrosColuna2);

		this.menuModel.addSubmenu(cadastrosMenu);

		Submenu relatoriosMenu = new Submenu();
		relatoriosMenu.setLabel("Relatórios");

		Submenu relBasicosMenu = new Submenu();
		relBasicosMenu.setLabel("Básico");

		item = new MenuItem();
		item.setValue("Listagem de Cães");
		item.setUrl("#");
		relBasicosMenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Listagem de Usuários");
		item.setUrl("#");
		relBasicosMenu.getChildren().add(item);

		Submenu tecnologiaMenu = new Submenu();
		tecnologiaMenu.setLabel("Tecnologia");

		item = new MenuItem();
		item.setValue("Segurança");
		item.setUrl("#");
		tecnologiaMenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Negócios em TI");
		item.setUrl("#");
		tecnologiaMenu.getChildren().add(item);

		Submenu educacaoMenu = new Submenu();
		educacaoMenu.setLabel("Detalhado");

		item = new MenuItem();
		item.setValue("Função");
		item.setUrl("#");
		educacaoMenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Sub-Função");
		item.setUrl("#");
		educacaoMenu.getChildren().add(item);

		item = new MenuItem();
		item.setValue("Rotinas");
		item.setUrl("#");
		educacaoMenu.getChildren().add(item);

		Column noticiaColuna1 = new Column();
		noticiaColuna1.getChildren().add(relBasicosMenu);
		noticiaColuna1.getChildren().add(tecnologiaMenu);
		relatoriosMenu.getChildren().add(noticiaColuna1);

		Column noticiaColuna2 = new Column();
		noticiaColuna2.getChildren().add(educacaoMenu);
		relatoriosMenu.getChildren().add(noticiaColuna2);

		this.menuModel.addSubmenu(relatoriosMenu);

		Submenu logoutMenu = new Submenu();
		logoutMenu.setLabel("Sair");

		Submenu exitMenu = new Submenu();
		exitMenu.setLabel("Logout");

		item = new MenuItem();
		item.setValue("Logout");
		item.setOutcome("logout");

		exitMenu.getChildren().add(item);

		Column logoutColuna1 = new Column();
		logoutColuna1.getChildren().add(exitMenu);
		logoutMenu.getChildren().add(logoutColuna1);

		this.menuModel.addSubmenu(logoutMenu);
	}
}

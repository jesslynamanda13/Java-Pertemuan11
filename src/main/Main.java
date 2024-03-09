package main;

import javafx.application.Application;
import javafx.stage.Stage;
import models.AccountManagement;
import pages.LoginPage;
import pages.SignUpPage;

public class Main extends Application{
	public AccountManagement dashboard = new AccountManagement();

	public Main() {
		
	}
	
	public AccountManagement getDashboard() {
		return dashboard;
	}

	public void setDashboard(AccountManagement dashboard) {
		this.dashboard = dashboard;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		SignUpPage signUpPage = new SignUpPage(stage, dashboard);
		stage.setScene(signUpPage.getScene());
		stage.show();
	}


}

package pages;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;
import models.AccountManagement;
import models.User;

public class Home {
	protected Stage stage;
	protected Scene scene;
	protected BorderPane borderPane; 
	protected Main main;
	protected TableView<User> viewUser;
	protected AccountManagement dashboard;
	protected Label activeUserlabel;
	
	public void init() {
		ObservableList<User> userList = FXCollections.observableArrayList(dashboard.getUsers());
		System.out.println(dashboard.getActiveUser().getEmail());
		User activeUser = dashboard.getActiveUser();
		
		TableColumn<User, String> emailColumn = new TableColumn<>("Email");
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		
		TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
	    usernameColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
	        
	    viewUser = new TableView<>();
	    viewUser.setItems(userList);
	    viewUser.getColumns().addAll(emailColumn, usernameColumn);

	    activeUserlabel = new Label(activeUser.getEmail());
	}
	public void setLayout() {
		 borderPane = new BorderPane();

		 ScrollPane scrollPane = new ScrollPane();
		 scrollPane.setContent(viewUser);

		 borderPane.setCenter(scrollPane);
		 borderPane.setBottom(activeUserlabel);
	}
	
	public Scene getScene() {
		return scene;
	}

	public Home(Stage stage, AccountManagement dashboard) {
		this.dashboard = dashboard;
		init();
		setLayout();
		this.stage = stage;
	    this.stage.setTitle("Dashboard");
	    this.scene = new Scene(borderPane, 600, 600);
	}

}

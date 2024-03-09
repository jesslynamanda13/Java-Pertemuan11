package pages;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;
import models.AccountManagement;
import pages.Home;

public class LoginPage{
	protected Stage stage;
	
	protected Scene scene;
	
	protected BorderPane borderPane; 
	protected VBox centerBox;
	
	protected Label loginText, emailLabel, passwordLabel;
	protected Image image;
	protected Button loginButton;
	protected TextField emailTF, passwordTF;
	protected AccountManagement dashboard;

	protected void init() {
		borderPane = new BorderPane();
        loginText = new Label("Login");
        loginText.setStyle("-fx-font-size: 24; -fx-font-family: 'Comic Sans MS'; -fx-text-fill: white;");

        emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-text-fill: white;");

        passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-text-fill: white;");

        emailTF = new TextField();
        passwordTF = new PasswordField();
     

        loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white;");
        
        EventHandler<MouseEvent> loginClicked = event ->{
        	String emailUser = emailTF.getText();
        	String passUser = passwordTF.getText();
        	boolean loginStatus = dashboard.loginUser(emailUser, passUser);
        	if(loginStatus) {
        		System.out.println("Login is Successful!");
        		// redirect to Home
        		Home home = new Home(stage, dashboard);
				Scene homeScene = home.getScene();
	            stage.setScene(homeScene);
        	}
        };
        loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, loginClicked);
	}
	
	
	protected void setLayout() {
		// add the components to the layout manager
		centerBox = new VBox(5);
        centerBox.setPadding(new Insets(5));
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(loginText, emailLabel, emailTF, passwordLabel, passwordTF, loginButton);
        centerBox.setStyle("-fx-background-color: #3498db;");
       
        borderPane.setCenter(centerBox);
	}
	
	public Scene getScene() {
		return scene;
	}

	public LoginPage(Stage stage, AccountManagement dashboard) {
		this.dashboard = dashboard;
		init();
		setLayout();
		this.stage = stage;
        this.stage.setTitle("Login");
        this.scene = new Scene(borderPane, 600, 600);
	}

}

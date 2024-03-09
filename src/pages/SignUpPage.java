package pages;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;
import models.AccountManagement;
import models.User;

public class SignUpPage {
    protected Stage stage;
    protected Scene scene;
    protected BorderPane borderPane;
    protected VBox centerBox;

    protected Label signupText, emailLabel, usernameLabel, passwordLabel, confirmPasswordLabel;
    protected TextField emailTF, usernameTF;
    protected PasswordField passwordTF, confirmPasswordTF;
    protected Button signupButton, backButton;
    protected AccountManagement dashboard;

    protected void init() {
        borderPane = new BorderPane();
        signupText = new Label("Sign Up");
        signupText.setStyle("-fx-font-size: 24; -fx-font-family: 'Comic Sans MS'; -fx-text-fill: white;");

        emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-text-fill: white;");

        usernameLabel = new Label("Username:");
        usernameLabel.setStyle("-fx-text-fill: white;");

        passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-text-fill: white;");

        confirmPasswordLabel = new Label("Confirm Password:");
        confirmPasswordLabel.setStyle("-fx-text-fill: white;");

        emailTF = new TextField();
        usernameTF = new TextField();
        passwordTF = new PasswordField();
        confirmPasswordTF = new PasswordField();

        signupButton = new Button("Sign Up");
        signupButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white;");

        backButton = new Button("Back to Login");
        backButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
        
        EventHandler<MouseEvent> signupClicked = event -> {
            String email = emailTF.getText();
            String username = usernameTF.getText();
            String password = passwordTF.getText();
            User newUser = new User(username, email, password);
            dashboard.signUpUser(newUser);
            LoginPage loginPage = new LoginPage(stage, dashboard);
            Scene loginScene = loginPage.getScene();
            stage.setScene(loginScene);
        };

        signupButton.addEventHandler(MouseEvent.MOUSE_CLICKED, signupClicked);

        EventHandler<MouseEvent> backClicked = event -> {
            LoginPage loginPage = new LoginPage(stage, dashboard);
            Scene loginScene = loginPage.getScene();
            stage.setScene(loginScene);
        };

        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, backClicked);
    }

    protected void setLayout() {
        centerBox = new VBox(5);
        centerBox.setPadding(new Insets(5));
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(
                signupText, emailLabel, emailTF, usernameLabel, usernameTF,
                passwordLabel, passwordTF, confirmPasswordLabel, confirmPasswordTF, signupButton, backButton
        );
        centerBox.setStyle("-fx-background-color: #27ae60;");

        borderPane.setCenter(centerBox);
    }

    public Scene getScene() {
        return scene;
    }

    public SignUpPage(Stage stage, AccountManagement dashboard) {
    	this.dashboard = dashboard;
        init();
        setLayout();
        this.stage = stage;
        this.stage.setTitle("Sign Up");
        this.scene = new Scene(borderPane, 600, 600);
    }
}

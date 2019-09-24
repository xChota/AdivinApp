package dad.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

	private TextField numText;
	private Button comprobarButton;
	private Label checkLabel;

	public void start(Stage primaryStage) throws Exception {
		numText = new TextField();
		numText.setPromptText("Introduce un numero");
		numText.setMaxWidth(150);
		
		checkLabel = new Label ("Introduce un numero del 1 al 100");
		
		comprobarButton = new Button("Comprobar");
		comprobarButton.setDefaultButton(true);

		comprobarButton.setOnAction(e -> onComprobarButtonAction(e));
		

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(checkLabel, numText, comprobarButton);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	boolean checkNumero(int num1, int num2) {
		return num1==num2;
	}
	
	int numeroRandom = (int) Math.floor((Math.random() * 100) + 1);
	int intentos = 0;
	
	private void onComprobarButtonAction(ActionEvent e) {
		
		try {
		int numero = Integer.parseInt (numText.getText());	
		intentos++;
		
		if (checkNumero(numero, numeroRandom)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("¡Has ganado!");
			alert.setContentText("Sólo has necesitado "+ intentos +" intentos.\n\n Vuelve a jugar y hazlo mejor");
			alert.showAndWait();
			numeroRandom = (int) Math.floor((Math.random() * 100) + 1);
			intentos=0;
		}
		else {
			if (numero>numeroRandom) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("El numero a adivinar es menor que " + numero);
				alert.showAndWait();
			}
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("El numero a adivinar es mayor que " + numero);
				alert.showAndWait();
			}
		}	
			} catch (Exception e2) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("Error");
				alert.setContentText("El numero introducido no es valido");
				alert.showAndWait();
			}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
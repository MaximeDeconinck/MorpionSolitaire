package application;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main_SceneController {
	@FXML
	private AnchorPane title;
	@FXML
	private TextField tfTitle;
	@FXML
	private ChoiceBox tfCHoicebox;
	

	// Event Listener on Button.onAction
	@FXML
	public void btnRefreshClicked(ActionEvent event) {
		Stage mainWindow = (Stage) tfTitle.getScene().getWindow();
		String title = tfTitle.getText();
		mainWindow.setTitle(title);
	}
}

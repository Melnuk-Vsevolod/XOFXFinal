
package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import logic.Logic;

public class MainController {

	public static Scene theScene;

	public Logic lg = new Logic();
	@FXML
	private Button b1;
	@FXML
	private Button b2;
	@FXML
	private Button b3;
	@FXML
	private Button b4;
	@FXML
	private Button b5;
	@FXML
	private Button b6;
	@FXML
	private Button b7;
	@FXML
	private Button b8;
	@FXML
	private Button b9;

	@FXML
	Label label;
	@FXML
	Label label1;
	@FXML
	Button btnRestart;
	@FXML
	Line lineHorisontal1;
	@FXML
	Line lineHorisontal2;
	@FXML
	Line lineHorisontal3;
	@FXML
	Line lineVertical1;
	@FXML
	Line lineVertical2;
	@FXML
	Line lineVertical3;
	@FXML
	Line LineDiagonal1;
	@FXML
	Line LineDiagonal2;

	@FXML
	private void initialize() {
		theScene = LineDiagonal2.getScene();
		
		lg.putLine();

		if ((lg.isCPUFirstMove) && (lg.isCPUTurn) && (lg.whosMoveAfterRandom)) {
			lg.CPUMMadeMove();
			lg.isCPUFirstMove = false;
		}
		if (lg.winner == "CPU") {
			label1.setText("CPU Win");
		} else {
			label1.setText("Ходим");
		}
		// if (lg.isCPUTurn == true) {
		// label.setText("CPU turn");
		// } else {
		// label.setText("Player turn");
		// }
		label.setText(":)))");

		System.out.println("init");
		System.out.print(Logic.arr[0] + " ");
		System.out.print(Logic.arr[1] + " ");
		System.out.println(Logic.arr[2] + " ");
		System.out.print(Logic.arr[3] + " ");
		System.out.print(Logic.arr[4] + " ");
		System.out.println(Logic.arr[5] + " ");
		System.out.print(Logic.arr[6] + " ");
		System.out.print(Logic.arr[7] + " ");
		System.out.println(Logic.arr[8] + " ");
		
		if (Logic.firstStart==false){
			changeBtnText();
		}
		
		

		if (lg.lH1 == true) {
			lineHorisontal1.setVisible(true);
		} else {
			lineHorisontal1.setVisible(false);
		}
		if (lg.lH2 == true) {
			lineHorisontal2.setVisible(true);
		} else {
			lineHorisontal2.setVisible(false);
		}
		if (lg.lH3 == true) {
			lineHorisontal3.setVisible(true);
		} else {
			lineHorisontal3.setVisible(false);
		}
		if (lg.lV1 == true) {
			lineVertical1.setVisible(true);
		} else {
			lineVertical1.setVisible(false);
		}
		if (lg.lV2 == true) {
			lineVertical2.setVisible(true);
		} else {
			lineVertical2.setVisible(false);
		}
		if (lg.lV3 == true) {
			lineVertical3.setVisible(true);
		} else {
			lineVertical3.setVisible(false);
		}
		if (lg.lD1 == true) {
			LineDiagonal1.setVisible(true);
		} else {
			LineDiagonal1.setVisible(false);
		}
		if (lg.lD2 == true) {
			LineDiagonal2.setVisible(true);
		} else {
			LineDiagonal2.setVisible(false);
		}
		
		if ((lg.lH1 == true) || (lg.lH2 == true) || (lg.lH3 == true) || (lg.lV1 == true) || (lg.lV2 == true)
				|| (lg.lV3 == true) || (lg.lD1 == true) || (lg.lD2 == true)) {
			disableAllButtons();
		}
		

	}
	
	
	public void changeBtnText(){
			
	for (int i = 0; i < Logic.arr.length; i++) {
		String curentID = "#b" + (i + 1);
	
		Button tempBtn = (Button) theScene.lookup(curentID);

		if (Logic.arr[i] == 1) {
			tempBtn.setDisable(true);
			tempBtn.setText("O");
		}
		if (Logic.arr[i] == -1) {
			tempBtn.setDisable(true);
			tempBtn.setText("X");
		}
		if (Logic.arr[i] == 0) {
			tempBtn.setDisable(false);
			tempBtn.setText("");
		}

	}
	}

	public void showDialog(ActionEvent actionEvent) {

		Object source = actionEvent.getSource();

		if (!(source instanceof Button)) {
			return;
		}

		Button clickedButton = (Button) source;

		whatButtonWasClickedByPlayerForLogic(clickedButton.getId());
		initialize();
		lg.isCPUTurn = true;
		lg.CPUMMadeMove();
		if (lg.draw() == true) {
			label1.setText("DRAW!!!");
			
		}
		lg.putLine();
		initialize();

	}

	public void whatButtonWasClickedByPlayerForLogic(String clickedButton) {

		switch (clickedButton) {
		case "b1":
			Logic.arr[0] = -1;
			break;
		case "b2":
			Logic.arr[1] = -1;
			break;
		case "b3":
			Logic.arr[2] = -1;
			break;
		case "b4":
			Logic.arr[3] = -1;
			break;
		case "b5":
			Logic.arr[4] = -1;
			break;
		case "b6":
			Logic.arr[5] = -1;
			break;
		case "b7":
			Logic.arr[6] = -1;
			break;
		case "b8":
			Logic.arr[7] = -1;
			break;
		case "b9":
			Logic.arr[8] = -1;
			break;
		}

	}

	@FXML
	public void Restart(ActionEvent event) throws InterruptedException {
		Logic.firstStart=false;
		
		theScene = ((Node) b2).getScene();
		
		
		lg.restart();
		initialize();
		// line();

	}
	
	public void disableAllButtons(){
		for (int i = 0; i < Logic.arr.length; i++) {
			String curentID = "#b" + (i + 1);
					Button tempBtn = (Button) theScene.lookup(curentID);
					tempBtn.setDisable(true);
	}
	}

	// public void line() throws InterruptedException {
	// for (double i = 0; i < 90; i++, Thread.sleep(10)) {
	// line1.setEndX(i);
	// }
	//
	// }

}///////////////// CLASS END
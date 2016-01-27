package presentation.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import domain.Employee;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import logic.Controller;
import presentation.ControlledScreen;
import presentation.ScreenController;

public class TableViewBySkillsController implements Initializable, ControlledScreen {

	@FXML
	private TextField txtfieldName;
	@FXML
	private TableView<Employee> tableView;
	@FXML
	private TableColumn name;
	@FXML
	private TableColumn email;
	@FXML
	private TableColumn skills;

	List<Employee> data = null;
	ScreenController screenController;
	private Controller appController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void btnFindEmployee(ActionEvent event) {
		screenController.setScreen("findEmployee");
	}

	@Override
	public void setScreenController(ScreenController screenController) {
		this.screenController = screenController;
	}

	@Override
	public void setAppController(Controller appController) {
		this.appController = appController;
	}

	@Override
	public List<?> getData() {
		return this.data;
	}

	@Override
	public void setData(List<?> data) {
		this.data = (List<Employee>) data;
	}

	@Override
	public void init() {
		name.setCellValueFactory(new PropertyValueFactory<>("name"));

		email.setCellValueFactory(new PropertyValueFactory<>("email"));

		Callback<TableColumn<Employee, String>, TableCell<Employee, String>> cellFactory = new Callback<TableColumn<Employee, String>, TableCell<Employee, String>>() {
			@Override
			public TableCell call(final TableColumn<Employee, String> param) {
				final TableCell<Employee, String> cell = new TableCell<Employee, String>() {

					final Button btn = new Button();

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							Employee employee = (Employee) getTableRow().getItem();
							if (employee != null) {
							btn.setText(String.valueOf(employee.getMatchingSkillsCount()) + ": Show skills");
							}
							btn.getStyleClass().add("transparentButton");
							btn.setPadding(new Insets(0, 0, 0, 30));
							btn.setOnMouseEntered(e -> {
								btn.setStyle("-fx-underline: true");
								btn.setCursor(Cursor.HAND);
							});
							btn.setOnMouseExited(e -> {
								btn.setStyle("-fx-underline: false");
							});

							btn.setOnAction((ActionEvent event) -> {
								// This list is not a boolean!
								List<Employee> somethingThatWorks = new ArrayList<>();
								somethingThatWorks.add(employee);
								screenController.setScreen("employeeProfile", somethingThatWorks);
							});
							setGraphic(btn);
							setText(null);
						}
					}
				};
				return cell;
			}
		};
		skills.setCellFactory(cellFactory);

		tableView.setItems((FXCollections.observableArrayList(data)));
		tableView.setPlaceholder(new Label("No employees found."));

	}
}

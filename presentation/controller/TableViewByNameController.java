package presentation.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import domain.Employee;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import logic.Controller;
import presentation.ControlledScreen;
import presentation.ScreenController;

public class TableViewByNameController implements Initializable, ControlledScreen {
	@FXML
	private Button btnFindSkills;

	@FXML
	private TextField txtfieldName;

	@FXML
	private Button btnSearch;

	@FXML
	private TableView<Employee> tableView;
	@FXML
	private TableColumn name;
	@FXML
	private TableColumn email;
	@FXML
	private TableColumn skills;
	
	@FXML
	private Button btnDAS;

	@FXML
	private Button btnEAS;

	List<Employee> data = null;
	ScreenController screenController;
	private Controller appController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void btnFindEmployee(ActionEvent event) {
		screenController.setScreen("findEmployee");
	}

	public void btnSearchEmployeeByName(ActionEvent event) {

	}

	public void btnDAS(ActionEvent event) {
		screenController.setScreen("departmentAndSkills");
	}

	public void btnEAS(ActionEvent event) {
		screenController.setScreen("employeeProfile");
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

					final Button btn = new Button("Show skills");

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							btn.setOnAction((ActionEvent event) -> {
								screenController.setScreen("employeeProfile");
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
		for (Employee employee : data) {
			System.out.println(employee);
		}

		tableView.setItems((FXCollections.observableArrayList(data)));

	}
}

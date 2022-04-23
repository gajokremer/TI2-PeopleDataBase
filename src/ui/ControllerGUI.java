package ui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.DataBase;
import model.Gender;
import model.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerGUI {

    private final DataBase dataBase;

    public ControllerGUI() {

        dataBase = new DataBase();
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    @FXML
    private Pane mainPane;

    @FXML
    private DatePicker dpBirthDate;

    @FXML
    private HBox hBox;

    private ChoiceBox<String> cb;

    @FXML
    private TextField tfFullName;

    @FXML
    private TextField tfHeight;

    @FXML
    private TextField tfNationality;

    @FXML
    void start(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        fxmlLoader.setController(this);
        Parent menu = fxmlLoader.load();
        mainPane.getChildren().setAll(menu);
    }

    @FXML
    void close(ActionEvent event) {

        Platform.exit();
    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void load(ActionEvent event) {

    }

    @FXML
    void add(ActionEvent event) throws IOException {

//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Add.fxml"));
//        fxmlLoader.setController(this);
//        Parent menu = fxmlLoader.load();
//        mainPane.getChildren().setAll(menu);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPopUp.fxml"));
        fxmlLoader.setController(this);
        DialogPane dialoguePane = fxmlLoader.load();

        ArrayList<String> genders = new ArrayList<>();
        genders.add("MALE");
        genders.add("FEMALE");

        ObservableList<String> observableList = FXCollections.observableArrayList(genders);
        cb = new ChoiceBox<>(observableList);

        hBox.getChildren().add(cb);

        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setDialogPane(dialoguePane);
        dialog.showAndWait();

//        ArrayList<String> genders = new ArrayList<>();
//        genders.add("MALE");
//        genders.add("FEMALE");
//
//        ObservableList<String> observableList = FXCollections.observableArrayList(genders);
//        cb = new ChoiceBox<>(observableList);
//
//        hBox.getChildren().add(cb);

    }

    @FXML
    void addPerson(ActionEvent event) {

        if (tfFullName.getText().trim().isEmpty() || cb.getSelectionModel().isEmpty() || dpBirthDate.getValue() == null
                || tfHeight.getText().trim().isEmpty() || tfNationality.getText().trim().isEmpty()) {

            showWarningDialogue("Add person error", "All data must be present");

        } else {

            String fullName = tfFullName.getText();
            String[] fullNameArray = fullName.split(" ");

            String name = fullNameArray[0];
            String surname = fullNameArray[1];

            Gender gender = Gender.valueOf(cb.getSelectionModel().getSelectedItem());

            LocalDate aDate = dpBirthDate.getValue();
            String birthDate = aDate.toString();

            double height = Double.parseDouble(tfHeight.getText());

            String nationality = tfNationality.getText();

            Person person = new Person(name, surname, gender, birthDate, height, nationality);

//            System.out.println("-Person: " + person);
            dataBase.addToAllTrees(person);

            System.out.println("\n\n=Code tree: " + dataBase.getCodeTree());

            showSuccessDialogue("Successful!", "Person added successfully");

            tfFullName.setText("");
//            cb.setSelectionModel(null);
            dpBirthDate.setValue(null);
            tfHeight.setText("");
            tfNationality.setText("");
        }
    }

    public void showSuccessDialogue(String header, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Data Base");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showWarningDialogue(String header, String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Data Base");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
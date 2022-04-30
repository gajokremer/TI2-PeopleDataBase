package ui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
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
    private TextField tfSearchBar;

    @FXML
    private TextField tfToModify;

    @FXML
    private TextField tfCode;

    private Person toModify;

    @FXML
    void start(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        fxmlLoader.setController(this);
        Parent menu = fxmlLoader.load();
        mainPane.getChildren().setAll(menu);

        Person p1 = new Person("Gabriel", "Kremer", Gender.MALE,
                "2002-08-02", 181, "Colombian");
        dataBase.insertToAllTrees(p1);
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
        hBox.getChildren().setAll(cb);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialoguePane);
        dialog.showAndWait();

//        ArrayList<String> genders = new ArrayList<>();
//        genders.add("MALE");
//        genders.add("FEMALE");
//
//        ObservableList<String> observableList = FXCollections.observableArrayList(genders);
//        cb = new ChoiceBox<>(observableList);
//
//        hBox.getChildren().setAll(cb);

    }

    @FXML
    void addPerson(ActionEvent event) {

//        if (tfFullName.getText().trim().isEmpty() || cb.getSelectionModel().isEmpty() || dpBirthDate.getValue() == null
//                || tfHeight.getText().trim().isEmpty() || tfNationality.getText().trim().isEmpty()) {
        if (!tfFullName.getText().trim().isEmpty() && !cb.getSelectionModel().isEmpty() &&
                dpBirthDate.getValue() != null && !tfHeight.getText().trim().isEmpty() &&
                !tfNationality.getText().trim().isEmpty()) {

            String fullName = tfFullName.getText();
            String[] fullNameArray = fullName.split(" ");

            String name = fullNameArray[0];
            String surname = fullNameArray[1];

            Gender gender = Gender.valueOf(cb.getSelectionModel().getSelectedItem());

            LocalDate aDate = dpBirthDate.getValue();
            String birthDate = aDate.toString();

            double height = Double.parseDouble(tfHeight.getText());

            String nationality = tfNationality.getText();

            Person newPerson = new Person(name, surname, gender, birthDate, height, nationality);

//            System.out.println("-Person: " + person);
            dataBase.insertToAllTrees(newPerson);

            printAllTrees();

//            System.out.println("\n\n=Height tree: " + dataBase.getHeightTree());

            showSuccessDialogue("Successful!", "Person added successfully.");

            tfFullName.setText("");
//            cb.setSelectionModel(null);
            dpBirthDate.setValue(null);
            tfHeight.setText("");
            tfNationality.setText("");

        } else {

            showWarningDialogue("Addition error", "All data must be present.");
        }
    }

    private void printAllTrees() {

        System.out.println("\n\n------PRINT TREES------");

        System.out.println("\n=Code tree: " + dataBase.getCodeTree());
        System.out.println("\n=Name tree: " + dataBase.getNameTree());
        System.out.println("\n=Surname tree: " + dataBase.getSurnameTree());
        System.out.println("\n=Full Name tree: " + dataBase.getFullNameTree());
    }

    @FXML
    void search(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchPopUp.fxml"));
        fxmlLoader.setController(this);
        DialogPane dialoguePane = fxmlLoader.load();

        ArrayList<String> searchParameters = new ArrayList<>();
        searchParameters.add("Code");
        searchParameters.add("Name");
        searchParameters.add("Surname");
        searchParameters.add("Full Name");

        ObservableList<String> observableList = FXCollections.observableArrayList(searchParameters);
        cb = new ChoiceBox<>(observableList);
        hBox.getChildren().setAll(cb);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialoguePane);
        dialog.showAndWait();

//        tfToModify.setText(toModify.getFullName());
    }

    @FXML
    void searchPerson(ActionEvent event) throws IOException {

        System.out.println("\nSearch Parameter: " + cb.getSelectionModel().getSelectedItem());
        System.out.println("Search bar: " + tfSearchBar.getText());

        if (!cb.getSelectionModel().isEmpty() && !tfSearchBar.getText().trim().isEmpty()) {

            Person personToFind = new Person();
            String search = tfSearchBar.getText();

            switch (cb.getSelectionModel().getSelectedItem().toLowerCase()) {

                case "code":

                    personToFind.setCode(Integer.parseInt(search));
                    toModify = dataBase.getCodeTree().find(personToFind);

                    break;

                case "name":

                    personToFind.setName(search);
                    toModify = dataBase.getNameTree().find(personToFind);

                    break;

                case "surname":

                    personToFind.setSurname(search);
                    toModify = dataBase.getSurnameTree().find(personToFind);

                    break;

                case "full name":

                    String[] parts = search.split(" ");

                    personToFind.setFullName(parts[0], parts[1]);
                    System.out.println("\nPerson to find: " + personToFind.getFullName());

                    toModify = dataBase.getFullNameTree().find(personToFind);

                    break;
            }

            if (toModify != null) {

                showSuccessDialogue("Person found", "Click modify in menu to make changes to this person.");
//                tfToModify.setText(toModify.getFullName());
                tfToModify.setText(search);

            } else {

                showWarningDialogue("Search error", "Person not found in database.");
            }

            System.out.println("\n-Modifying now: " + toModify);

//            cb.setSelectionModel(null);
            tfSearchBar.setText("");

        } else {

            showWarningDialogue("Search error", "All data must be present.");
        }
    }

    @FXML
    void modify() throws IOException {

        if (toModify != null) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyPopUp.fxml"));
            fxmlLoader.setController(this);
            DialogPane dialoguePane = fxmlLoader.load();

            ArrayList<String> genders = new ArrayList<>();
            genders.add("MALE");
            genders.add("FEMALE");

            ObservableList<String> observableList = FXCollections.observableArrayList(genders);
            cb = new ChoiceBox<>(observableList);
            hBox.getChildren().setAll(cb);

            tfCode.setText(String.valueOf(toModify.getCode()));

            tfFullName.setText(toModify.getFullName());
            dpBirthDate.setValue(LocalDate.parse(toModify.getBirthDate()));
            tfHeight.setText(String.valueOf(toModify.getHeight()));
            tfNationality.setText(toModify.getNationality());


            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(dialoguePane);
            dialog.showAndWait();

            toModify = null;
            tfToModify.setText("");

        } else {

            showWarningDialogue("Modify error", "No person is being modified. " +
                    "Open search menu to assign one.");
        }
    }

    @FXML
    void updatePerson(ActionEvent event) {

        if (!tfFullName.getText().trim().isEmpty() && !cb.getSelectionModel().isEmpty() &&
                dpBirthDate.getValue() != null && !tfHeight.getText().trim().isEmpty() &&
                !tfNationality.getText().trim().isEmpty()) {

            dataBase.deleteFromAllTrees(toModify);

            String fullName = tfFullName.getText();
            String[] fullNameArray = fullName.split(" ");

            String name = fullNameArray[0];
            String surname = fullNameArray[1];

            Gender gender = Gender.valueOf(cb.getSelectionModel().getSelectedItem());

            LocalDate aDate = dpBirthDate.getValue();
            String birthDate = aDate.toString();

            double height = Double.parseDouble(tfHeight.getText());

            String nationality = tfNationality.getText();

            Person newPerson = new Person(name, surname, gender, birthDate, height, nationality);

            dataBase.insertToAllTrees(newPerson);

            showSuccessDialogue("Successful!", "Person modified successfully.");

            tfCode.setText(String.valueOf(newPerson.getCode()));

            printAllTrees();

        } else {

            showWarningDialogue("Update error", "All data must be present.");
        }
    }

    @FXML
    void removePerson(ActionEvent event) {

        dataBase.deleteFromAllTrees(toModify);

        showSuccessDialogue("Removal successful", "This person has been erased from the database.");

        tfCode.setText("");
        tfFullName.setText("");
//            cb.setSelectionModel(null);
        dpBirthDate.setValue(null);
        tfHeight.setText("");
        tfNationality.setText("");
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
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
    private TextField tfSearchBar;

    private Person modifyingNow;

    @FXML
    void start(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        fxmlLoader.setController(this);
        Parent menu = fxmlLoader.load();
        mainPane.getChildren().setAll(menu);

        Person p1 = new Person("Gabriel", "Kremer", Gender.MALE,
                "2002-08-02", 181, "Colombian");
        dataBase.addToAllTrees(p1);
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
            dataBase.addToAllTrees(newPerson);

//            System.out.println("\n\n=Code tree: " + dataBase.getCodeTree());
//            System.out.println("\n\n=Name tree: " + dataBase.getNameTree());
//            System.out.println("\n\n=Surname tree: " + dataBase.getSurnameTree());
            System.out.println("\n\n=Full Name tree: " + dataBase.getFullNameTree());
//            System.out.println("\n\n=Height tree: " + dataBase.getHeightTree());

            showSuccessDialogue("Successful!", "Person added successfully");

            tfFullName.setText("");
//            cb.setSelectionModel(null);
            dpBirthDate.setValue(null);
            tfHeight.setText("");
            tfNationality.setText("");

        } else {

            showWarningDialogue("Addition error", "All data must be present");
        }
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
        searchParameters.add("Full name");

        ObservableList<String> observableList = FXCollections.observableArrayList(searchParameters);
        cb = new ChoiceBox<>(observableList);

        hBox.getChildren().add(cb);

        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setDialogPane(dialoguePane);
        dialog.showAndWait();
    }

    @FXML
    void searchPerson(ActionEvent event) throws IOException {

//        System.out.println("\nSearch Parameter: " + cb.getSelectionModel().getSelectedItem());
//        System.out.println("Search bar: " + tfSearchBar.getText());
//
//        if (!cb.getSelectionModel().isEmpty() && !tfSearchBar.getText().trim().isEmpty()) {
//
//            Person personToFind = new Person();
//
//
//            switch (cb.getSelectionModel().getSelectedItem().toLowerCase()) {
//
//                case "code":
//
//                    break;
//
//                case "name":
//                    break;
//
//                case "surname":
//                    break;
//
//                case "full name":
//
//                    String[] parts = tfSearchBar.getText().split(" ");
//
//                    personToFind.setFullName(parts[0], parts[1]);
//                    System.out.println("\nPerson to find: " + personToFind.getFullName());
//
//                    modifyingNow = dataBase.getFullNameTree().find(personToFind);
//
//                    break;
//            }
//
//            if (modifyingNow != null) {
//
//                showSuccessDialogue("Person found", "This person is now being modified");
//            }
//
//            cb.setSelectionModel(null);
//            tfSearchBar.setText("");
//
//            System.out.println("\n-Modifying now: " + modifyingNow);
//
//        } else {
//
//            showWarningDialogue("Search error", "All data must be present");
//        }



        System.out.println("\nSearch Parameter: " + cb.getSelectionModel().getSelectedItem());
        System.out.println("Search bar: " + tfSearchBar.getText());

        if (!cb.getSelectionModel().isEmpty() && !tfSearchBar.getText().trim().isEmpty()) {

            Person personToFind = new Person();


            switch (cb.getSelectionModel().getSelectedItem().toLowerCase()) {

                case "code":

                    break;

                case "name":
                    break;

                case "surname":
                    break;

                case "full name":

                    String[] parts = tfSearchBar.getText().split(" ");

                    personToFind.setFullName(parts[0], parts[1]);
                    System.out.println("\nPerson to find: " + personToFind.getFullName());

                    modifyingNow = dataBase.getFullNameTree().find(personToFind);

                    break;
            }

            if (modifyingNow != null) {

                showSuccessDialogue("Person found", "This person is now being modified");
                modify(event);
            }

            cb.setSelectionModel(null);
            tfSearchBar.setText("");

            System.out.println("\n-Modifying now: " + modifyingNow);

        } else {

            showWarningDialogue("Search error", "All data must be present");
        }
    }

    @FXML
    void modify(ActionEvent event) throws IOException {

        if (modifyingNow != null) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyPopUp.fxml"));
            fxmlLoader.setController(this);
            DialogPane dialoguePane = fxmlLoader.load();

            ArrayList<String> genders = new ArrayList<>();
            genders.add("MALE");
            genders.add("FEMALE");

            ObservableList<String> observableList = FXCollections.observableArrayList(genders);
            cb = new ChoiceBox<>(observableList);

            tfFullName.setText(modifyingNow.getFullName());
//            cb.setSelectionModel();

            dpBirthDate.setValue(LocalDate.parse(modifyingNow.getBirthDate()));
            tfHeight.setText(String.valueOf(modifyingNow.getHeight()));
            tfNationality.setText(modifyingNow.getNationality());

            hBox.getChildren().add(cb);

            Dialog<ButtonType> dialog = new Dialog<ButtonType>();
            dialog.setDialogPane(dialoguePane);
            dialog.showAndWait();

        } else {

            showWarningDialogue("Modify error", "No person is being modified");
        }
    }

    @FXML
    void removePerson(ActionEvent event) {

    }

    @FXML
    void updatePerson(ActionEvent event) {

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
package com.joachimh.pets;

import com.joachimh.pets.entity.Person;
import com.joachimh.pets.entity.PersonController;
import com.joachimh.pets.entity.Pet;
import com.joachimh.pets.entity.PetController;
import com.joachimh.pets.ui.BasicOverviewController;
import com.joachimh.pets.ui.RootLayoutController;
import com.joachimh.pets.util.ErrorHandler;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Joachim on 20.08.2015.
 */
public class MainApp extends Application {
    //region FIELDS
    private Stage primaryStage;
    private FXMLLoader loader;
    private BorderPane rootLayout;

    private PersonController personController = new PersonController();
    private PetController petController = new PetController();
    //endregion

    //region START
    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Pets");

        initRootLayout();
        showBasicOverview();

        ObservableList<Person> personList = FXCollections.observableArrayList();
        ObservableList<Pet> petList = FXCollections.observableArrayList(petController.getPetList());

        personList = personController.getListPerson();

        personList.forEach(person -> {
            System.out.println(person.getFirstname());
            System.out.println("----");
            person.getPets().forEach(pet -> System.out.println(pet.getName()));
        });


    }
    //endregion

    //region initRootLayout
    private void initRootLayout(){
        try {
            loader = new FXMLLoader(MainApp.class.getResource("ui/RootLayout.fxml"));
            rootLayout = (BorderPane)loader.load();

            RootLayoutController ctrl = loader.getController();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            ErrorHandler.showAlertAndExit(Alert.AlertType.ERROR, "Error loading file", "Failed to load File", e.getMessage());
        }
    }
    //endregion

    //region showBasicOverview
    private void showBasicOverview(){
        try {
            loader = new FXMLLoader(MainApp.class.getResource("ui/BasicOverview.fxml"));
            AnchorPane page = (AnchorPane)loader.load();

            BasicOverviewController ctrl = loader.getController();
            rootLayout.setCenter(page);

        } catch (Exception e) {
            ErrorHandler.showAlertAndExit(Alert.AlertType.ERROR, "Error loading file", "Failed to load File", e.getMessage());
        }
    }
    //endregion

    //region MAIN (NOT USED)
    public static void main(String[] args){
        launch(args);
    }
    //endregion

}

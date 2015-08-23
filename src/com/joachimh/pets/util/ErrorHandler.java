package com.joachimh.pets.util;

import javafx.scene.control.Alert;

/**
 * Created by Joachim on 20.08.2015.
 */
public class ErrorHandler {

    private ErrorHandler(){}


    public static void showAlertAndExit(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
        System.exit(1);
    }
}

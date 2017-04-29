package com.rr.alert;

import javafx.scene.control.Alert;

public class AlertBox {

    private static Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
    private static Alert alertWarning = new Alert(Alert.AlertType.WARNING);
    private static Alert alertError = new Alert(Alert.AlertType.ERROR);

    public static void setAlertInfo(String title, String header, String content) {
        alertInfo.setTitle(title);
        alertInfo.setHeaderText(header);
        alertInfo.setContentText(content);
        alertInfo.showAndWait();
    }

    public static void setAlertWarning(String title, String header, String content) {
        alertWarning.setTitle(title);
        alertWarning.setHeaderText(header);
        alertWarning.setContentText(content);
        alertWarning.showAndWait();
    }

    public static void setAlertError(String title, String header, String content) {
        alertError.setTitle(title);
        alertError.setHeaderText(header);
        alertError.setContentText(content);
        alertError.showAndWait();
    }
}

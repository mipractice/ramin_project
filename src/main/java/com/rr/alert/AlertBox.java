package com.rr.alert;

import javafx.scene.control.Alert;

public class AlertBox {

    private static Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
    private static Alert alertWarning = new Alert(Alert.AlertType.WARNING);

    public static void setAlertInfo(String sTitle, String txtHeader, String txtContent){
        alertInfo.setTitle(sTitle);
        alertInfo.setHeaderText(txtHeader);
        alertInfo.setContentText(txtContent);
        alertInfo.showAndWait();
    }

    public static void setAlertWarning(String sTitle, String txtHeader, String txtContent){
        alertWarning.setTitle(sTitle);
        alertWarning.setHeaderText(txtHeader);
        alertWarning.setContentText(txtContent);
        alertWarning.showAndWait();
    }

}

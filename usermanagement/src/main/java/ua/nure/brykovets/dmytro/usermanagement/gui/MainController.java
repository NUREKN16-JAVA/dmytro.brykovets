package ua.nure.brykovets.dmytro.usermanagement.gui;

import com.sun.javafx.runtime.VersionInfo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    Label label;

    public MainController() {
        System.out.println(VersionInfo.getRuntimeVersion());
    }
}

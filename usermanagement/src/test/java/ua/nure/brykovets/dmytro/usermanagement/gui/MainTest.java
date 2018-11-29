package ua.nure.brykovets.dmytro.usermanagement.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import org.junit.After;
import org.junit.Test;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class MainTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    public void shouldContainLabel() {
        verifyThat(".label", hasText("Hello"));
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }
}
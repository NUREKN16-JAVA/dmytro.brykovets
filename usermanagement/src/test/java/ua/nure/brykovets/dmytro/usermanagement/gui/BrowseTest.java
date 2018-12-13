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
import static org.testfx.matcher.base.NodeMatchers.isNotNull;

public class MainAppTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/browse.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    public void shouldContainBrowseControls() {
        verifyThat("#usersTable", isNotNull());
        verifyThat("#addButton", isNotNull());
        verifyThat("#editButton", isNotNull());
        verifyThat("#deleteButton", isNotNull());
        verifyThat("#detailsButton", isNotNull());
    }

    @Test
    public void shouldAddUser() {
        clickOn("#addButton");

        verifyThat("#addUserPane", isNotNull());
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }
}
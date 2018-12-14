package ua.nure.brykovets.dmytro.usermanagement.gui;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import ua.nure.brykovets.dmytro.usermanagement.db.DaoFactory;
import ua.nure.brykovets.dmytro.usermanagement.db.DaoFactoryImpl;
import ua.nure.brykovets.dmytro.usermanagement.db.MockUserDao;
import ua.nure.brykovets.dmytro.usermanagement.util.UTF8Control;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isNotNull;
import static org.testfx.matcher.control.TableViewMatchers.hasNumRows;

public class BrowseTest extends ApplicationTest {

    private static final int COLUMNS_COUNT = 3;

    private ResourceBundle bundle = ResourceBundle.getBundle("strings", Locale.getDefault(), new UTF8Control());

    @Override
    public void start(Stage stage) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("dao.usermanagement.db.UserDao", MockUserDao.class.getName());
        properties.setProperty("dao.factory", DaoFactoryImpl.class.getName());
        DaoFactory.init(properties);

        ResourceBundle bundle = ResourceBundle.getBundle("strings", Locale.getDefault(), new UTF8Control());
        Parent root = FXMLLoader.load(getClass().getResource("/view/browse.fxml"), bundle);
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
    public void shouldContainTableColumns() {
        TableView table = lookup("#usersTable").query();
        ObservableList<TableColumn> columns = table.getColumns();

        assertEquals(COLUMNS_COUNT, columns.size());
        assertEquals(bundle.getString("browse.table.column.id"), columns.get(0).getText());
        assertEquals(bundle.getString("browse.table.column.firstName"), columns.get(1).getText());
        assertEquals(bundle.getString("browse.table.column.lastName"), columns.get(2).getText());
    }

    @Test
    public void shouldAddUser() {
        // given:
        verifyThat("#usersTable", hasNumRows(0));

        // when:
        clickOn("#addButton");
        verifyThat("#addUserPane", isNotNull());
        clickOn("#firstNameField").write("Johnny");
        clickOn("#lastNameField").write("Depp");
        clickOn("#dateOfBirthPicker").write("6/8/1963");
        clickOn("#addButton");

        // than:
        verifyThat("#usersTable", hasNumRows(1));
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }
}
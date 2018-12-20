package ua.nure.brykovets.dmytro.usermanagement.web;

import org.junit.Before;
import org.junit.Test;
import ua.nure.brykovets.dmytro.usermanagement.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BrowseServletTest extends MockServletTestCase {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        createServlet(BrowseServlet.class);
    }

    @Test
    public void browse() {
        User user = new User(1000L, "Quentin", "Tarantino", LocalDate.parse("1963-03-27"));
        List<User> userList = Collections.singletonList(user);
        getMockUserDao().expectAndReturn("findAll", userList);
        doGet();
        Collection<User> userCollection = (Collection<User>) getWebMockObjectFactory().getMockSession().getAttribute("users");

        assertNotEquals("Could not find users in session", Collections.emptyList(), userCollection);
        assertSame(userList, userCollection);
    }
}

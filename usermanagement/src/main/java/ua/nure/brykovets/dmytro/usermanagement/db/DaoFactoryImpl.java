package ua.nure.brykovets.dmytro.usermanagement.db;

public class DaoFactoryImpl extends DaoFactory {

    @Override
    public UserDao getUserDao() {
        try {
            Class userDaoClass = Class.forName(this.properties.getProperty(USER_DAO_CLASS_KEY));

            UserDao userDao = (UserDao) userDaoClass.newInstance();
            userDao.setConnectionFactory(this.getConnectionFactory());

            return userDao;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

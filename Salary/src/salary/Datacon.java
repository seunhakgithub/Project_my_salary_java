package salary;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Datacon {

    /**
     * @return the User
     */
    public static String getUser() {
        return User;
    }

    /**
     * @param aUser the User to set
     */
    public static void setUser(String aUser) {
        User = aUser;
    }

    /**
     * @return the datacon
     */
    public static Connection getDatacon() {
        return datacon;
    }

    /**
     * @param aDatacon the datacon to set
     */
    public static void setDatacon(Connection aDatacon) {
        datacon = aDatacon;
    }
    private static Connection datacon;
private static String User;
    public static void connection(String server, String Db, String User, String Pass) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        setDatacon(DriverManager.getConnection("jdbc:mysql://" + server + "/" + Db, User, Pass));

    }
}

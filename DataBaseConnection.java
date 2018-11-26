package botigaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    public Connection establishConnection() {

        Connection conn = null;
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jc.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://m06b.clkdzvimpab5.eu-west-1.rds.amazonaws.com/llibres?" +
                            "user=admin&password=Memolito76");

            // Do something with the Connection


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
        return conn;
    }

    public void closeConnection() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { } // ignore

            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { } // ignore

            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException sqlEx) { } // ignore

            conn = null;
        }
    }


}

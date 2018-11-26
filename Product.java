package botigaDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Product {

    public void addNewProduct(Connection conn) {

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();


            rs = stmt.executeQuery("SELECT id, titol, autor FROM llibre");


            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            //if (stmt.execute("SELECT llibre FROM llibres")) {
            //    rs = stmt.getResultSet();
            //}

            // Now do something with the ResultSet ....
            while (rs.next()) {
                int id = rs.getInt("id");
                String titol = rs.getString("titol");
                String autor = rs.getString("autor");

                System.out.println("Libro: id " + id + " título " + "\t" + titol +
                        "\t" + "Autor " + "\t" + autor +
                        "\t" );
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Elias-ZZZ
 */
public class SQL {

    private final String driver = "com.mysql.jdbc.Driver";
    private final String database = "bambu-soft";
    private final String hostname = "localhost";
    private final String port = "3306";
    private final String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    private final String username = "root";
    private final String password = "12345678";

    private Connection conectarMySQL() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public boolean verificar(String usuario, String pass) throws Exception{
        Connection conexion=conectarMySQL();
        boolean log=false;
        String sql="SELECT usuario, contraseña FROM empleados WHERE usuario LIKE '"+usuario+"';";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            String p;
            p=rs.getString("contraseña");
            if(p.equals(pass)){
                log=true;
            }
        }
        return log;
    }
    


}

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
import java.util.ArrayList;
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
    private Connection conexion;
    public SQL() {
        conexion = null;
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
    }
    public boolean verificar(String usuario, String pass) throws Exception{
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
    public void cerrarConexion() throws Exception{
        conexion.close();
    }
    ArrayList vendidos, agotandose, agotados;
    public void inicio() throws Exception{
        vendidos=new ArrayList();
        agotandose=new ArrayList();
        agotados=new ArrayList();
        ArrayList fila;
        String sql="SELECT idProducto,imagen FROM productos ORDER BY numVentas DESC";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            fila=new ArrayList();
            fila.add(rs.getString("idProducto"));
            fila.add(rs.getString("imagen"));
            vendidos.add(fila);
        }
        sql="SELECT idProducto,imagen FROM productos WHERE cantidad < 10 ORDER BY cantidad DESC;";
        rs=s.executeQuery(sql);
        while(rs.next()){
            fila=new ArrayList();
            fila.add(rs.getString("idProducto"));
            fila.add(rs.getString("imagen"));
            agotandose.add(fila);
        }
        sql="SELECT idProducto, imagen FROM productos WHERE cantidad=0;";
        rs=s.executeQuery(sql);
        while(rs.next()){
            fila=new ArrayList();
            fila.add(rs.getString("idProducto"));
            fila.add(rs.getString("imagen"));
            agotados.add(fila);
        }
    }
    
    public ArrayList getProductoById(String id)throws Exception{
        ArrayList producto=new ArrayList();
        String sql="SELECT * FROM productos WHERE idProducto="+id+";";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            producto.add(rs.getString("imagen"));
            producto.add(rs.getString("articulo"));
            producto.add(rs.getString("codigo_de_barras"));
            producto.add(rs.getString("precio"));
            producto.add(rs.getString("cantidad"));
            producto.add(rs.getString("numVentas"));
        }
        return producto;
    }
    public ArrayList getVendidos(){
        return vendidos;
    }
    public ArrayList getAgotandose(){
        return agotandose;
    }
    public ArrayList getAgotados(){
        return agotados;
    }
    


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    public String getAdministrador(String usuario)throws Exception{
        String admin="No";
        String sql="SELECT administrador FROM empleados WHERE usuario LIKE '"+usuario+"';";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            admin=rs.getString("administrador");
        }
        return admin;
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
        sql="SELECT idProducto,imagen FROM productos WHERE cantidad < 10 AND cantidad > 0 ORDER BY cantidad DESC;";
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
    public ArrayList busquedaInventario(String q)throws Exception{
        ArrayList productos=new ArrayList();
        Object[] fila;
        String sql="SELECT * FROM productos WHERE articulo LIKE '%"+q+"%' OR codigo_de_barras LIKE '%"+q+"%'";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            fila=new Object[]{
                //rs.getString("idProducto"),
                rs.getString("codigo_de_barras"),
                rs.getString("articulo"),
                rs.getString("precio"),
                rs.getString("cantidad"),
                rs.getString("numVentas")
                //fila.add(rs.getString("imagen"));
            };
            productos.add(fila);
        }
        return productos;
    }
    
    public ArrayList getAllProductos() throws Exception{
        ArrayList productos=new ArrayList();
        Object[] fila;
        String sql="SELECT * FROM productos;";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            fila=new Object[]{
                //rs.getString("idProducto"),
                rs.getString("codigo_de_barras"),
                rs.getString("articulo"),
                rs.getString("precio"),
                rs.getString("cantidad"),
                rs.getString("numVentas")
                //fila.add(rs.getString("imagen"));
            };
            productos.add(fila);
        }
        return productos;
    }
    
    public ArrayList getProductoByCodeBar(String codeBar, String articulo)throws Exception{
        ArrayList producto=new ArrayList();
        String sql="SELECT * FROM productos WHERE codigo_de_barras='"+codeBar+"' AND articulo='"+articulo+"';";
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
    
    public void insertArticulo(ArrayList datos)throws Exception{
        String sql="INSERT INTO productos (idProducto,articulo,codigo_de_barras,precio,cantidad,numVentas,imagen) VALUES (null,?,?,?,?,?,?);";
        PreparedStatement s=conexion.prepareStatement(sql);
        for(int i=0;i<datos.size();i++){
            s.setString(i+1,datos.get(i).toString());
        }
        s.executeUpdate();
    }
    public void borrarArticulo(String codeBar, String articulo)throws Exception{
        String sql="DELETE FROM productos WHERE codigo_de_barras=? AND articulo=?;";
        PreparedStatement s=conexion.prepareStatement(sql);
        s.setString(1,codeBar);
        s.setString(2,articulo);
        s.executeUpdate();
    }
   
    
    public void ActualizarRegistroInventario(String codeBar, String articulo, ArrayList datos)throws Exception{
        String sql="UPDATE productos SET articulo=?,codigo_de_barras=?,precio=?"
                + ",cantidad=?,numVentas=?,imagen=? WHERE articulo='"+articulo+"' AND codigo_de_barras='"+codeBar+"';";
        PreparedStatement s=conexion.prepareStatement(sql);
        for(int i=0;i<datos.size();i++){
            s.setString(i+1,datos.get(i).toString());
        }
        s.executeUpdate();
    }
    public ArrayList getAllEmpleados()throws Exception{
         ArrayList productos=new ArrayList();
        Object[] fila;
        String sql="SELECT * FROM empleados;";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            fila=new Object[]{
                rs.getString("idEmpleado"),
                rs.getString("nombre"),
                rs.getString("usuario"),
                rs.getString("contraseña"),
                rs.getString("administrador"),
                rs.getString("telefono")
            };
            productos.add(fila);
        }
        return productos;
    }
    public ArrayList getEmpleadoById(String id){
        ArrayList empleado=new ArrayList();
        String sql="SELECT * FROM empleados WHERE idEmpleado='"+id+"';";
        return empleado;
    }

}

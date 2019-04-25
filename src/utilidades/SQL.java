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
    
    public boolean insertArticulo(ArrayList datos)throws Exception{
        boolean correcto=true;
        String sql="INSERT INTO productos (idProducto,articulo,codigo_de_barras,precio,cantidad,numVentas,imagen) VALUES (null,?,?,?,?,?,?);";
        correcto=verificarBarCode(datos.get(1).toString());
        if(correcto){
            PreparedStatement s=conexion.prepareStatement(sql);
            for(int i=0;i<datos.size();i++){
                s.setString(i+1,datos.get(i).toString());
            }
            s.executeUpdate();
        }
        return correcto;
    }
    
    public boolean verificarBarCode(String barCode)throws Exception{
        boolean correcto=true;
        String sql="SELECT codigo_de_barras FROM producto;";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            if(barCode.equals(rs.getString("codigo_de_barras"))){
                correcto=false;
                break;
            }
        }
        return correcto;
    }
    
    public void borrarArticulo(String codeBar, String articulo)throws Exception{
        String sql="DELETE FROM ventaproductos WHERE idProducto=(SELECT idProducto FROM productos WHERE codigo_de_barras=? AND articulo=?);";
        PreparedStatement s=conexion.prepareStatement(sql);
        s.setString(1,codeBar);
        s.setString(2,articulo);
        s.executeUpdate();
        sql="DELETE FROM productos WHERE codigo_de_barras=? AND articulo=?;";
        s=conexion.prepareStatement(sql);
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
   
    public ArrayList getEmpleadoById(String id)throws Exception{
        ArrayList empleado=new ArrayList();
        String sql="SELECT * FROM empleados WHERE idEmpleado='"+id+"';";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            empleado.add(rs.getString("nombre"));
            empleado.add(rs.getString("usuario"));
            empleado.add(rs.getString("contraseña"));
            empleado.add(rs.getString("administrador"));
            empleado.add(rs.getString("telefono"));
        }
        return empleado;
    }
    
    public boolean insertarEmpleado(ArrayList empleado)throws Exception{
        boolean error=false;
        error=verificarUsuario(empleado.get(1).toString());
        if(!error){
            String sql="INSERT INTO empleados (idEmpleado,nombre,usuario,contraseña,administrador,telefono) VALUES (null,?,?,?,?,?);";
            PreparedStatement s=conexion.prepareStatement(sql);
            for(int i=0;i<empleado.size();i++){
                s.setString(i+1,empleado.get(i).toString());
            }
            s.executeUpdate();
        }
        return error;
    }
    
    private boolean verificarUsuario(String empleado)throws Exception{
        boolean error=false;
        String verificar="SELECT usuario FROM empleados";
        Statement st=conexion.createStatement();
        ResultSet rs=st.executeQuery(verificar);
        while(rs.next()){
            if(empleado.equals(rs.getString("usuario"))){
                error=true;
                break;
            }
        }
        return error;
    }
    
    public boolean borrarEmpleado(String usuario){
        boolean correcto=true;
        String sql="DELETE FROM empleados WHERE usuario=?;";
        try{
            PreparedStatement s=conexion.prepareStatement(sql);
            s.setString(1, usuario);
            s.executeUpdate();
        }catch(Exception e){
            correcto=false;
        }
        return correcto;
    }
    public boolean actualizarEmpleado(ArrayList empleado,String id){
        boolean correcto=true;
        String sql="UPDATE empleados SET nombre=?,usuario=?,contraseña=?,administrador=?,telefono=? WHERE idEmpleado="+id+";";
        String verificar="SELECT idEmpleado FROM empleados WHERE usuario='"+empleado.get(1).toString()+"';";
        try{
            Statement st=conexion.createStatement();
            ResultSet rs=st.executeQuery(verificar);
            if(verificarUsuario(empleado.get(1).toString())){
                while(rs.next()){
                    if(rs.getString("idEmpleado").equals(id)){
                        //inserta
                        PreparedStatement s=conexion.prepareStatement(sql);
                        for(int i=0;i<empleado.size();i++){
                            s.setString(i+1,empleado.get(i).toString());
                        }
                        s.executeUpdate();
                    }
                    else{
                        //no inserta
                        correcto=false;
                    }
                }
            }
            else{
                //inserta
                PreparedStatement s=conexion.prepareStatement(sql);
                for(int i=0;i<empleado.size();i++){
                    s.setString(i+1,empleado.get(i).toString());
                }
                s.executeUpdate();
            }
        }
        catch(Exception e){correcto=false;}
        return correcto;
    }
    
    public ArrayList getProductoByCodeBar2(String barCode)throws Exception{
        ArrayList datos=new ArrayList();
        String sql="SELECT articulo,precio,codigo_de_barras FROM productos where codigo_de_barras='"+barCode+"';";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            datos.add(rs.getString("articulo"));
            datos.add(rs.getString("precio"));
        }
        return datos;
    }
    
    public boolean comprobarProducto(ArrayList articulos)throws Exception{
        boolean correcto=true;
        for(int i=0;i<articulos.size();i++){
            String sql="SELECT cantidad FROM productos WHERE codigo_de_barras='"+
                    ((Object[])articulos.get(i))[0].toString()+"'";
            Statement s=conexion.createStatement();
            ResultSet rs=s.executeQuery(sql);
            int cantidadBD=0;
            while(rs.next()){
                cantidadBD=Integer.parseInt(rs.getString("cantidad"));
            }
            int cantidadEx=Integer.parseInt(((Object[])articulos.get(i))[1].toString());
            if(cantidadEx>cantidadBD){
                correcto=false;
            }
        }
        return correcto;
    }
    
    public boolean insertarVenta(ArrayList venta, String empleado,ArrayList articulos)throws Exception{
        boolean error=false;
        if(comprobarProducto(articulos)){
            String sqlEmpleado="SELECT idEmpleado FROM empleados WHERE usuario='"+empleado+"';";
            String sql="INSERT INTO ventas VALUES (null,?,?,?,CURDATE());";
            Statement st=conexion.createStatement();
            ResultSet rs=st.executeQuery(sqlEmpleado);
            String idEmpleado="";
            while(rs.next()){
                idEmpleado=rs.getString("idEmpleado");
            }
            PreparedStatement s=conexion.prepareStatement(sql);
            s.setString(1,idEmpleado);
            s.setString(2,venta.get(0).toString());
            s.setString(3,venta.get(1).toString());
            s.executeUpdate();
            insertarProductoVenta(articulos);
        }
        else{error=true;}


            
        return error;
    }
    private void insertarProductoVenta(ArrayList articulos)throws Exception{
        String sql="SELECT idVenta FROM ventas ORDER BY idVenta DESC LIMIT 1";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        String idVenta="";
        while(rs.next()){
            idVenta=rs.getString("idVenta");
        }
        
        
        ArrayList idProductos=new ArrayList();
        for(int i=0;i<articulos.size();i++){
            rs=null;
            String objeto=((Object[])articulos.get(i))[0].toString();
            String cantidad=((Object[])articulos.get(i))[1].toString();
            sql="SELECT idProducto FROM productos WHERE codigo_de_barras='"+objeto+"'";
            rs=s.executeQuery(sql);
            while(rs.next()){
                idProductos.add(rs.getString("idProducto"));
                String sql2="UPDATE productos SET cantidad=cantidad-"+cantidad+",numVentas=numVentas+"+cantidad+""
                        + " WHERE idProducto='"+rs.getString("idProducto")+"';";
                Statement st=conexion.createStatement();
                st.executeUpdate(sql2);
            }
        }
        sql="INSERT INTO ventaproductos VALUES (null,?,?,?);";
        PreparedStatement ps=conexion.prepareStatement(sql);
        ps.setString(1,idVenta);
        for(int i=0;i<articulos.size();i++){
            ps.setString(2,idProductos.get(i).toString());
            ps.setString(3,((Object[])articulos.get(i))[1].toString());
            ps.executeUpdate();
        }
    } 
    
    public ArrayList getAllVentas(int opcion)throws Exception{
        String sql="SELECT ventas.idVenta,empleados.usuario,ventas.monto,ventas.tipoVenta,ventas.fecha FROM ventas " +
                    "INNER JOIN empleados ON ventas.idVendedor=empleados.idEmpleado";
        if(opcion==0){
            sql+=" ORDER BY idVenta DESC;";
        }
        else{
            if(opcion==1){
                sql+=" WHERE tipoVenta LIKE 'Efectivo' ORDER BY idVenta DESC;";
            }
            else{
                if(opcion==2){
                    sql+=" WHERE tipoVenta LIKE 'Tarjeta' ORDER BY idVenta DESC;";
                }
            }
        }
        ArrayList ventas=new ArrayList();
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            Object[] fila=new Object[]{
                rs.getString("idVenta"),
                rs.getString("usuario"),
                rs.getString("monto"), 
                rs.getString("tipoVenta"),
                rs.getString("fecha")
            };
            ventas.add(fila);
        }
        return ventas;
    }
    public ArrayList buscarVentas(String[] busqueda,int opcion)throws Exception{
        String sql="SELECT ventas.idVenta,empleados.usuario,ventas.monto,ventas.tipoVenta,ventas.fecha FROM ventas " +
                "INNER JOIN empleados ON ventas.idVendedor=empleados.idEmpleado";
        if(busqueda[0].equals("")){
            if(busqueda[2].equals("n")){
                sql+=" WHERE usuario LIKE '"+busqueda[1]+"' OR monto="+busqueda[1];
            }
            else{
                if(busqueda[2].equals("f")){
                    sql+=" WHERE usuario LIKE '"+busqueda[1]+"' OR fecha='"+busqueda[1]+"'";
                }
                else{
                    sql+=" WHERE usuario LIKE '"+busqueda[1]+"'";
                }
            }
        }
        if(busqueda[0].equals(">")){
            if(busqueda[2].equals("n")){
                sql+=" WHERE usuario LIKE '"+busqueda[1]+"' OR monto>"+busqueda[1];
            }
            else{
                if(busqueda[2].equals("f")){
                    sql+=" WHERE usuario LIKE '"+busqueda[1]+"' OR fecha>'"+busqueda[1]+"'";
                }
                else{
                    sql+=" WHERE usuario LIKE '"+busqueda[1]+"'";
                }
            }
                        
        }
        if(busqueda[0].equals("<")){
            if(busqueda[2].equals("n")){
                sql+=" WHERE usuario LIKE '"+busqueda[1]+"' OR monto<"+busqueda[1];
            }
            else{
                if(busqueda[2].equals("f")){
                    sql+=" WHERE usuario LIKE '"+busqueda[1]+"' OR fecha<'"+busqueda[1]+"'";
                }
                else{
                    sql+=" WHERE usuario LIKE '"+busqueda[1]+"'";
                }
            }
        }
        if(busqueda[0].equals("=")){
            if(busqueda[2].equals("n")){
                sql+=" WHERE usuario LIKE '"+busqueda[1]+"' OR monto="+busqueda[1];
            }
            else{
                if(busqueda[2].equals("f")){
                    sql+=" WHERE usuario LIKE '"+busqueda[1]+"' OR fecha='"+busqueda[1]+"'";
                }
                else{
                    sql+=" WHERE usuario LIKE '"+busqueda[1]+"'";
                }
            }
        }
        if(opcion==0){
            sql+=" ORDER BY idVenta DESC;";
        }
        else{
            if(opcion==1){
                sql+=" AND tipoVenta LIKE 'Efectivo' ORDER BY idVenta DESC;";
            }
            else{
                if(opcion==2){
                    sql+=" AND tipoVenta LIKE 'Tarjeta' ORDER BY idVenta DESC;";
                }
            }
        }
        
        ArrayList ventas=new ArrayList();
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            Object[] fila=new Object[]{
                rs.getString("idVenta"),
                rs.getString("usuario"),
                rs.getString("monto"), 
                rs.getString("tipoVenta"),
                rs.getString("fecha")
            };
            ventas.add(fila);
        }
        return ventas;
    }
    
    public double getVentasDia(){
        double total=0;
        String sql="SELECT SUM(monto) AS total FROM ventas WHERE fecha=CURDATE()";
        try{
            Statement s=conexion.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                total=Double.parseDouble(rs.getString("total"));
            }
        }catch(NullPointerException e){total=0;}
        catch(SQLException ex){ex.printStackTrace();}
        return total;
    }
    
    public double getVentasSemana(){
        double total=0;
        String sql="SELECT SUM(monto) AS total FROM ventas WHERE YEARWEEK(fecha)=YEARWEEK(CURDATE())";
        try{
            Statement s=conexion.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                total=Double.parseDouble(rs.getString("total"));
            }
        }catch(NullPointerException e){total=0;}
        catch(SQLException ex){ex.printStackTrace();}
        return total;
    }
    
    public double getVentasMes(){
        double total=0;
        String sql="SELECT SUM(monto) AS total FROM ventas WHERE YEAR(fecha)=YEAR(CURDATE()) AND MONTH(fecha)=MONTH(CURDATE())";
        try{
            Statement s=conexion.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                total=Double.parseDouble(rs.getString("total"));
            }
        }catch(NullPointerException e){total=0;}
        catch(SQLException ex){ex.printStackTrace();}
        return total;
    }
    
    public ArrayList getVentaProductos(String idVenta)throws Exception{
        ArrayList productos=new ArrayList();
        String sql="SELECT productos.codigo_de_barras,productos.articulo,ventaproductos.cantidad FROM productos"
                +" INNER JOIN ventaproductos ON ventaproductos.idProducto=productos.idProducto"
                + " WHERE ventaproductos.idVenta="+idVenta+";";
        Statement s=conexion.createStatement();
        ResultSet rs=s.executeQuery(sql);
        while(rs.next()){
            Object[] fila=new Object[]{
                rs.getString("codigo_de_barras"),
                rs.getString("articulo"),
                rs.getString("cantidad")
            };
            productos.add(fila);
        }
        return productos;
    }
}

package SQL;

import java.sql.*;
import java.util.Scanner;

public class Conexion {

    public static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

      datosPropietario();
        
    }

    public static void datosPropietario() {
        Connection connection = null;
        final String url = "jdbc:mysql://localhost:3306/final_proyect";
        final String user = "root";
        final String pass = "root";
        try {
            connection = DriverManager.getConnection(url, user, pass);
            // Let the user input the data to be inserted through the console 
            System.out.println(" Poravor introduce nombre propietario ：");
            String nombrePro = entrada.next();
            System.out.println(" Poravor introduce apellido propietario ：");
            String apellidoPro = entrada.next();
            System.out.println(" Poravor introduce teléfono propietario ：");
            int numeroPro = entrada.nextInt();
            // Operating the database , Take inserting a database as an example 
            // Construct a SQL sentence 
            String sql = "insert into propietario values(null,?,?,?)";
            // Creamos el statement
            PreparedStatement statement = connection.prepareStatement(sql);
            // Carry out replacement operations 
            statement.setString(1, nombrePro);// Replace the first question mark with id Value 
            statement.setString(2, apellidoPro);// Put the second one ？ Replace with name Value 
            statement.setInt(3, numeroPro);
            //4. perform sql
            // It's equivalent to how many lines in the console are affected 
            int ret = statement.executeUpdate();
            System.out.println(ret);

            // Es equivalente a realizar un SELECT * FROM usuarios; ya que ya estamos situados en la BBDD
            ResultSet result = statement.executeQuery("SELECT * FROM propietario");
            // Mostrando el resultado
            ResultSetMetaData rsmd = result.getMetaData();
            int columnCount = rsmd.getColumnCount();
            // Recorriendo los nombres de los encabezados de la tabla
            for (int i = 1; i < columnCount; i++) {
                System.out.printf("%10s", rsmd.getColumnName(i));
            }
            int spacing = ((columnCount * 10) - 5);
            String textoFormateado = String.format("%n%" + spacing + "s", " ", " ").replace(' ', '-');
            System.out.println(textoFormateado);
            // Mostrando el resultado
               result.next();
                int id = result.getInt("id");
                String nombre = result.getString("Nombre");
                String apellido = result.getString("Apellido");
                String telefono = result.getString("Telefono");
                System.out.printf("%10d%10s%10s%10dn", id, nombrePro, apellidoPro, numeroPro);
        

            result.close(); // Cerrando resultset
            statement.close(); // Cerrando statement
            connection.close(); // Cerrando connection
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void datosBar() {
        final String url = "jdbc:mysql://localhost:3306/final_proyect";
        final String user = "root";
        final String pass = "root";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, pass);
            // Let the user input the data to be inserted through the console 
            System.out.println(" Poravor introduce nombre del establecimiento ：");
            String nombreBar = entrada.next();
            System.out.println(" Porfavor introduce teléfono del establecimiento : ");
            int telefonoBar = entrada.nextInt();
            System.out.println(" Poravor introduce dirección del establecimiento ：");
            String direccion = entrada.next();
            System.out.println(" Poravor introduce la categoría del precio del establecimiento($,$$,$$$) ：");
            String catPrecio = entrada.next();
            System.out.println(" Porfavor introduce el área del establecimiento : ");
            String area = entrada.next();
            System.out.println(" Porfavor introduce la categoría del establecimiento : ");
            String categoria = entrada.next();
            System.out.println(" Porfavor introduce la descripción del establecimiento(500 caracteres máx) : ");
            String descripcion = entrada.next();
            System.out.println(" Porfavor introduce las especialidades del establecimiento : ");
            String especialidades = entrada.next();
            System.out.println(" Porfavor introduce las promociones del establecimiento : ");
            String promociones = entrada.next();
            System.out.println(" Porfavor introduce las Redes Sociales del establecimiento : ");
             String redSocial = entrada.next();
              System.out.println(" Porfavor introduce tu id de propietario : ");
             int id_propietario = entrada.nextInt();
            // Operating the database , Take inserting a database as an example 
            // Construct a SQL sentence 
            String sql = "insert into bar values(null,?,?,?,?,?,?,?,?,?,?,?)";
            // Creamos el statement
            PreparedStatement statement = connection.prepareStatement(sql);
            // Carry out replacement operations 
            statement.setString(1, nombreBar);// Replace the first question mark with id Value 
            statement.setInt(2, telefonoBar);// Put the second one ？ Replace with name Value 
            statement.setString(3, direccion);
            statement.setString(4, catPrecio);
            statement.setString(5, area);
            statement.setString(6, categoria);
            statement.setString(7, descripcion);
            statement.setString(8, especialidades);
            statement.setString(9, promociones);
            statement.setString(10, redSocial);
            statement.setInt(11, id_propietario);
            //4. perform sql
            // It's equivalent to how many lines in the console are affected 
       int ret = statement.executeUpdate();
            System.out.println(ret);

            // Es equivalente a realizar un SELECT * FROM usuarios; ya que ya estamos situados en la BBDD
            ResultSet result = statement.executeQuery("SELECT * FROM bar");
            // Mostrando el resultado
            ResultSetMetaData rsmd = result.getMetaData();
            int columnCount = rsmd.getColumnCount();
            // Recorriendo los nombres de los encabezados de la tabla
            for (int i = 1; i < columnCount; i++) {
                System.out.printf("%20s", rsmd.getColumnName(i));
            }
            int spacing = ((columnCount * 20) - 5);
            String textoFormateado = String.format("%n%" + spacing + "s", " "," ").replace(' ', '-');
            System.out.println(textoFormateado);
            // Mostrando el resultado
            while (result.next()) {
                int id = result.getInt("id_Bar");
                result.getString("Nombre");
                result.getInt("telefono");
                result.getString("direccion");
                result.getString("catPrecio");
                result.getString("area");
                result.getString("categoria");
                result.getString("descripcion");
                result.getString("especialidades");
                result.getString("promociones");
                result.getString("redesSociales");
                result.getString("id_Propietario_Propietario");
                System.out.printf("%20d%20s%20s%20s%20s%20s%20s%20s%20s%20s%20s", id, nombreBar, telefonoBar, direccion,catPrecio,area,categoria,descripcion,especialidades,promociones,redSocial,id_propietario);
            }

            result.close(); // Cerrando resultset
            statement.close(); // Cerrando statement
            connection.close(); // Cerrando connection
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

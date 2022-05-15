package SQL;

import java.sql.*;
import java.util.Scanner;

public class Conexion {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Connection connection = null;
        final String url = "jdbc:mysql://localhost:3306/final_proyect";
        final String user = "root";
        final String pass = "root";

        try {
            connection = DriverManager.getConnection(url, user, pass);
            // Let the user input the data to be inserted through the console 
            System.out.println(" Poravor introduce tu nombre ：");
            String apellido = entrada.next();
            System.out.println(" Poravor introduce tu apellido ：");
            String name = entrada.next();
            System.out.println(" Poravor introduce tu teléfono ：");
            int numerom = entrada.nextInt();
            // Operating the database , Take inserting a database as an example 
            // Construct a SQL sentence 
            String sql = "insert into propietario values(null,?,?,?)";
            // Creamos el statement
            PreparedStatement statement = connection.prepareStatement(sql);
            // Carry out replacement operations 
            statement.setString(1, name);// Replace the first question mark with id Value 
            statement.setString(2, apellido);// Put the second one ？ Replace with name Value 
            statement.setInt(3, numerom);

            
            
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
            while (result.next()) {
                int id = result.getInt("id");
                String nombre = result.getString("Nombre");
                result.getString("Apellido");
                System.out.printf("%10d%10s%10s%n", id, nombre, apellido);
            }
            result.close(); // Cerrando resultset
            statement.close(); // Cerrando statement
            connection.close(); // Cerrando connection
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

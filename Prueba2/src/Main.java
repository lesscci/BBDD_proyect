
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection connection;
        final String url = "jdbc:mysql://localhost:3306/db_test";
        final String user = "root";
        final String pass = "root";

        try {
            connection = DriverManager.getConnection(url, user, pass);
            // Creamos el statement
            Statement statement = connection.createStatement();
            // Es equivalente a realizar un SELECT * FROM usuarios; ya que ya estamos situados en la BBDD
            ResultSet result = statement.executeQuery("SELECT * FROM db_test.usuarios");
            // Mostrando el resultado
            ResultSetMetaData rsmd = result.getMetaData();
            int columnCount = rsmd.getColumnCount();
            // Recorriendo los nombres de los encabezados de la tabla
            for (int i = 1; i < columnCount; i++) {
                System.out.printf("%10s", rsmd.getColumnName(i).toString());
            }
            int spacing = ((columnCount * 10) - 5);
            String textoFormateado = String.format("%n%" + spacing + "s", " ", " ").replace(' ', '-');
            System.out.println(textoFormateado);
            // Mostrando el resultado
            while (result.next()) {
                int id_usuarios = result.getInt("id_usuarios");
                String nombre = result.getString("Nombre");
                int edad = result.getInt("Edad");
                System.out.printf("%10d%10s%10d%n", id_usuarios, nombre, edad);
            }
            result.close(); // Cerrando resultset
            statement.close(); // Cerrando statement
            connection.close(); // Cerrando connection
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

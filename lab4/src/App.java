import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

    public static void main(String[] args) throws Exception {
// achei H2 inifinitamente mais fácil que postgresql, etc... 
        String url = "jdbc:h2:./database";
        String user = "sa";
        String password = "";

        Connection con = DriverManager.getConnection(url, user, password);

        Statement stmt = con.createStatement();

        stmt.execute("CREATE TABLE IF NOT EXISTS cliente (" +
                     "id INT AUTO_INCREMENT PRIMARY KEY," +
                     "nome VARCHAR(100)," +
                     "email VARCHAR(100))");
        System.out.println("Tabela pronta....");

        
        stmt.executeUpdate("INSERT INTO cliente(nome,email) VALUES('Larinha','lala@gmail.com.brr')");
        


        ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
        System.out.println("\nClientes cadastrados:");

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");

            System.out.println(id + " - " + nome + " - " + email);
        }

        
        stmt.executeUpdate("UPDATE cliente SET nome='Larinha Siqueira' WHERE id=1");
     
        stmt.executeUpdate("DELETE FROM cliente WHERE id=1");

        con.close();
    }
}

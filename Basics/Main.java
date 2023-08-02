import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String DB_URL = "jdbc:mysql://localhost:3306/admin_system";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) throws Exception{
        // Open a connection
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
//        getQuery(connection);
//        insertQuery(connection);
//        insertQueryWithValue(connection);
        getByID(connection);
    }

    public static void getQuery(Connection connection) throws SQLException {

        String QUERY = "SELECT id, username FROM Persons";

        // Create statement for select query
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(QUERY);

        while (rs.next()){
            System.out.println("ID : " + rs.getInt("id") + " Name : " + rs.getString("username"));
        }
    }

    public static void insertQuery(Connection connection) throws SQLException {

        String QUERY = "insert into Persons(username,email) values ('Thalha', 'thalha@gmail.com')";

        // Create statement for select query
        Statement statement = connection.createStatement();
        int rs = statement.executeUpdate(QUERY);

        System.out.println("ROW Updated at " + rs);
    }

    public static void insertQueryWithValue(Connection connection) throws SQLException {

        String QUERY = "insert into Persons(username,email) values (?,?)";

        // Create statement for select query
        PreparedStatement pst = connection.prepareStatement(QUERY);
        pst.setString(1,"Gekko");
        pst.setString(2,"gekko@gmail.com");
        int rs = pst.executeUpdate();

        System.out.println("ROW Updated at " + rs);
    }

    public static void getByID(Connection connection) throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID : ");
        int id = sc.nextInt();
        String QUERY = "SELECT id, username FROM Persons where id = " + id;

        // Create statement for select query
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(QUERY);

        while (rs.next()){
            System.out.println("ID : " + rs.getInt("id") + " Name : " + rs.getString("username"));
        }
    }
}
package lab8.compulsory;

import java.sql.*;

public class Database {
    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "freaks";
    private static final String PASSWORD = "freaks";
    private static Connection connection = null;

    private Database() {
    }

    private static void createConnection() {
    	try {
    		connection = DriverManager.getConnection(URL,USER,PASSWORD);
    		connection.setAutoCommit(false);
    	} catch (SQLException e) {
    		System.err.println(e);
    	}
    }
    
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return  connection;
    }


    public static void initTables() throws SQLException {
    	createConnection();
    	try (PreparedStatement genreStmt = connection.prepareStatement(
                "CREATE TABLE genres(ID Integer, NAME VARCHAR2(20), CONSTRAINT genres_pk PRIMARY KEY(ID))")) {
            genreStmt.executeUpdate();
            PreparedStatement artistStmt = connection.prepareStatement("CREATE TABLE artists(ID Integer, NAME VARCHAR2(20), CONSTRAINT artists_pk PRIMARY KEY(ID))");
            artistStmt.executeUpdate();
            PreparedStatement albumStmt = connection.prepareStatement("CREATE TABLE albums(ID INTEGER, RELEASE_YEAR INTEGER, TITLE VARCHAR2(20), ARTIST VARCHAR(20), CONSTRAINT albums_pk PRIMARY KEY(ID))");
            albumStmt.executeUpdate();
            PreparedStatement albumGenres = connection.prepareStatement("CREATE TABLE albumgenres(ID_ALBUM INTEGER, ID_GENRE INTEGER)");
            albumGenres.executeUpdate();
        }
    }
    
    public static void closeConnection() throws SQLException {
    	connection.close();
    }
}
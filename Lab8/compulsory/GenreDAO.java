package lab8.compulsory;

import java.sql.*;

public class GenreDAO {
    public void create(int id,String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (id, name) values (?,?)")) {
            pstmt.setInt(1,id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
}

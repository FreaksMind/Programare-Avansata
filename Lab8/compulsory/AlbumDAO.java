package lab8.compulsory;

import java.sql.*;

public class AlbumDAO {
    public void create(int id, int release_year, String title, String artist) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (id, release_year, title, artist) values (?,?,?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, release_year);
            pstmt.setString(3, title);
            pstmt.setString(4, artist);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String title) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + title + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public void printAlbums() throws SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select title, release_year, artist  from albums");
        ResultSetMetaData rsmd = rs.getMetaData();

        int columnsNumber = rsmd.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print(rs.getString(i) + " ");
            }
            System.out.println();
        }
    }
}

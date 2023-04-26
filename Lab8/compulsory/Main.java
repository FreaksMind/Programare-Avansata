package lab8.compulsory;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
        	Database.initTables();
            var artists = new ArtistDAO();
            artists.create(1, "Pink Floyd");
            artists.create(2, "Michael Jackson");

            var genres = new GenreDAO();
            genres.create(1, "Rock");
            genres.create(2, "Funk");
            genres.create(3, "Soul");
            genres.create(4, "Pop");

            Database.getConnection().commit();

            var albums = new AlbumDAO();
            albums.create(1, 1979, "The Wall", "Pink Floyd");
            albums.create(2, 1982, "Thriller", "Michael Jackson");
            System.out.println(albums.findByName("The Wall"));

            Database.getConnection().commit();


            albums.printAlbums();

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.getConnection().rollback();
        }
    }
}

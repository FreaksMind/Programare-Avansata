package lab5;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import lab5.exceptions.InvalidCatalogException;

public class CatalogManager {

	public static void save(Catalog catalog, String path) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(path), catalog);
	}

	public static Catalog load(String path) throws InvalidCatalogException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
		return catalog;
	}

	public static String toString(Catalog catalog) {
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (Document d : catalog.getDocs()) {
			sb.append(counter).append(". ").append(d.getTitle()).append("\n");
		}
		return sb.toString();
	}
}

package lab5;

import java.io.IOException;

import lab5.exceptions.InvalidCatalogException;

public class Main {
	public static void main(String args[]) throws InvalidCatalogException, IOException {
		Main app = new Main();
		app.testCreateSave();
	}

	private void testCreateSave() throws IOException {
		Catalog catalog = new Catalog("MyDocuments");
		var book = new Document("article1", "Romania", "C:\\Users\\freaks\\Desktop\\C2.png") {
		};
		var article = new Document("book1", "Paris", "C:\\Users\\freaks\\Desktop\\C2.png") {
		};
		catalog.add(book);
		catalog.add(article);
		CatalogManager.save(catalog, "C:\\Users\\freaks\\facultate\\cf\\catalog.json");
		System.out.println(CatalogManager.toString(catalog));
	}

}
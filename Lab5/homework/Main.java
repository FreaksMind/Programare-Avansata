package lab5.homework;

import java.io.IOException;

import lab5.homework.command.AddCommand;
import lab5.homework.command.ListCommand;
import lab5.homework.command.LoadCommand;
import lab5.homework.command.ReportCommand;
import lab5.homework.command.SaveCommand;
import lab5.homework.command.ViewCommand;
import lab5.homework.exceptions.DocumentExistsException;
import lab5.homework.exceptions.InvalidCatalogException;

public class Main {
	public static void main(String args[]) throws InvalidCatalogException, IOException {
		Main app = new Main();
		app.testCreateSave();
	}

	private void testCreateSave() throws IOException {
		Catalog catalog = new Catalog("MyDocuments");
		var book = new Document("article1", "Romania", "catalog.json") {
		};
		var article = new Document("book1", "Paris", "www.google.com") {
		};
		var zarticle = new Document("bookgfdgdf1", "hfghParis", "www.google.com") {
		};
		book.addTag("author", "marcel");
		book.addTag("Release date", "vineri");
		try {
			new AddCommand(catalog, book).run();
			new AddCommand(catalog, article).run();
			//new AddCommand(catalog, zarticle).run();
			//new AddCommand(catalog, article).run();
		} catch (DocumentExistsException e) {
			e.printStackTrace();
		}
		new SaveCommand(catalog, "catalog.json").run();
		new ListCommand(catalog).run();
		new ReportCommand(catalog).run();
		new ViewCommand(book).run();
//		
//		Catalog c = new Catalog("sa");
//		LoadCommand l = new LoadCommand(c, "catalog.json");
//		l.run();
//		c = l.getCatalog();
//		new ListCommand(c).run();
	}

}
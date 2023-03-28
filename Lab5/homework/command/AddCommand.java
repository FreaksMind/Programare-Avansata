package lab5.homework.command;

import lab5.homework.Catalog;
import lab5.homework.Document;
import lab5.homework.exceptions.DocumentExistsException;

public class AddCommand implements ICommand {

	private Catalog catalog;
	private Document document;

	public AddCommand(Catalog catalog, Document document) {
		this.catalog = catalog;
		this.document = document;

	}

	@Override
	public void run() throws DocumentExistsException {
		if (catalog.findById(document.getId()) == null) {
			catalog.getDocs().add(document);
		} else {
			throw new DocumentExistsException(document.getId());
		}

	}

}

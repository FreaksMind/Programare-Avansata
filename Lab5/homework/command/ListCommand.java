package lab5.homework.command;

import lab5.homework.Catalog;
import lab5.homework.Document;

public class ListCommand implements ICommand {

	private Catalog catalog;

	public ListCommand(Catalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public void run() {
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (Document d : catalog.getDocs()) {
			sb.append(counter).append(". ").append(d.getTitle()).append("\n");
			counter++;
		}
		System.out.println(sb.toString());
	}

}

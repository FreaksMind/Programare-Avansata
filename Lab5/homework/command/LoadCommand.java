package lab5.homework.command;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lab5.homework.Catalog;

public class LoadCommand implements ICommand {

	private Catalog catalog;
	private String path;

	public LoadCommand(Catalog catalog, String path) {
		this.catalog = catalog;
		this.path = path;

	}

	public Catalog getCatalog() {
		return catalog;
	}
	
	@Override
	public void run() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			catalog = objectMapper.readValue(new File(path), Catalog.class);
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

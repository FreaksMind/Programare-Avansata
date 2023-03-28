package lab5.homework.command;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lab5.homework.Catalog;

public class SaveCommand implements ICommand {

	private Catalog catalog;
	private String path;

	public SaveCommand(Catalog catalog, String path) {
		this.catalog = catalog;
		this.path = path;
	}

	@Override
	public void run() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File(path), catalog);
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

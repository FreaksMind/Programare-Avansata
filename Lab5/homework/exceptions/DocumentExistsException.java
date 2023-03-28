package lab5.homework.exceptions;

public class DocumentExistsException extends Exception{

	public DocumentExistsException(String id) {
		super("Document with id " + id + " already exists in your catalog.");
	}
	
}

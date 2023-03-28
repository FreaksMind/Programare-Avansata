package lab5.homework.command;

import lab5.homework.exceptions.DocumentExistsException;

public interface ICommand {

	public void run() throws DocumentExistsException;
	
}

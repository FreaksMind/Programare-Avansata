package lab5.homework.command;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import lab5.homework.Document;

public class ViewCommand implements ICommand {

	private Document document;

	public ViewCommand(Document document) {
		this.document = document;
	}

	@Override
	public void run() {
		Desktop desktop = Desktop.getDesktop();
		try {
			if (document.getLocation().startsWith("https://") || document.getLocation().startsWith("http://")
					|| document.getLocation().startsWith("www.")) {
				desktop.browse(new URI(document.getLocation()));
			} else {
				desktop.open(new File(document.getLocation()));
			}
		} catch (IOException |

				URISyntaxException e) {
			e.printStackTrace();
		}
	}

}

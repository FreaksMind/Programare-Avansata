package lab5.homework.command;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import lab5.homework.Catalog;

public class ReportCommand implements ICommand {

	private Catalog catalog;

	public ReportCommand(Catalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public void run() {
		Velocity.init();
		Template template = Velocity.getTemplate("./src/main/resources/ceva.vm");

		VelocityContext context = new VelocityContext();
		context.internalPut("name", catalog.getName());
		context.internalPut("documents", catalog.getDocs());
		Writer writer = new StringWriter();
		template.merge(context, writer);
		try {
			FileWriter myWriter = new FileWriter("report.html");
			myWriter.write(writer.toString());
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Desktop d = Desktop.getDesktop();
		try {
			d.open(new File("report.html"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package lab5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

	private String name;
	private List<Document> docs = new ArrayList<>();

	public Catalog(String name) {
		this.name = name;
	}

	public void add(Document doc) {
		if (findById(doc.getId()) == null) {
			docs.add(doc);
		} else {
			System.out.println("Document with id " + doc.getId() + " already exists!");
		}
		System.out.println(docs.size());
	}

	public List<Document> getDocs() {
		return this.docs;
	}

	public Document findById(String id) {
		return docs.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
	}
}
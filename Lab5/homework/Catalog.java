package lab5.homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Catalog implements Serializable {

	@JsonProperty("name")
	private String name;
	@JsonProperty("docs")
	private List<Document> docs = new ArrayList<>();

	public Catalog() {
		
	}
	
	public Catalog(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public List<Document> getDocs() {
		return this.docs;
	}

	public Document findById(String id) {
		return docs.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
	}
}
package lab5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Document implements Serializable {
	private String id;
	private String title;
	private String location;
	private Map<String, Object> tags = new HashMap<>();

	public Document(String id, String title, String location) {
		this.id = id;
		this.title = title;
		this.location = location;
	}

	public void addTag(String key, Object obj) {
		tags.put(key, obj);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
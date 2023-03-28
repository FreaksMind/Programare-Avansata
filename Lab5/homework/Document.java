package lab5.homework;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Document implements Serializable {
	@JsonProperty("id")
	private String id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("location")
	private String location;

	@JsonProperty("tags")
	private Map<String, Object> tags = new HashMap<>();

	public Document(String id, String title, String location) {
		this.id = id;
		this.title = title;
		this.location = location;
	}

	public void addTag(String key, Object obj) {
		tags.put(key, obj);
	}

	public Map<String, Object> getTags() {
		return tags;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

}
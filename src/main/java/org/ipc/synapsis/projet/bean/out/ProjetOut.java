package org.ipc.synapsis.projet.bean.out;



import java.util.Map;
import java.util.UUID;

/**
 * Created by malaoui on 29/09/2016.
 */


public class ProjetOut {


	private UUID id;

	private String title;

	private String description;

	public ProjetOut() {
	}

	public ProjetOut(UUID id, String title, String description) {
		this.setId(id);
		this.setTitle(title);
		this.setDescription(description);
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProjetOut [id=" + id + ", title=" + title + ", description=" + description + "]";
	}


	



}
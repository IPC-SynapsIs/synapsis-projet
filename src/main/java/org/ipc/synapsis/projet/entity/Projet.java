package org.ipc.synapsis.projet.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by malaoui on 29/09/2016.
 */
@Entity
public class Projet {

	@Id
	@Column(columnDefinition = "BINARY(16)")
	@ApiModelProperty(value = "l'ID du Projet")
	private UUID id;


	@Column
	@ApiModelProperty(value = "Le titre du projet")
	private String title;

	@Lob
	@Column(columnDefinition = "TEXT", length = 65535)
	@ApiModelProperty(value = "La description du projet")
	private String description;

	public Projet() {
	}



	public Projet(String title, String description) {
		super();
		this.id = UUID.randomUUID();
		this.title = title;
		this.description = description;
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
		return "Projet [id=" + id + ", title=" + title + ", description=" + description + "]";
	}


}
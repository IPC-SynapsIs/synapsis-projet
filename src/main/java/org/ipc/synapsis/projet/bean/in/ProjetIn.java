package org.ipc.synapsis.projet.bean.in;


import java.io.Serializable;
/**
 * Created by malaoui on 29/09/2016.
 */


public class ProjetIn implements Serializable{


    private String title;
    
	private String description;




    public ProjetIn() {
    }

    public ProjetIn(String title,String description) {
        this.setTitle(title);
        this.setDescription(description);
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
		return "ProjetIn [title=" + title + ", description=" + description + "]";
	}

}
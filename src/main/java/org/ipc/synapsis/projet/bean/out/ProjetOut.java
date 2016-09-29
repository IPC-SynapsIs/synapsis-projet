package org.ipc.synapsis.projet.bean.out;



import java.util.UUID;

/**
 * Created by malaoui on 29/09/2016.
 */


public class ProjetOut {


    private UUID id;


    private String title;

    public ProjetOut() {
    }

    public ProjetOut(UUID id, String title) {
        this.setId(id);
        this.setTitle(title);
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




    @Override
    public String toString() {
        return "ProjetOut{" +
                "id=" + id  +
                ", title='" + title + '\'' +
                '}';
    }
}
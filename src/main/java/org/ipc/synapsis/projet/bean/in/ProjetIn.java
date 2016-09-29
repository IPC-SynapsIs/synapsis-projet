package org.ipc.synapsis.projet.bean.in;


import java.io.Serializable;

public class ProjetIn implements Serializable{


    private String title;



    public ProjetIn() {
    }

    public ProjetIn(String title) {
        this.setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @Override
    public String toString() {
        return "ProjetIn{" +
                "title='" + title + '\'' +

                '}';
    }
}
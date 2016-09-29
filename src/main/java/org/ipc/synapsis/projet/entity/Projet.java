package org.ipc.synapsis.projet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by malaoui on 29/09/2016.
 */
@Entity
public class Projet {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;


    @Column
    private String title;


    public Projet() {
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




}
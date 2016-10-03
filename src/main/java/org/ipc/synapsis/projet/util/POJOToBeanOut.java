package org.ipc.synapsis.projet.util;


import org.ipc.synapsis.projet.bean.out.ProjetOut;
import org.ipc.synapsis.projet.entity.Projet;

public class POJOToBeanOut  {

    public static ProjetOut getProjetOut(Projet projet){
        ProjetOut projetOut = new ProjetOut();
        projetOut.setId(projet.getId());
        projetOut.setTitle(projet.getTitle());
        projetOut.setDescription(projet.getDescription());
        projetOut.setCategories(projet.getCategories());
        return projetOut;
    }

   
}

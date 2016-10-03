package org.ipc.synapsis.projet.util;

import org.ipc.synapsis.projet.bean.in.ProjetIn;
import org.ipc.synapsis.projet.entity.Projet;


public class BeanInToPOJO {

    public static Projet getProjet(ProjetIn projetIn){
        Projet projet = new Projet();
        projet.setTitle(projetIn.getTitle());
        projet.setDescription(projetIn.getDescription());
        return projet;
    }


}

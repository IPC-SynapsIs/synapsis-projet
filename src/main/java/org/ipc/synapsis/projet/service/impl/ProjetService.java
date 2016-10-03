package org.ipc.synapsis.projet.service.impl;

import org.ipc.synapsis.projet.bean.in.ProjetIn;
import org.ipc.synapsis.projet.bean.out.ProjetOut;
import org.ipc.synapsis.projet.entity.Projet;
import org.ipc.synapsis.projet.proxy.IProjetProxy;
import org.ipc.synapsis.projet.service.IProjetService;
import org.ipc.synapsis.projet.util.BeanInToPOJO;
import org.ipc.synapsis.projet.util.POJOToBeanOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProjetService implements IProjetService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProjetService.class);

    @Autowired
    IProjetProxy projetProxy;

    @Override
    public ProjetOut get(final String id) throws Exception{
        LOGGER.debug("Start call Service layer get a 'Projet OUT',id:{}",id);
        ProjetOut projetOut = null;
        Projet projet = projetProxy.get(id);
        if (projet == null){
            LOGGER.warn("Resource 'Projet' not found, id:{}",id);
            throw new Exception();
        }
        projetOut = POJOToBeanOut.getProjetOut(projet);
        LOGGER.debug("End call Service layer get a 'Projet OUT',{}",projetOut);
        return projetOut;
    }

    @Override
    public Iterable<ProjetOut> getAll() {
        LOGGER.debug("Start call Service layer get all 'Projet OUT'");
        ArrayList<ProjetOut> projetsOutList = new ArrayList<ProjetOut>();
        Iterable<Projet> projetList = projetProxy.getAll();
        for (Projet projet : projetList){
            projetsOutList.add(POJOToBeanOut.getProjetOut(projet));
        }
        LOGGER.debug("End call Service layer get all 'Projet OUT'");
        return (Iterable) projetsOutList;
    }

    @Override
    public UUID add(final ProjetIn projetIn) {
        LOGGER.debug("Start call Service layer add new 'Projet IN',{}",projetIn);
        UUID id= UUID.randomUUID();
        Projet projet = BeanInToPOJO.getProjet(projetIn);
        projet.setId(id);
        projetProxy.add(projet);
        LOGGER.debug("End call Service layer add new 'Projet',{}",projet);
        return id;
    }

    @Override
    public void update(final String id,final ProjetIn projetIn) {
        LOGGER.debug("End call Service layer update 'Projet IN',{}",projetIn);
        Projet projet = BeanInToPOJO.getProjet(projetIn);
        projet.setId(UUID.fromString(id));
        projetProxy.update(projet);
        LOGGER.debug("End call Service layer update 'Projet',{}",projet);
    }

    @Override
    public void remove(final String id) throws Exception {
        LOGGER.debug("Start call Service layer remove 'Projet',id:{}",id);
        projetProxy.remove(id);
        LOGGER.debug("Start call Service layer remove 'Projet',id:{}",id);
    }

    @Override
    public List<ProjetOut> findByTitle(final String title){
        LOGGER.debug("Start call Service layer remove 'Projet'title:{}",title);

        List<ProjetOut> projetsOutList = new ArrayList<ProjetOut>();
        List<Projet> projetList = projetProxy.findByTitle(title);
        for (Projet projet : projetList){
            projetsOutList.add( POJOToBeanOut.getProjetOut(projet));
        }

        return  projetsOutList;
    }

    @Override
    public List<ProjetOut> findByTitleContaining(final String title){
        LOGGER.debug("Start call Service layer remove 'Projet'title:{}",title);

        List<ProjetOut> projetsOutList = new ArrayList<ProjetOut>();
        List<Projet> projetList = projetProxy.findByTitleContaining(title);
        for (Projet projet : projetList){
            projetsOutList.add( POJOToBeanOut.getProjetOut(projet));
        }

        return  projetsOutList;
    }

	@Override
	public List<ProjetOut> findByDescriptionContaining(String description) {
        LOGGER.debug("Start call Service layer remove 'Projet'description:{}",description);

        List<ProjetOut> projetsOutList = new ArrayList<ProjetOut>();
        List<Projet> projetList = projetProxy.findByDescriptionContaining(description);
        for (Projet projet : projetList){
            projetsOutList.add( POJOToBeanOut.getProjetOut(projet));
        }

        return  projetsOutList;
	}

	@Override
	public boolean isHere(String id) {
		 try {
		        UUID.fromString(id);
		        Projet projet = projetProxy.get(id);
		        return (projet != null);
		    } 
		 catch (Exception ex) {
		        return false;
		    }
	}
}
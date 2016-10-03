package org.ipc.synapsis.projet.proxy.impl;

import org.ipc.synapsis.projet.dao.IProjetDao;
import org.ipc.synapsis.projet.entity.Projet;
import org.ipc.synapsis.projet.proxy.IProjetProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by malaoui on 29/09/2016.
 */

@Component
public class ProjetProxy implements IProjetProxy {

    private static Logger LOGGER = LoggerFactory.getLogger(ProjetProxy.class);

    @Autowired
    IProjetDao projetDao;

    @Override
    public Projet get(String id) throws Exception {
        LOGGER.debug("Start call Proxy layer get a 'Projet',id:{}",id);
        Projet projet = projetDao.get(id);
        LOGGER.debug("End call Proxy layer get a 'Projet',id:{}",id);
        return projet;
    }

    @Override
    public Iterable<Projet> getAll() {
        LOGGER.debug("Start call Proxy layer get all 'Projet'");
        Iterable<Projet> projetList = projetDao.getAll();
        LOGGER.debug("End call Proxy layer get all 'Projet'");
        return projetList;
    }

    @Override
    public Projet add(Projet projet) {
        LOGGER.debug("Start call Proxy layer add new 'Projet',{}",projet);
        Projet projet1 = projetDao.add(projet);
        LOGGER.debug("End call Proxy layer add new 'Projet',{}",projet1);
        return projet1;
    }

    @Override
    public Projet update(Projet projet) {
        LOGGER.debug("End call Proxy layer update 'Projet',{}",projet);
        Projet projet1 = projetDao.update(projet);
        LOGGER.debug("End call Proxy layer update 'Projet',{}",projet1);
        return projet1;
    }

    @Override
    public void remove(String id) throws Exception {
        LOGGER.debug("Start call Proxy layer remove 'Projet',id:{}",id);
        projetDao.remove(id);
        LOGGER.debug("End call Proxy layer remove 'Projet',id:{}",id);
    }
    @Override
    public List<Projet> findByTitle(final String title){
        LOGGER.debug("Start call Proxy layer findByTitle 'title':{}",title);
        return projetDao.findByTitle(title);
    }

    @Override
    public List<Projet> findByTitleContaining(final String title){
        LOGGER.debug("Start call Proxy layer findByTitle 'title':{}",title);
        return projetDao.findByTitleContaining(title);
    }

	@Override
	public List<Projet> findByDescriptionContaining(String description) {
        LOGGER.debug("Start call Proxy layer findByDescriptionContaining 'description':{}", description);
        return projetDao.findByDescriptionContaining(description);
	}

	@Override
	public Projet addCategorie(String id, String categorie) {
        LOGGER.debug("Start call Proxy layer add 'Projet categorie',id:{}",id);
		return projetDao.addCategorie(id, categorie);
	}

	@Override
	public Projet removeCategorie(String id, String categorie) {
        LOGGER.debug("Start call Proxy layer remove 'Projet categorie',id:{}",id);
        return projetDao.removeCategorie(id, categorie);
	}

	@Override
	public List<String> getCategories(String id) {
        LOGGER.debug("Start call Proxy layer get 'Projet categories',id:{}",id);
		return projetDao.getCategories(id);
	}
}
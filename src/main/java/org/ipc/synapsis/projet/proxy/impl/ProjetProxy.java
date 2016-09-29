package org.ipc.synapsis.projet.proxy.impl;

import org.ipc.synapsis.projet.dao.IProjetDao;
import org.ipc.synapsis.projet.entity.Projet;
import org.ipc.synapsis.projet.proxy.IProjetProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mbasri on 09/07/2016.
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
}
package org.ipc.synapsis.projet.dao.impl;

import org.ipc.synapsis.projet.dao.IProjetDao;
import org.ipc.synapsis.projet.entity.Projet;
import org.ipc.synapsis.projet.repository.IProjetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by mbasri on 09/07/2016.
 */
@Component
public class ProjetDao implements IProjetDao {

    private static Logger LOGGER = LoggerFactory.getLogger(ProjetDao.class);

    @Autowired
    IProjetRepository projetRepository;

    @Override
    public Projet get(final String id) throws Exception {
        LOGGER.debug("Start call Dao layer get a 'Projet Vitae',id:{}",id);
        Projet Projet = null;
        try {
            Projet = projetRepository.findOne(UUID.fromString(id));
        }catch (IllegalArgumentException e){
            LOGGER.error("Dao layer Cannot parse String:{} to UUID",id);
            throw new Exception();
        }
        LOGGER.debug("End call Dao layer get a 'Projet',id:{}",id);
        return Projet;
    }

    @Override
    public Iterable<Projet> getAll() {
        LOGGER.debug("Start call Dao layer get all 'Projet'");
        Iterable<Projet> ProjetList = projetRepository.findAll();
        LOGGER.debug("End call Dao layer get all 'Projet'");
        return ProjetList;
    }

    @Override
    public Projet add(final Projet Projet) {
        LOGGER.debug("Start call Dao layer add new 'Projet',{}",Projet);
        Projet Projet1 = projetRepository.save(Projet);
        LOGGER.debug("End call Dao layer add new 'Projet',{}",Projet1);
        return Projet1;
    }

    @Override
    public Projet update(Projet Projet) {
        LOGGER.debug("End call Dao layer update 'Projet',{}",Projet);
        Projet Projet1 = projetRepository.save(Projet);
        LOGGER.debug("End call Dao layer update 'Projet',{}",Projet1);
        return Projet1;
    }

    @Override
    public void remove(String id) throws Exception {
        LOGGER.debug("Start call Dao layer remove 'Projet',id:{}",id);
        try {
            projetRepository.delete(UUID.fromString(id));
        }catch (IllegalArgumentException e){
            LOGGER.error("Dao layer Cannot parse String:{} to UUID",id);
            throw new Exception();
        }
        LOGGER.debug("End call Dao layer remove 'Projet',id:{}",id);
    }
}
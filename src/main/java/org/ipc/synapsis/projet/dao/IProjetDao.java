package org.ipc.synapsis.projet.dao;


import org.ipc.synapsis.projet.entity.Projet;

import java.util.List;

public interface IProjetDao {
    Projet get(final String id) throws Exception;
    Iterable<Projet> getAll();
    Projet add(final Projet projet);
    Projet update(final Projet projet);
    void remove(final String id) throws Exception;
    List<Projet> findByTitle(final String title);
    List<Projet> findByTitleContaining(final String title);
}
package org.ipc.synapsis.projet.dao;


import org.ipc.synapsis.projet.entity.Projet;

public interface IProjetDao {
    Projet get(final String id) throws Exception;
    Iterable<Projet> getAll();
    Projet add(final Projet curriculumVitae);
    Projet update(final Projet curriculumVitae);
    void remove(final String id) throws Exception;
}
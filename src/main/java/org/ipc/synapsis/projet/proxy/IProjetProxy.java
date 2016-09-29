package org.ipc.synapsis.projet.proxy;

import org.ipc.synapsis.projet.entity.Projet;

import java.util.List;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface IProjetProxy {
    Projet get(final String id) throws Exception;
    Iterable<Projet> getAll();
    Projet add(final Projet curriculumVitae);
    Projet update(final Projet curriculumVitae);
    void remove(final String id) throws Exception;
    List<Projet> findByTitle(final String title);
    List<Projet> findByTitleContaining(final String title);
}

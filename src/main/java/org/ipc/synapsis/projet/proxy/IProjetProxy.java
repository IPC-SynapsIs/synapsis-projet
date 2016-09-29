package org.ipc.synapsis.projet.proxy;

import org.ipc.synapsis.projet.entity.Projet;

/**
 * Created by mbasri on 19/06/2016.
 */
public interface IProjetProxy {
    Projet get(final String id) throws Exception;
    Iterable<Projet> getAll();
    Projet add(final Projet curriculumVitae);
    Projet update(final Projet curriculumVitae);
    void remove(final String id) throws Exception;
}

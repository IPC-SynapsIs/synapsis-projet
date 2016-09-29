package org.ipc.synapsis.projet.service;

import org.ipc.synapsis.projet.bean.in.ProjetIn;
import org.ipc.synapsis.projet.bean.out.ProjetOut;

import java.util.List;
import java.util.UUID;


/**
 * Created by mbasri on 19/06/2016.
 */
public interface IProjetService {
    ProjetOut get(final String id) throws Exception;
    Iterable<ProjetOut> getAll();
    UUID add(final ProjetIn curriculumVitaeIn);
    void update(final String id, final ProjetIn curriculumVitaeIn);
    void remove(final String id) throws Exception;
    List findByTitle(final String title);
    List<ProjetOut> findByTitleContaining(final String title);
}
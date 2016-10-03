package org.ipc.synapsis.projet.service;

import org.ipc.synapsis.projet.bean.in.ProjetIn;
import org.ipc.synapsis.projet.bean.out.ProjetOut;

import java.util.List;
import java.util.UUID;


/**
 * Created by malaoui on 29/09/2016.
 */

public interface IProjetService {
    ProjetOut get(final String id) throws Exception;
    Iterable<ProjetOut> getAll();
    UUID add(final ProjetIn projetIn);
    void update(final String id, final ProjetIn projetIn);
    void remove(final String id) throws Exception;
    List findByTitle(final String title);
    List<ProjetOut> findByTitleContaining(final String title);
    List<ProjetOut> findByDescriptionContaining(final String description);
	boolean isHere(String id);
}
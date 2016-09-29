package org.ipc.synapsis.projet.repository;

import org.ipc.synapsis.projet.entity.Projet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface IProjetRepository extends CrudRepository<Projet, UUID> {
    List<Projet> findByTitle(String title);
    List<Projet> findByTitleContainingIgnoreCase(String title);
}
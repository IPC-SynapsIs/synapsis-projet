package org.ipc.synapsis.projet.repository;

import org.ipc.synapsis.projet.entity.Projet;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface IProjetRepository extends CrudRepository<Projet, UUID> {
}
package org.ipc.synapsis.projet.resource;


import org.ipc.synapsis.projet.bean.in.ProjetIn;
import org.ipc.synapsis.projet.bean.out.ProjetOut;
import org.ipc.synapsis.projet.service.IProjetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/projet")
public class ProjetResource  {

    private static Logger LOGGER = LoggerFactory.getLogger(ProjetResource.class);

    @Autowired
    IProjetService projetService;


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON )
    public ResponseEntity add(@RequestBody final ProjetIn projetIn) {
        LOGGER.debug("Start call of the web service add new 'Projet',{}",projetIn);
        UUID id = projetService.add(projetIn);
        LOGGER.debug("End call of the web service add new 'Projet',{}",projetIn);
        return ResponseEntity.created(URI.create("/api/projet/"+id)).build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON )
    public ResponseEntity update(@PathVariable final String id, @RequestBody final ProjetIn projetIn) {
        LOGGER.debug("Start call of the web service update 'Projet',{}", projetIn);
        projetService.update(id, projetIn);
        LOGGER.debug("End call of the web service update 'Projet',{}", projetIn);
        return ResponseEntity.ok().build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable final String id) throws Exception {
        LOGGER.debug("Start call of the web service get 'Projet' by id, id={}",id);
        ProjetOut projetOut = null;
        try {
            projetOut = projetService.get(id);
        } catch (Exception e) {
            LOGGER.warn("Exception get Projet");

        }
        LOGGER.debug("End call of  the web service get 'Projet' by id, id={}",id);
        return ResponseEntity.ok(projetOut);
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON )
    public ResponseEntity getAll() {
        LOGGER.debug("Start call of the web service get all 'Projet'");
        Iterable<ProjetOut> projetOutList = projetService.getAll();
        LOGGER.debug("End call of the web service get all 'Projet'");
        return ResponseEntity.ok(projetOutList);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity remove(@PathVariable final String id) throws Exception {
        LOGGER.debug("Start call of the web service delete 'Projet' by id,id={}",id);
        try {
            projetService.remove(id);
        }catch (Exception e) {
            LOGGER.error("Resource layer Cannot parse Sting to UUID");

        }
        LOGGER.debug("End call of the web service delete 'Projet' by id,id={}",id);
        return ResponseEntity.ok().build();
    }


}
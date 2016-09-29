package org.ipc.synapsis.projet.resource;


import org.ipc.synapsis.projet.bean.out.ProjetOut;
import org.ipc.synapsis.projet.service.IProjetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Component
@Path("/api/projet")
public class ProjetResource  {

    private static Logger LOGGER = LoggerFactory.getLogger(ProjetResource.class);

    @Autowired
    IProjetService projetService;


   /* @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON )
    public ResponseEntity add(final ProjetIn projetIn) {
        LOGGER.debug("Start call of the web service add new 'Projet',{}",projetIn);
        UUID id = projetService.add(projetIn);
        LOGGER.debug("End call of the web service add new 'Projet',{}",projetIn);
        return ResponseEntity.created(URI.create("/api/projet/"+id)).build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON )
    public ResponseEntity update(final String id, final ProjetIn projetIn) {
        LOGGER.debug("Start call of the web service update 'Projet',{}",projetIn);
        projetService.update(id,projetIn);
        LOGGER.debug("End call of the web service update 'Projet',{}",projetIn);
        return ResponseEntity.ok().build();

    */

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity get(@PathParam("id") final String id) throws Exception {
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
    /*

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON )
    public ResponseEntity getAll() {
        LOGGER.debug("Start call of the web service get all 'Projet'");
        Iterable<ProjetOut> projetOutList = projetService.getAll();
        LOGGER.debug("End call of the web service get all 'Projet'");
        return ResponseEntity.ok(projetOutList);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity remove(final String id) throws Exception {
        LOGGER.debug("Start call of the web service delete 'Projet' by id,id={}",id);
        try {
            projetService.remove(id);
        }catch (Exception e) {
            LOGGER.error("Resource layer Cannot parse Sting to UUID");

        }
        LOGGER.debug("End call of the web service delete 'Projet' by id,id={}",id);
        return ResponseEntity.ok().build();
    }

    */
    @GET
    @Path("/test")
    public ResponseEntity health(){
        LOGGER.debug("Call of the web service health");
        return ResponseEntity.ok().build();
    }
}
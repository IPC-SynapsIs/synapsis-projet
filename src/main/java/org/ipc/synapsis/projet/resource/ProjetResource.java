package org.ipc.synapsis.projet.resource;


import org.ipc.synapsis.projet.bean.in.ProjetIn;
import org.ipc.synapsis.projet.bean.out.ProjetOut;
import org.ipc.synapsis.projet.service.IProjetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/projet")
public class ProjetResource  {

    private static Logger LOGGER = LoggerFactory.getLogger(ProjetResource.class);

    @Autowired
    IProjetService projetService;

    @ApiOperation(value = "ADD a new Projet")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Projet creation : Done", response = URI.class) })
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON )
    public ResponseEntity add(@RequestBody final ProjetIn projetIn,HttpServletRequest request) {
        LOGGER.debug("Start call of the web service add new 'Projet',{}",projetIn);
        UUID id = projetService.add(projetIn);
        LOGGER.debug("End call of the web service add new 'Projet',{}",projetIn);
        return ResponseEntity.created(URI.create(request.getRequestURL().append("/"+id).toString())).build();
    }

    @ApiOperation(value = "Update a Projet")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Projet Updated : Done", response = URI.class),
			@ApiResponse(code = 404, message = "Projet Updated : Not Found", response = URI.class) })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON )
    public ResponseEntity update(@PathVariable final String id, @RequestBody final ProjetIn projetIn) {
        LOGGER.debug("Start call of the web service update 'Projet',{}", projetIn);
        if(projetService.isHere(id))
        {
	        projetService.update(id, projetIn);
	        LOGGER.debug("End call of the web service update 'Projet',{}", projetIn);
	        return ResponseEntity.ok().build();
        }
        else return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Get a Projet")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Projet found", response = URI.class),
			@ApiResponse(code = 404, message = "Projet not found", response = URI.class),
			@ApiResponse(code = 422, message = "Projet : technical Error", response = URI.class) })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable final String id) throws Exception {
        LOGGER.debug("Start call of the web service get 'Projet' by id, id={}",id);
        if(projetService.isHere(id))
        {
	        ProjetOut projetOut = null;
	        try {
	            projetOut = projetService.get(id);
	        } catch (Exception e) {
	            LOGGER.warn("Exception get Projet");
	            return ResponseEntity.unprocessableEntity().build();
	        }
	        LOGGER.debug("End call of  the web service get 'Projet' by id, id={}",id);
	        return ResponseEntity.ok(projetOut);
        }
        else return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Get all Projet")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Projets found", response = URI.class),
			@ApiResponse(code = 400, message = "Projet : technical Error", response = URI.class) })
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON )
    public ResponseEntity getAll() {
        LOGGER.debug("Start call of the web service get all 'Projet'");
        Iterable<ProjetOut> projetOutList = projetService.getAll();
        LOGGER.debug("End call of the web service get all 'Projet'");
        return ResponseEntity.ok(projetOutList);
    }

    @ApiOperation(value = "Delete a Projet")
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "Projet deleted", response = URI.class),
			@ApiResponse(code = 404, message = "Projet not found", response = URI.class) })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity remove(@PathVariable final String id) throws Exception {
        LOGGER.debug("Start call of the web service delete 'Projet' by id,id={}",id);
        if(projetService.isHere(id))
        {
        	try {
	            projetService.remove(id);
		        LOGGER.debug("End call of the web service delete 'Projet' by id,id={}",id);
		        return ResponseEntity.ok().build();
	        }catch (Exception e) {
	            LOGGER.error("Resource layer Cannot parse Sting to UUID");
	            return ResponseEntity.badRequest().build();
	        }
        }
        else return ResponseEntity.notFound().build();
        
    }

    @ApiOperation(value = "Find a projet by Title")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Projet Found", response = URI.class) })
    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    public ResponseEntity findByTitle(@PathVariable final String title) throws Exception {
        LOGGER.debug("Start call of the web service get 'Projet' by , title={}",title);
        List<ProjetOut> listProjetOut = null;
        try {
            listProjetOut = projetService.findByTitle(title);
        } catch (Exception e) {
            LOGGER.warn("Exception get Projet");

        }
        LOGGER.debug("End call of  the web service get 'Projet' by , title={}",title);
        return ResponseEntity.ok(listProjetOut);
    }

    @ApiOperation(value = "Find a projet by Title containing..")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Projet Found", response = URI.class) })
    @RequestMapping(value = "/criterias/title", method = RequestMethod.GET)
    public ResponseEntity findByTitleContaining(@RequestParam final String title) throws Exception {
        LOGGER.debug("Start call of the web service get 'Projet' by , title={}",title);
        List<ProjetOut> listProjetOut = null;
        try {
            listProjetOut = projetService.findByTitleContaining(title);
        } catch (Exception e) {
            LOGGER.warn("Exception get Projet");

        }
        LOGGER.debug("End call of  the web service get 'Projet' by , title={}",title);
        return ResponseEntity.ok(listProjetOut);
    }
    
    @ApiOperation(value = "Find a projet by Description containing..")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Projet Found", response = URI.class)})    
    @RequestMapping(value = "/criterias/description", method = RequestMethod.GET)
    public ResponseEntity findByDescriptionContaining(@RequestParam final String description) throws Exception {
        LOGGER.debug("Start call of the web service get 'Projet' by , description={}",description);
        List<ProjetOut> listProjetOut = null;
        try {
            listProjetOut = projetService.findByDescriptionContaining(description);
        } catch (Exception e) {
            LOGGER.warn("Exception get Projet");

        }
        LOGGER.debug("End call of  the web service get 'Projet' by , description={}",description);
        return ResponseEntity.ok(listProjetOut);
    }


}
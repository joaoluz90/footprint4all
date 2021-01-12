package pt.iade.footprint4all.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.footprint4all.models.Escala;
import pt.iade.footprint4all.models.exceptions.NotFoundException;
import pt.iade.footprint4all.models.repositories.EscalaRepository;

@RestController
@RequestMapping(path = "/api/escalas")
public class EscalaController {
    private Logger logger = LoggerFactory.getLogger(EscalaController.class);
    @Autowired
    private EscalaRepository escalaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Escala> getEscalas() {
        logger.info("Sending all existing escalas");
        return escalaRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Escala getEscala(@PathVariable int id) {
        logger.info("Sending escala with id "+id);
        Optional<Escala> _escala = escalaRepository.findById(id);
        if (_escala.isEmpty()) throw new NotFoundException(""+id,"Escala","id");
        else return _escala.get() ;
    }

    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Escala saveEscala(@RequestBody Escala newEscala) {
        logger.info("Saving escala with description: "+newEscala.getDescricao());
        Escala escala = escalaRepository.save(newEscala);
        return escala;
    }
   
}   
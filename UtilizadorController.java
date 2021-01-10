package pt.iade.footprint4all.controllers;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.footprint4all.models.Utilizador;
import pt.iade.footprint4all.models.exceptions.NotFoundException;
import pt.iade.footprint4all.models.repositories.UtilizadorRepository;


@RestController
@RequestMapping(path="/api/utilizadores")
public class UtilizadorController {
    private Logger logger = LoggerFactory.getLogger(UtilizadorController.class);
    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> getUtilizadores() {
        logger.info("Sending all users");
        return utilizadorRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Utilizador getUtilizador(@PathVariable int id) {
        logger.info("Sending user with id "+id);
        Optional<Utilizador> _utilizador = utilizadorRepository.findById(id);
        if (_utilizador.isEmpty()) throw new NotFoundException(""+id,"Escala","id");
        else return _utilizador.get() ;
    }

    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Utilizador saveUser(@RequestBody Utilizador newUser) {
        logger.info("Saving user with id: "+newUser.getId());
        Utilizador utilizador = utilizadorRepository.save(newUser);
        return utilizador;
    }

    @DeleteMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String deleteStudent(@PathVariable("id") int id) {
        logger.info("deleting user with id "+id);
        if (utilizadorRepository.findById(id) != null) {
            utilizadorRepository.deleteById(id);
            return "deleted by id given --> " + id;
        }    
        else
            return id + "not found";
    }
}

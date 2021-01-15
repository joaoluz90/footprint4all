package pt.iade.footprint4all.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.footprint4all.models.Administrador;
import pt.iade.footprint4all.models.exceptions.NotFoundException;
import pt.iade.footprint4all.models.repositories.AdministradorRepository;

@RestController
@RequestMapping(path="/api/admins")
public class AdministradorController {
    private Logger logger = LoggerFactory.getLogger(AdministradorController.class);
    @Autowired
    private AdministradorRepository administradorRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Administrador> getAdmins() {
        logger.info("Sending all admins");
        return administradorRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Administrador getAdmin(@PathVariable int id) {
        logger.info("Sending admin with id "+id);
        Optional<Administrador> _admin = administradorRepository.findById(id);
        if (_admin.isEmpty()) throw new NotFoundException(""+id,"Admin","id");
        else return _admin.get() ;
    }
}

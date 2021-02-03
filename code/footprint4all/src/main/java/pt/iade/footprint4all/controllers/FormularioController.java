package pt.iade.footprint4all.controllers;

import java.util.ArrayList;
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

import pt.iade.footprint4all.models.Formulario;
import pt.iade.footprint4all.models.exceptions.NotFoundException;
import pt.iade.footprint4all.models.repositories.FormularioRepository;

@RestController
@RequestMapping(path="/api/formularios")
public class FormularioController {
    private Logger logger = LoggerFactory.getLogger(FormularioController.class);
    @Autowired
    private FormularioRepository formularioRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Formulario> getFormularios() {
        logger.info("Sending all formulários");
        return formularioRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Formulario getFormulario(@PathVariable int id) {
        logger.info("Sending form with id "+id);
        Optional<Formulario> _formulario = formularioRepository.findById(id);
        if (_formulario.isEmpty()) throw new NotFoundException(""+id,"Form","id");
        else return _formulario.get() ;
    }

    private ArrayList<Formulario> forms = new ArrayList<Formulario>();
    @PostMapping(path = "")
    public Formulario saveForm(@RequestBody Formulario form) {
        logger.info("Added form "+form.getNome_formulario());
        forms.add(form);
        return form;
 }
}

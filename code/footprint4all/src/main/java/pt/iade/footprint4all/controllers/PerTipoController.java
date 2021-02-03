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

import pt.iade.footprint4all.models.PerTipo;
import pt.iade.footprint4all.models.exceptions.NotFoundException;
import pt.iade.footprint4all.models.repositories.PerTipoRepository;

@RestController
@RequestMapping(path="/api/tipoperguntas")  
public class PerTipoController {
    private Logger logger = LoggerFactory.getLogger(PerTipoController.class);
    @Autowired
    private PerTipoRepository perTipoRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PerTipo> getTipoPerguntas() {
        logger.info("Sending all type of questions");
        return perTipoRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public PerTipo getPerTipo(@PathVariable int id) {
        logger.info("Sending user with id "+id);
        Optional<PerTipo> _perTipo = perTipoRepository.findById(id);
        if (_perTipo.isEmpty()) throw new NotFoundException(""+id,"Pergunta tipo","id");
        else return _perTipo.get() ;
    }

    @PostMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public PerTipo saveEscala(@RequestBody PerTipo newEscala) {
        logger.info("Saving type of question with description: "+newEscala.getNome());
        PerTipo escala = perTipoRepository.save(newEscala);
        return escala;
    }
    
}

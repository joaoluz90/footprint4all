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
import pt.iade.footprint4all.models.Classificado;
//import pt.iade.footprint4all.models.ClassificadoId;
import pt.iade.footprint4all.models.exceptions.NotFoundException;
import pt.iade.footprint4all.models.repositories.ClassificadoRepository;

@RestController
@RequestMapping(path="/api/classificacoes")   
public class ClassificadoController {
    private Logger logger = LoggerFactory.getLogger(ClassificadoController.class);
    @Autowired
    private ClassificadoRepository classificadoRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Classificado> getClassificacoes() {
        logger.info("Enviando todas as classificações dos utilizadores");
        return classificadoRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE) 
        public Classificado getClassificacao(@PathVariable int id) {
        logger.info("Sending classificação with id "+id);
        Optional<Classificado> _classificacao = classificadoRepository.findById(id);
        if (_classificacao.isEmpty()) throw new NotFoundException(""+id,"Classificação","id");
        else return _classificacao.get() ;
    }

}

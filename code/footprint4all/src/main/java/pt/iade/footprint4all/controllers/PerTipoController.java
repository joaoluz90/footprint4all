package pt.iade.footprint4all.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.footprint4all.models.PerTipo;
import pt.iade.footprint4all.models.repositories.PerTipoRepository;

@RestController
@RequestMapping(path="/api/tipoperguntas")  //controlador por melhorar
public class PerTipoController {
    private Logger logger = LoggerFactory.getLogger(PerTipoController.class);
    @Autowired
    private PerTipoRepository perTipoRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PerTipo> getTipoPerguntas() {
        logger.info("Sending all type of questions");
        return perTipoRepository.findAll();
    }
}

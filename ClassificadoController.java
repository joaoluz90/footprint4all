package pt.iade.footprint4all.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.footprint4all.models.Classificado;
import pt.iade.footprint4all.models.repositories.ClassificadoRepository;

@RestController
@RequestMapping(path="/api/classificacoes")   //adicionar funcionalidade que initerliga fk(uti_id e esc_id)
public class ClassificadoController {
    private Logger logger = LoggerFactory.getLogger(ClassificadoController.class);
    @Autowired
    private ClassificadoRepository classificadoRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Classificado> getClassificacoes() {
        logger.info("Enviando todas as classificações dos utilizadores");
        return classificadoRepository.findAll();
    }
}

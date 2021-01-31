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
import pt.iade.footprint4all.models.Edita;
import pt.iade.footprint4all.models.exceptions.NotFoundException;
import pt.iade.footprint4all.models.repositories.EditaRepository;

@RestController
@RequestMapping(path="/api/edita")
public class EditaController {
    private Logger logger = LoggerFactory.getLogger(EditaController.class);
    @Autowired
    private EditaRepository editaRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Edita> getEdicoes() {
        logger.info("Enviando todas as edições");
        return editaRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE) 
        public Edita getEdicao(@PathVariable int id) {
        logger.info("Sending edição with id "+id);
        Optional<Edita> _edicao = editaRepository.findById(id);
        if (_edicao.isEmpty()) throw new NotFoundException(""+id,"Edição","id");
        else return _edicao.get() ;
    }
}

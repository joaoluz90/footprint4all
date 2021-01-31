package pt.iade.footprint4all.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.footprint4all.models.Resposta;
import pt.iade.footprint4all.models.exceptions.NotFoundException;
import pt.iade.footprint4all.models.repositories.RespostaRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path="/api/respostas")
public class RespostaController {
    private Logger logger = LoggerFactory.getLogger(RespostaController.class);
    @Autowired
    private RespostaRepository respostaRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Resposta> getRespostas() {
        logger.info("Sending all answers information");
        return respostaRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Resposta getResposta(@PathVariable int id) {
        logger.info("Sending resposta with id "+id);
        Optional<Resposta> _resposta = respostaRepository.findById(id);
        if (_resposta.isEmpty()) throw new NotFoundException(""+id,"Resposta","id");
        else return _resposta.get() ;
    }
}

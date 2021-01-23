package pt.iade.footprint4all.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.iade.footprint4all.models.Questionario;
import pt.iade.footprint4all.models.exceptions.NotFoundException;
import pt.iade.footprint4all.models.repositories.QuestionarioRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path="/api/questionarios")
public class QuestionarioController {
    private Logger logger = LoggerFactory.getLogger(QuestionarioRepository.class);
    @Autowired
    private QuestionarioRepository questionarioRepository;

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Questionario> getQuestionarios() {
        logger.info("Sending all questionarios information");
        return questionarioRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Questionario getQuestionario(@PathVariable int id) {
        logger.info("Sending questionário with id "+id);
        Optional<Questionario> _questionario = questionarioRepository.findById(id);
        if (_questionario.isEmpty()) throw new NotFoundException(""+id,"Questionario","id");
        else return _questionario.get() ;
    }
}

package me.gabu.gabazar.leitores.adapters.html.in;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.leitores.adapters.html.in.dto.LeitorDTO;
import me.gabu.gabazar.leitores.adapters.html.in.dto.mapper.LeitorDTOMapper;
import me.gabu.gabazar.leitores.core.model.Leitor;
import me.gabu.gabazar.leitores.service.LeitorService;
import me.gabu.gabazar.leitores.service.TokenService;

@Slf4j
@Controller
@RequestMapping("/leitores")
public class LeitorController {

    private @Autowired LeitorService service;
    private @Autowired TokenService tokenService;

    private LeitorDTOMapper mapper = LeitorDTOMapper.INSTANCE;

    @PostMapping(produces = "application/json")
    public @ResponseBody LeitorDTO post(@RequestBody LeitorDTO leitorDTO, @RequestHeader("token") String token) {
        log.info("[POST] [/leitores] Request: {}", leitorDTO);

        validaToken(token);

        Leitor leitor = mapper.leitorDtoToLeitor(leitorDTO);
        Leitor leitorCriada = service.criarLeitor(leitor, getUsuario(token));

        return mapper.leitorToLeitorDto(leitorCriada);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody LeitorDTO getByID(@PathVariable("id") String id, @RequestHeader("token") String token) {
        log.info("[GET] [/leitores/{}]", id);

        validaToken(token);

        return mapper.leitorToLeitorDto(service.consultarLeitor(id));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody LeitorDTO put(@PathVariable("id") String id, @RequestHeader("token") String token,
            @RequestBody LeitorDTO leitorDTO) {
        log.info("[PUT] [/leitores/{}] Request: {}", id, leitorDTO);

        validaToken(token);

        Leitor leitor = mapper.leitorDtoToLeitor(leitorDTO);
        leitor.setId(id);

        return mapper.leitorToLeitorDto(service.atualizarLeitor(leitor, getUsuario(token)));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<LeitorDTO> delete(@PathVariable("id") String id, @RequestHeader("token") String token) {
        log.info("[DELETE] [/leitores/{}]", id);

        validaToken(token);

        service.apagarLeitor(id, getUsuario(token));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping
    public @ResponseBody Collection<LeitorDTO> get(@RequestParam(required = false) String nome,
            @RequestHeader("token") String token) {
        validaToken(token);

        return mapper.leitorToLeitorDto(service.listarLeitores(nome));
    }

    private String getUsuario(String token) {
        return tokenService.recuperarUsuario(token);
    }

    private void validaToken(String token) {
        tokenService.validaToken(token);
    }
}

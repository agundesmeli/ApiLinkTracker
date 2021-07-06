package br.com.meli.apilinktracker.apilinktracker.controller;

import br.com.meli.apilinktracker.apilinktracker.dto.LinkDTO;
import br.com.meli.apilinktracker.apilinktracker.entity.Link;
import br.com.meli.apilinktracker.apilinktracker.repository.LinkRepository;
import br.com.meli.apilinktracker.apilinktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/link-tracker")
public class LinkController {

    LinkRepository linkRepository = new LinkRepository();

    private LinkService linkService;

    public LinkController() {
    }

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }


    @PostMapping("/link")
    public ResponseEntity<?> criarLink(@RequestBody Link link) {
        return ResponseEntity.ok(linkService.criarLink(link));
    }

    @GetMapping("/link/{linkId}")
    public String redirecionarLink(@PathVariable Long linkId, @RequestHeader("senha") String senha) {
        LinkDTO linkDTO = linkService.validarURL(linkId, senha);
        return linkDTO.getUrl();
    }

    @GetMapping("/metrics/{linkId}")
    public String obterMetricas(@PathVariable Long linkId) {
        return linkService.consultarEstatistica(linkId);
    }

    @DeleteMapping("/invalidate/{linkId}")
    public String invalidarLink(@PathVariable Long linkId) {
            return linkService.excluirLink(linkId);
        }


}

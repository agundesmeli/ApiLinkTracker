package br.com.meli.apilinktracker.apilinktracker.service;

import br.com.meli.apilinktracker.apilinktracker.converter.LinkConverter;
import br.com.meli.apilinktracker.apilinktracker.dto.LinkDTO;
import br.com.meli.apilinktracker.apilinktracker.entity.Link;
import br.com.meli.apilinktracker.apilinktracker.exception.URLInvalidaException;
import br.com.meli.apilinktracker.apilinktracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private LinkRepository linkRepository;

    public LinkService() {
    }

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public LinkDTO criarLink(Link link) {
        LinkDTO linkDTO = LinkConverter.linkEntityToDTO(link);
        linkRepository.addLink(linkDTO);
        return linkDTO;
    }

    public LinkDTO validarURL(long linkId, String senha) {
        LinkDTO linkDTO = linkRepository.getLinkById(linkId);
        if(linkDTO == null || linkId == 0 || linkDTO.getLinkId() != linkId || !linkDTO.getSenha().equals(senha)) {
            throw new URLInvalidaException("Link inválido!");
        }
        linkDTO.setEstatistica(linkDTO.getEstatistica() + 1);
        return linkDTO;
    }

    public String consultarEstatistica(long linkId) {
        LinkDTO linkDTO = linkRepository.getLinkById(linkId);
        if(linkDTO == null || linkId == 0 || linkDTO.getLinkId() != linkId) {
            throw new URLInvalidaException("Link inválido!");
        }
        return "O número de vezes que esse link foi redirecionado é: " + linkDTO.getEstatistica();
    }

    public String excluirLink(long linkId) {
        LinkDTO linkDTO = linkRepository.getLinkById(linkId);
        if(linkId == 0 || linkDTO.getLinkId() != linkId) {
            throw new URLInvalidaException("Link inválido!");
        }
        linkRepository.deleteLink(linkId);
        return "A URL "+ linkDTO.getUrl() + " foi invalidada.";
    }

}

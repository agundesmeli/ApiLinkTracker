package br.com.meli.apilinktracker.apilinktracker.converter;

import br.com.meli.apilinktracker.apilinktracker.dto.LinkDTO;
import br.com.meli.apilinktracker.apilinktracker.entity.Link;
import br.com.meli.apilinktracker.apilinktracker.utils.Id;
import br.com.meli.apilinktracker.apilinktracker.utils.Senha;

import java.util.ArrayList;
import java.util.List;

public class LinkConverter {

    public static LinkDTO linkEntityToDTO(Link link) {
        LinkDTO linkDTO = new LinkDTO(link.getUrl(), Id.generateIdLink(), Senha.generateSenha());
        return linkDTO;
    }

    public static List<LinkDTO> linkEntityToDTO(List<Link> links) {
        List<LinkDTO> linkDTOS = new ArrayList<>();
        for (Link link : links) {
            linkDTOS.add(linkEntityToDTO(link));
        }
        return linkDTOS;
    }

    public static Link linkDTOToEntity(LinkDTO linkDTO) {
        Link link = new Link(linkDTO.getUrl());
        return link;
    }

    public static List<Link> linkDTOToEntity(List<LinkDTO> linksDTO) {
        List<Link> links = new ArrayList<>();
        for (LinkDTO linkDTO : linksDTO) {
            links.add(linkDTOToEntity(linkDTO));
        }
        return links;
    }
}

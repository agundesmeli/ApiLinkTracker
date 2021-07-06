package br.com.meli.apilinktracker.apilinktracker.repository;

import br.com.meli.apilinktracker.apilinktracker.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository {

    List<LinkDTO> linksDTO = new ArrayList<>();

    public void addLink(LinkDTO linkDTO) {
        linksDTO.add(linkDTO);
    }

    public List<LinkDTO> getAllLinks() {
        return linksDTO;
    }

    public LinkDTO getLinkById(Long id) {
        Optional<LinkDTO> linkDTOOptional = linksDTO
                .stream()
                .filter(link -> link.getLinkId().equals(id))
                .findAny();
        return linkDTOOptional.orElse(null);
    }


    public void deleteLink(Long id) {
        Optional<LinkDTO> linkDTOOptional = linksDTO
                .stream()
                .filter(link -> link.getLinkId().equals(id))
                .findAny();
        linkDTOOptional.ifPresent(link -> linksDTO.remove(link));
    }

}

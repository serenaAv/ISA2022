package isa.ProgettoEsame.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import isa.ProgettoEsame.model.Link;
import isa.ProgettoEsame.repository.LinkRepository;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public List < Link > getAllLinks() {
        return linkRepository.findAll();
    }

    @Override
    public void deleteLinkById(int id) {
        this.linkRepository.deleteById(id);
    }

    @Override
    public void saveLink(Link link) {
        this.linkRepository.save(link);
    }

    @Override
    public Link getLinkById(int id) {
        Optional < Link > optional = linkRepository.findById(id);
        Link link = null;
        if (optional.isPresent()) {
            link = optional.get();
        } else {
            throw new RuntimeException(" Link not found for id :: " + id);
        }
        return link;
    }

}

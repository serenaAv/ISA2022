package isa.ProgettoEsame.service;

import java.util.List;
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
}

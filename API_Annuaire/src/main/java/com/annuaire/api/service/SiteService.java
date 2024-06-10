package com.annuaire.api.service;

import com.annuaire.api.controller.model.Site;
import com.annuaire.api.repository.SiteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    public Optional<Site> getSite(final int id) {
        return siteRepository.findById(id);
    }

    public Iterable<Site> getSites() {
        return siteRepository.findAll();
    }

    public void deleteSite(final int id) {
        siteRepository.deleteById(id);
    }

    public Site updateSite(Site site) {
        Site savedSite = siteRepository.save(site);
        return savedSite;
    }

    public Site saveSite(Site site) {
        Site savedSite = siteRepository.save(site);
        return savedSite;
    }
}

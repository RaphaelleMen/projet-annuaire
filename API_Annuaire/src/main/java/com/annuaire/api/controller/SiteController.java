package com.annuaire.api.controller;


import com.annuaire.api.controller.model.Site;
import com.annuaire.api.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SiteController {

    @Autowired
    private SiteService siteService;

    @GetMapping("/sites")
    public Iterable<Site> getSites() {
        return siteService.getSites();
    }

    @GetMapping("/site/{id}")
    public Optional<Site> getSite(@PathVariable Integer id) {
        return siteService.getSite(id);
    }

    @DeleteMapping("/site/{id}")
    public void deleteSite(@PathVariable Integer id) {
        siteService.deleteSite(id);
    }


    @PutMapping("/site")
    public Site supdateSite(@RequestBody Site site)  {
        return siteService.updateSite(site);
    }

    @PostMapping("/site")
    public Site saveSite(@RequestBody Site site)  {
        return siteService.saveSite(site);
    }
}

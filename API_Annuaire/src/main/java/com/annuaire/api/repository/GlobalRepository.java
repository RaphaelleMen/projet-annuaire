package com.annuaire.api.repository;

import com.annuaire.api.controller.DepartementController;
import com.annuaire.api.controller.SiteController;
import com.annuaire.api.controller.model.Departement;
import com.annuaire.api.controller.model.Employe;
import com.annuaire.api.controller.model.Global;
import com.annuaire.api.controller.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GlobalRepository {
    @Autowired
    private SiteController siteController;

    @Autowired
    private DepartementController departementController;
    public List<Global> getAll(Iterable<Employe> employes, Integer service, Integer site) {
        List<Global> listGlobal = new ArrayList<Global>();
        for (Employe employe : employes) {
            Optional<Site> respSite = siteController.getSite(employe.getFkSite());
            Optional<Departement> respDepartement = departementController.getDepartement(employe.getFkService());
            if (service == null && site == null || service == null && site == respSite.get().getId() || service == respDepartement.get().getId() && site == null || site == respSite.get().getId() && service == respDepartement.get().getId()) {
                Global resp = new Global();
                resp.setId(employe.getId());
                resp.setNom(employe.getNom());
                resp.setPrenom(employe.getPrenom());
                resp.setTelephoneFixe(employe.getTelephoneFixe());
                resp.setTelephonePortable(employe.getTelephonePortable());
                resp.setVille(respSite.get().getVille());
                resp.setType(respSite.get().getType());
                resp.setService(respDepartement.get().getNom());
                listGlobal.add(resp);
            }
        }
        return listGlobal;
    }

}

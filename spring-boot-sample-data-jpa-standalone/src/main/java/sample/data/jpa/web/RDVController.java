package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.RDV;
import sample.data.jpa.service.RDVDAO;

@Controller
public class RDVController {

    @RequestMapping(value = "/create-rdv", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody RDV rdv) {
        String userId = "";
        try {
            rdvdao.save(rdv);
            userId = String.valueOf(rdv.getId());
        }
        catch (Exception ex) {
            return "Error creating the RDV: " + ex.toString();
        }
        return "RDV succesfully created with id = " + userId;
    }

    @RequestMapping(value = "/rdv/{RdvId}", method = RequestMethod.GET)
    @ResponseBody
    public String get(@PathVariable("RdvId") Long id) {
        try {
            RDV r = rdvdao.getReferenceById(id);
            return r.getName();
        }
        catch (Exception ex) {
            return "Error creating the RDV: " + ex.toString();
        }
    }

    @RequestMapping(value = "/delete-rdv", method = RequestMethod.DELETE)
    @ResponseBody
    public String create(@RequestParam Long id) {
        try {
            rdvdao.deleteById(id);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "RDV succesfully deleted";
    }

    @RequestMapping(value = "/update-rdv/{RdvId}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody RDV rdv, @PathVariable("RdvId") Long rdvId) {
        try {
            RDV r = rdvdao.getReferenceById(rdvId);
            if (rdv.getClient() != null) {
                r.setClient(rdv.getClient());
            }
            if (rdv.getProfessional() != null) {
                r.setProfessional(rdv.getProfessional());
            }
            if (rdv.getStart_time() != null) {
                r.setStart_time(rdv.getStart_time());
            }
            r.setReserved(rdv.isReserved());
            rdvdao.save(r);
        }
        catch (Exception ex) {
            return "Error updating the RDV: " + ex.toString();
        }
        return "RDV succesfully updated with id = " + rdvId;
    }

    @Autowired
    RDVDAO rdvdao;
}

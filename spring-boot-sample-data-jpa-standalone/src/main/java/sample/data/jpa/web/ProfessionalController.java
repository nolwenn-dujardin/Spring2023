package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Professional;
import sample.data.jpa.service.ProfessionalDAO;

@Controller
public class ProfessionalController {
    @Autowired
    private ProfessionalDAO proDao;

    /**
     * POST /create  --> Create a new user and save it in the database.
     */
    @RequestMapping(value = "/create-pro", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Professional pro) {
        String userId = "";
        try {
            proDao.save(pro);
            userId = String.valueOf(pro.getId());
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }

    /**
     * PUT /update  --> Update the email and the name for the user in the
     * database having the passed id.
     */
    @RequestMapping(value = "/update-pro", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@RequestParam long id, @RequestParam String email, @RequestParam String name) {
        try {
            Professional pro = proDao.findById(id).get();
            pro.setEmail(email);
            pro.setName(name);
            proDao.save(pro);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }
}

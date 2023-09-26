package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Client;
import sample.data.jpa.service.ClientDAO;
import sample.data.jpa.service.UserDao;

@Controller
public class ClientController {

    @Autowired
    private ClientDAO clientDao;

    /**
     * POST /create  --> Create a new user and save it in the database.
     */
    @RequestMapping(value = "/create-client", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Client client) {
        String userId = "";
        try {
            clientDao.save(client);
            userId = String.valueOf(client.getId());
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
    @RequestMapping(value = "/update-client", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@RequestParam long id, @RequestParam String email, @RequestParam String name) {
        try {
            Client client = clientDao.findById(id).get();
            client.setEmail(email);
            client.setName(name);
            clientDao.save(client);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }
}

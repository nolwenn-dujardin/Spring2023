package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import sample.data.jpa.domain.User;
import sample.data.jpa.service.UserDao;

@Controller
public class UserController {

  /**
   * POST /create  --> Create a new user and save it in the database.
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ResponseBody
  public String create(@RequestBody User user) {
    String userId = "";
    try {
      userDao.save(user);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created with id = " + userId;
  }
  
  /**
   * DELETE /delete  --> Delete the user having the passed id.
   */
  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  @ResponseBody
  public String delete(@RequestParam long id) {
    System.out.println("DELETE USER WITH ID : "+id);
    try {
      userDao.deleteById(id);
    }
    catch (Exception ex) {
      return "Error deleting the user:" + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * GET /get-by-email  --> Return the id for the user having the passed
   * email.
   */
  @RequestMapping(value = "/get-by-email/{email}", method = RequestMethod.GET)
  @ResponseBody
  public String getByEmail(@PathVariable("email") String email) {
    String userId = "";
    try {
      User user = userDao.findByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }
  
  /**
   * PUT /update  --> Update the email and the name for the user in the
   * database having the passed id.
   */
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  @ResponseBody
  public String updateUser(@RequestParam long id, @RequestParam String email, @RequestParam String name) {
    try {
      User user = userDao.findById(id).get();
      user.setEmail(email);
      user.setName(name);
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  }

  // Private fields

  @Autowired
  private UserDao userDao;
  
}
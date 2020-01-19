package com.controller;

import com.model.CatEntity;
import com.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class CatController {
    private CatService service;
    @Autowired(required = true)
    @Qualifier(value = "service")
    public void setService(CatService service) {
        this.service = service;
    }
    @SuppressWarnings("unchecked")
    @RequestMapping(value = {"index", "/"}, method = GET)
    public ModelAndView main(Model model){
        model.addAttribute("cat", new CatEntity());
        model.addAttribute("catList", service.showCat());
        return new ModelAndView("index");
    }
    @RequestMapping(value = "/add", method = GET)
    public ModelAndView addCat(@ModelAttribute("cat") CatEntity cat) {
        service.addCat(cat);
        return new ModelAndView("redirect:/index");
    }
    @RequestMapping(value = "/delete/{id}", method = GET)
    public ModelAndView deleteCat(@PathVariable("id") int id){
        service.deleteCat(id);
        return new ModelAndView("redirect:/index");
    }
    @RequestMapping(value = "/edit/{id}", method = GET)
    public String editCat(@PathVariable("id") int id, Model model){
        model.addAttribute("cat", service.searchCat(id));
        return "edit";
    }
    @RequestMapping(value = "/edit", method = GET)
    public ModelAndView editCat(@ModelAttribute("cat") CatEntity cat){
        service.editCat(cat);
        return new ModelAndView("redirect:/index");
    }


    @RequestMapping(value = "/login", method = GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;
    }
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }

        return error;
    }
}
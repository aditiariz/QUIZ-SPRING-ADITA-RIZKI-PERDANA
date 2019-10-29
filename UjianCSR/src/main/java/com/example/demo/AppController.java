package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
 
    @Autowired
    private CsrService service;
     
    // handler methods...
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Tblprogramcsr> listCsr = service.listAll();
        model.addAttribute("listcsrs", listCsr);
         
        return "index";
    }
    
    @RequestMapping("/new")
    public String showNewcsrPage(Model model) {
        Tblprogramcsr tblprogramcsr = new Tblprogramcsr();
        model.addAttribute("tblprogramcsr", tblprogramcsr);
         
        return "new_csr";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updatecsr(@ModelAttribute("tblprogramcsr") Tblprogramcsr tblprogramcsr) {
        service.save(tblprogramcsr);
         
        return "redirect:/";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCsr(@ModelAttribute("tblprogramcsr") Tblprogramcsr tblprogramcsr) {
        service.save(tblprogramcsr);
         
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCsrPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_csr");
        Tblprogramcsr tblprogramcsr = service.get(id);
        mav.addObject("tblprogramcsr", tblprogramcsr);
         
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteCsr(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";       
    }
   
}


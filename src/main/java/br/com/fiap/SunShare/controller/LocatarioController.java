package br.com.fiap.SunShare.controller;

import br.com.fiap.SunShare.domainmodel.Locatario;
import br.com.fiap.SunShare.service.LocatarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/locatario")
public class LocatarioController {

    @Autowired
    private LocatarioServiceImpl service;

    @GetMapping("/viewAll")
    public String viewAsList(Model model) {
        List<Locatario> locatarioList = this.service.findAllLocatarios();
        model.addAttribute("allLocatarioList", locatarioList);
        return "listLocatario";
    }

    @GetMapping("/addNew")
    public String addNew(Model model) {
        Locatario locatario = new Locatario();
        model.addAttribute("locatario", locatario);
        return "newLocatario";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("locatario") Locatario locatario) {
        this.service.save(locatario);
        return "redirect:/locatario/viewAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable("id") Long id) {
        this.service.deleteById(id);
        return "redirect:/locatario/viewAll";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        Optional<Locatario> locatario = this.service.findById(id);
        if(locatario.isPresent()) {
            model.addAttribute("locatario", locatario.get());
        }
        else
            System.out.println("Locatario not found");
        return "updateLocatario";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("locatario") Locatario locatario) {
        this.service.save(locatario);
        return "redirect:/locatario/viewAll";
    }

    @GetMapping("/show/{id}")
    public String show( @PathVariable("id") Long id, Model model){
        Optional<Locatario> locatario = this.service.findById(id);

        if( locatario.isPresent() )
            model.addAttribute("locatario", locatario.get());
        else
            System.out.println("Locatario not found");
        return "showLocatario";
    }
}

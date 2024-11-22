package br.com.fiap.SunShare.controller;

import br.com.fiap.SunShare.domainmodel.Locador;
import br.com.fiap.SunShare.service.LocadorServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/locador")
public class LocadorController {

    @Autowired
    private @Setter LocadorServiceImpl service;

    @GetMapping("/viewAll")
    public String viewAsList(Model model) {
        List<Locador> locadorList = this.service.findAllLocadores();
        model.addAttribute("allLocadorList", locadorList);
        return "listLocador";
    }

    @GetMapping("/addNew")
    public String addNew(Model model) {
        Locador locador = new Locador();
        model.addAttribute("locador", locador);
        return "newLocador";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("locador") Locador locador) {
        this.service.save(locador);
        return "redirect:/locador/viewAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable("id") Long id) {
        this.service.deleteById(id);
        return "redirect:/locador/viewAll";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        Optional<Locador> locador = this.service.findById(id);
        if(locador.isPresent()) {
            model.addAttribute("locador", locador.get());
        }
        else
            System.out.println("Locador not found");
        return "updateLocador";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("locador") Locador locador) {
        this.service.save(locador);
        return "redirect:/locador/viewAll";
    }

    @GetMapping("/show/{id}")
    public String show( @PathVariable("id") Long id, Model model){
        Optional<Locador> locador = this.service.findById(id);

        if( locador.isPresent() )
            model.addAttribute("locador", locador.get());
        else
            System.out.println("Locador not found");
        return "showLocador";
    }
}

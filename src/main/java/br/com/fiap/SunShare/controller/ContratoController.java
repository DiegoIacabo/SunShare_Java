package br.com.fiap.SunShare.controller;

import br.com.fiap.SunShare.domainmodel.Contrato;
import br.com.fiap.SunShare.service.ContratoServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/contrato")
public class ContratoController {

    @Autowired
    private @Setter ContratoServiceImpl service;

    @GetMapping("/viewAll")
    public String viewAsList(Model model) {
        List<Contrato> contratoList = this.service.findAllContratos();
        model.addAttribute("allContratoList", contratoList);
        return "listContrato";
    }

    @GetMapping("/addNew")
    public String addNew(Model model) {
        Contrato contrato = new Contrato();
        model.addAttribute("contrato", contrato);
        return "newContrato";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("contrato") Contrato contrato) {
        this.service.save(contrato);
        return "redirect:/contrato/viewAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable("id") Long id) {
        this.service.deleteById(id);
        return "redirect:/contrato/viewAll";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        Optional<Contrato> contrato = this.service.findById(id);
        if(contrato.isPresent()) {
            model.addAttribute("contrato", contrato.get());
        }
        else
            System.out.println("Contrato not found");
        return "updateContrato";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("contrato") Contrato contrato) {
        this.service.save(contrato);
        return "redirect:/contrato/viewAll";
    }

    @GetMapping("/show/{id}")
    public String show( @PathVariable("id") Long id, Model model){
        Optional<Contrato> contrato = this.service.findById(id);

        if( contrato.isPresent() )
            model.addAttribute("contrato", contrato.get());
        else
            System.out.println("Contrato not found");
        return "showContrato";
    }
}

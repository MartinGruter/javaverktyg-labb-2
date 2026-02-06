package se.iths.martin.javaverktyglabb2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.iths.martin.javaverktyglabb2.service.ATMService;

@RequestMapping("/balance")
@Controller
public class BalanceController {
    private ATMService atmService;

    public BalanceController(ATMService atmService) {
        this.atmService = atmService;
    }

    //    @RequestMapping("/")
    @GetMapping
    public String balance(Model model) {
        model.addAttribute("balance", atmService.getBalance());
        return "balance";

    }
}

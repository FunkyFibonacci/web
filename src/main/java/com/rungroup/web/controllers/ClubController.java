package com.rungroup.web.controllers;

import com.rungroup.web.services.ClubServices;
import com.rungroup.web.services.dto.ClubDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClubController {
    private ClubServices clubServices;

    @Autowired
    public ClubController(ClubServices clubServices) {
        this.clubServices = clubServices;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model){
        List<ClubDto> clubs = clubServices.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }
}

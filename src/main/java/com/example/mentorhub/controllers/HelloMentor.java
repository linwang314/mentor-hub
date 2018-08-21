package com.example.mentorhub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "mentor")
public class HelloMentor {

    static ArrayList<String> mentors = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("mentors", mentors);
        model.addAttribute("title","Hello Mentors");
        return "mentor/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddMentorForm(Model model) {
        model.addAttribute("title","Add Mentor");
        return "mentor/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddMentorForm(@RequestParam String mentorName) {
        mentors.add(mentorName);
        return "redirect:"; // redirect to /mentor
    }
}

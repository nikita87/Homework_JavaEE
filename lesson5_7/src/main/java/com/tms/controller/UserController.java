package com.tms.controller;

import com.tms.dao.PcGameDao;
import com.tms.dao.UserDao;
import com.tms.model.PcGame;
import com.tms.model.User;
import com.tms.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PcGameDao pcGameDao;

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/user_page")
    public String userPage(Model model){
        model.addAttribute("pcgames", pcGameDao.findAllPcGames());
        return "user_page";
    }

    @GetMapping(value = "/registration")
    public String registration(Model model){
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String doRegistration(Model model, User newUser, BindingResult bindingResult){
        userValidator.validate(newUser, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "../../error";
        }
        userDao.addUser(newUser);
        return "user_page";
    }

    @GetMapping(value = "/admin_page")
    public String adminPage(){
        return "admin_page";
    }

    @GetMapping(value = "/admin_pcgame_info")
    public String adminPcGameInfo(Model model){
        model.addAttribute("pcgames", pcGameDao.findAllPcGames());
        return "admin_pcgame_info";
    }

   @PostMapping(value = "/admin_pcgame_info")
    public String addPcGameInfo(PcGame newPcGame){
       pcGameDao.addPcGame(newPcGame);
       return "redirect:/admin_pcgame_info";
    }

   @GetMapping(value = "/admin_pcgame_info/{id}")
    public String deletePcGameInfo(@PathVariable("id") int pcGameId){
        pcGameDao.deletePcGameById(pcGameId);
        return "redirect:/admin_pcgame_info";
    }

    @GetMapping(value = "/admin_user_info")
    public String adminUserInfo(Model model){
        model.addAttribute("users", userDao.findAllUsers());
        return "admin_user_info";
    }

    @GetMapping(value = "/admin_user_info/{id}")
    public String deleteUserInfo(@PathVariable("id") int userId){
        userDao.deleteUser(userId);
        return "redirect:/admin_user_info";
    }
}

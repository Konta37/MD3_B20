package md3.demo.controller;

import md3.demo.model.entity.Account;
import md3.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping("homePage")
//    public String homePage(@ModelAttribute("ac") Account ac, Model model) {
//        model.addAttribute("ac", ac);
//        return "homePage";
//    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, Model model) {
        Account account = accountService.login(username, password);
        if (account != null) {
            session.setAttribute("user", account);
            return "redirect:/homePage";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "index";
        }
    }

    @GetMapping("/homePage")
    public String homePage(HttpSession session, Model model) {
        Account account = (Account) session.getAttribute("user");
        if (account != null) {
            model.addAttribute("greeting", "Xin chào " + account.getFullName());
        } else {
            model.addAttribute("greeting", "You are not logged in");
        }
        return "homePage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}

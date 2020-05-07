package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Repository.IStudentRepository;
import com.example.demo.Repository.StudentRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private IStudentRepository studentRepository;

    public MainController() {
        studentRepository = new StudentRepositoryImpl();
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("students" , studentRepository.readAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreatePage(){
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Student student){
        studentRepository.create(student);
        return "redirect:/";
    }

    @GetMapping("/details")
    public String getStudentByParameter(@RequestParam int id, Model model) {
        model.addAttribute("student" , studentRepository.read(id));
        return "details";
    }








}
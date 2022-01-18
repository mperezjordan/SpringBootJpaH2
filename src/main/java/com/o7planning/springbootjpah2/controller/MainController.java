package com.o7planning.springbootjpah2.controller;


import com.o7planning.springbootjpah2.dao.PersonDAO;
import com.o7planning.springbootjpah2.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private PersonDAO personDAO;

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        Iterable<Person> all = personDAO.findAll();

        StringBuilder sb = new StringBuilder();

        all.forEach(p -> sb.append(p.getFullName() + "<br>"));

        return sb.toString();
    }
}

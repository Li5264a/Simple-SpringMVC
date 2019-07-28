package com.lk.spring.controllers;

import com.lk.spring.beans.AutoWired;
import com.lk.spring.service.SalaryService;
import com.lk.spring.web.mvc.Controller;
import com.lk.spring.web.mvc.RequestMapping;
import com.lk.spring.web.mvc.RequestParam;

@Controller
public class SalaryController {
    @AutoWired
    private SalaryService salaryService;

    @RequestMapping("/get_salary.json")
    public Integer getSalary(@RequestParam("name") String name, @RequestParam("experience") String experience) {
        return salaryService.calSalary(Integer.parseInt(experience));
    }
}

package com.example.financeapp.controller;

import com.example.financeapp.model.Loan;
import com.example.financeapp.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@Controller
public class employeeController{

    @Autowired
    private LoanService loanService;



        @PostMapping("/newapplist")
        public String home( Model model, HttpServletRequest request,
                           @RequestParam (value = "pageNo") int pageNo,
                           @RequestParam(value ="sortField") String sortField,
                           @RequestParam(value ="sortDir") String sortDir) {



            if (request.getSession().getAttribute("userid") != null) {
                String checkSession = String.valueOf(
                        request.getSession().getAttribute("userid"));
                model.addAttribute("Session", checkSession);
            }

            int pageSize = 5;
            System.out.println(pageNo);
            System.out.println(sortField);
            System.out.println(sortDir);

            Page<Loan> page = loanService.findPaginated(pageNo, pageSize, sortField, sortDir);
            List<Loan> LoanList = page.getContent();

            model.addAttribute("currentPage", pageNo);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalItems", page.getTotalElements());

            model.addAttribute("sortField", sortField);
            model.addAttribute("sortDir", sortDir);
            model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

            model.addAttribute("LoanList", LoanList);


            return "employee_newapp";
        }


}

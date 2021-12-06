package com.example.financeapp.controller;

import com.example.financeapp.model.Loan;
import com.example.financeapp.repository.LoanRepository;
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
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Controller
public class employeeController{

    @Autowired
    private LoanService loanService;

    @Autowired
    private LoanRepository loanRepository;


    @GetMapping("/employee_main")
        public String empMain(Model model, HttpServletRequest request){


            if (request.getSession().getAttribute("userid") != null) {
                String checkSession = String.valueOf(
                        request.getSession().getAttribute("userid"));
                model.addAttribute("Session", checkSession);
            }
            return "employee_main";
        }
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
        @GetMapping("/employee_app_detail_con/{loanNum}")
        public String emp_app_detail(Model model, HttpServletRequest request,
                                     @PathVariable(value = "loanNum") String loanNum1
                                     ){
            if (request.getSession().getAttribute("userid") != null) {
                String checkSession = String.valueOf(
                        request.getSession().getAttribute("userid"));
                model.addAttribute("Session", checkSession);
            }

            Long loanNum = Long.valueOf(Integer.parseInt(loanNum1));
            System.out.println(loanNum);
            Loan loan = this.loanService.getLoanById(loanNum);
            String cusAddFull = loan.getCusAddress1() + "," + loan.getCusAddress2() + "," + loan.getCusCity() + "," +
                    loan.getCusRegion() + "," + loan.getCusState() + "," + loan.getCusZip();
            System.out.println(cusAddFull);



            model.addAttribute("loan", loan);
            model.addAttribute("cusAddFull", cusAddFull);



            return "employee_app_detail";
        }
        @GetMapping("/statusUpdate")
    String updateStatus(HttpServletRequest request, Model model,
                        @RequestParam(value = "status") String status ,
                        @RequestParam(value = "cusID") String cusID,
                        @RequestParam(value = "loan_num") String loan_num1

        ){
            if (request.getSession().getAttribute("userid") != null) {
                String checkSession = String.valueOf(
                        request.getSession().getAttribute("userid"));
                model.addAttribute("Session", checkSession);
            }
            Long loan_num = Long.valueOf(Integer.parseInt(loan_num1));
            this.loanRepository.updateStatus(status,loan_num,cusID);
            System.out.println("Updated");
            return "/employee_main";
        }


}

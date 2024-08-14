package com.multi.spring2.finance.controller;

import com.multi.spring2.finance.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/finance")
public class FinanceController {

    private static final Logger log = LoggerFactory.getLogger(FinanceController.class);

    @GetMapping
    public String finance(Model model) {

        return "finance/finance";
    }

    @PostMapping("/loan")
    @ResponseBody
    public String applyForLoan(@RequestBody LoanApplication application) {
        // Process the loan application
        System.out.println(application);
        return "컨트롤러에서 받은 데이터: " + application.getApplicantName();
    }

    @GetMapping("/loanStatus")
    @ResponseBody
    public LoanStatus getLoanStatus(@RequestParam("loanId") String loanId) {
        // Mock loan status
        LoanStatus status = new LoanStatus();
        status.setLoanId(loanId);
        status.setStatus("Approved");
        return status;
    }

    @GetMapping("/balance")
    public String getBalance(@RequestParam("accountId") String accountId, Model model) {
        if (accountId.equals("")) {
            throw new IllegalArgumentException("Account ID is required");
        }
        System.out.println(accountId);
        model.addAttribute("balance", "9999"); // Mock balance
        return "finance/balance";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleException(IllegalArgumentException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "finance/error";
    }

    /*
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Double.class,
                new CustomNumberEditor(Double.class, true));
    }

     */

    @GetMapping("/transfer")
    public String transferForm(Model model) {
        model.addAttribute("transfer", new Transfer());
        return "finance/transferForm";
    }

    @PostMapping("/transfer")
    public String submitTransfer(Transfer transfer, Model model) {
        model.addAttribute("transfer", transfer);
        return "finance/transferConfirmation";
    }
}


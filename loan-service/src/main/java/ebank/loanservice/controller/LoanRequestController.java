package ebank.loanservice.controller;

import ebank.loanservice.model.Loan;
import ebank.loanservice.service.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("loan")
public class LoanRequestController {

    @Autowired
    private LoanServiceImpl loanRequestService;

    @PostMapping(value = "/request/add")
    @ResponseBody
    public ResponseEntity addLoanRequest(@RequestBody Loan loan) {
        try {
            return ResponseEntity.ok(loanRequestService.addLoan(loan));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Couldn't submit please try again or contact your agency");
        }
    }

    @GetMapping(value = "/request/get-all")
    @ResponseBody
    public ResponseEntity consultLoanRequest() {
        try {
            return ResponseEntity.ok("OKislem");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Couldn't get loan request please try again or contact your agency");
        }
    }
/*
    @GetMapping(value = "/request/get-all")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity consultLoanRequest() {
        try {
            return ResponseEntity.ok(loanRequestService.getAllLoanRequest());
        } catch (Exception e) {
            log.info("There was an error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Couldn't get loan request please try again or contact your agency");
        }
    }

    @PutMapping(value = "/request/cancel/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity cancelLoanRequest(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(loanRequestService.cancelLoanRequest(id));
        } catch (Exception e) {
            log.info("There was an error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Couldn't cancel loan request please try again or contact your agency");
        }
    }
    */
}
package ebank.loanservice.service;

import ebank.loanservice.model.Loan;
import ebank.loanservice.repository.LoanRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanServiceImpl  {

  @Autowired
    private LoanRepository loanRepository;

    public String addLoan(Loan loan) {

        Loan loanObject = loanRepository.save(loan);

        return "Loan request submitted successfully" ;
    }

    public List<Loan> getAllLoan() {
            return loanRepository.findAll();

    }

/*    public String cancelLoan(Long id) {
        Loan loan = LoanRepository.findById(id).get();
        loan.setLoanStatus("CANCELED");
        loanRepository.save(loan);
        return "Loan request has been canceled successfully";
    }*/
}

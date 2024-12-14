package main.com.library.controller;


import main.com.library.entity.Loan;
import main.com.library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping("/borrow")
    public ResponseEntity<Loan> borrowBook(@RequestParam Long memberId, @RequestParam Long bookId) {
        Loan loan = loanService.borrowBook(memberId, bookId);
        return ResponseEntity.ok(loan);
    }

    @PostMapping("/return")
    public ResponseEntity<Loan> returnBook(@RequestParam Long loanId) {
        Loan loan = loanService.returnBook(loanId);
        return ResponseEntity.ok(loan);
    }
}
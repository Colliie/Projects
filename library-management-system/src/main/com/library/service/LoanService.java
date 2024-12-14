package main.com.library.service;


import main.com.library.entity.Book;
import main.com.library.entity.Loan;
import main.com.library.entity.Member;
import main.com.library.repository.BookRepository;
import main.com.library.repository.LoanRepository;
import main.com.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.time.LocalDate;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Loan borrowBook(Long memberId, Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getCopiesAvailable() <= 0) {
            throw new RuntimeException("No copies available");
        }

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setMember(member);
        loan.setLoanDate(LocalDate.now());
        loan.setStatus("Issued");

        book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        bookRepository.save(book);

        return loanRepository.save(loan);
    }

    public Loan returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if ("Returned".equals(loan.getStatus())) {
            throw new RuntimeException("Book already returned");
        }

        Book book = loan.getBook();
        book.setCopiesAvailable(book.getCopiesAvailable() + 1);
        bookRepository.save(book);

        loan.setReturnDate(LocalDate.now());
        loan.setStatus("Returned");
        return loanRepository.save(loan);
    }
}


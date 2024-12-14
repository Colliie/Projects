package main.com.library.repository;



import main.com.library.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    // Find all loans by member ID
    List<Loan> findByMemberId(Long memberId);

    // Find all loans by book ID
    List<Loan> findByBookId(Long bookId);

    // Find all active loans (status = "Issued")
    List<Loan> findByStatus(String status);
}

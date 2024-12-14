package main.com.library.repository;



import main.com.library.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Custom query methods (if needed) can be added here
    // Example:
    // Optional<Member> findByEmail(String email);
}

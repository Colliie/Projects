package main.com.library.repository;



import main.com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Find books by title containing a keyword (case-insensitive)
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Find books by author containing a keyword (case-insensitive)
    List<Book> findByAuthorContainingIgnoreCase(String author);

    // Find books with available copies greater than 0
    List<Book> findByCopiesAvailableGreaterThan(int copies);
}

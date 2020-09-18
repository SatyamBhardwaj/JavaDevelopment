package org.geeksforgeeks.jbdl7.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.IdClass;
import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, IdClass> {

    @Query("select b from Book b where b.authorName=:author")
    List<Book> findBooksByAuthor(String author);

    @Query(value = "select * from Book b where b.authorName=:name_of_author", nativeQuery = true)
    List<Book> findBookByAuthorSQL(String name_of_author);


    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.authorName = :newauthor where b.authorName = :authorrep")
    int UpdateAuthor(@Param("authorrep") String authorrep, @Param("newauthor") String newauthor);

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.cost > 1000")
    int deletebook();


}

package TP1demo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentEntityRepository extends JpaRepository<Student,Integer> {
    public Optional<Student> findById(Integer id);
    public Optional<Student> findByEmail(String email);
    public Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);

    public List<Student> findAllByLastNameIgnoreCase(String lastname);

    List<Student> findByAgeLessThan(Integer age);

    @Modifying
    @Transactional
    @Query("update Student s set s.email = :newMail where s.email = :oldMail")
    public void updateEmail(@Param("oldMail") String oldmail, @Param("newMail") String newmail);
}

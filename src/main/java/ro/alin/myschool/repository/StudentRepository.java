package ro.alin.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.alin.myschool.dto.StudentDto;
import ro.alin.myschool.model.Student;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query(value="SELECT student.* FROM student INNER JOIN app_user on student.app_user_id = app_user.id ", nativeQuery = true)
    Optional<List<Student>> findByAppUserId(Long id);
    // TODO metoda trebuie sa intoarca doar o entitate. in db trebuie pus unicitate pe relatie
}

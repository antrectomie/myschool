package ro.alin.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.alin.myschool.model.Student;

import java.awt.print.Book;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

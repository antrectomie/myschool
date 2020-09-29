package ro.alin.myschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentGradeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_student_grade_book_gen")
//    @SequenceGenerator(name = "seq_student_grade_book_gen", sequenceName = "seq_student_grade_book", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
   @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String grade;

    private LocalDateTime registeredAt;

}

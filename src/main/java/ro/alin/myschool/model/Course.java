package ro.alin.myschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course extends AbstractAuditable{

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_course_gen")
//    @SequenceGenerator(name = "seq_course_gen", sequenceName = "seq_course", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String year;


//    @OneToMany(mappedBy = "course")
//    private Set<StudentGradeBook> studentGradeBooks;
}

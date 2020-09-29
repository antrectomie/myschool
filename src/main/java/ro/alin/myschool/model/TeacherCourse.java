package ro.alin.myschool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TeacherCourse {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_teacher_course_gen")
//    @SequenceGenerator(name = "seq_teacher_course_gen", sequenceName = "seq_teacher_course", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;




}

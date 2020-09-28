package ro.alin.myschool.model;

import javax.persistence.*;
import java.time.LocalDateTime;

public class LessonTeacherCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Course student;

    private LocalDateTime createdAt;


}

package ro.alin.myschool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.alin.myschool.enums.Generation;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student extends AbstractAuditable{
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String birthYear;
    private Generation generation;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId             //PK-ul din appUser va fi PK, FK in student
    @JoinColumn(name = "id")
    private AppUser appUser;

    @ManyToOne
    private Classroom classroom;

//    @OneToMany(mappedBy = "student")
//    @MapsId
//    private Set<StudentGradeBook> studentGradeBooks;

}

package ro.alin.myschool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher extends AbstractAuditable{

//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_teacher_gen")
//    @SequenceGenerator(name = "seq_teacher_gen", sequenceName = "seq_teacher", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private AppUser appUser;
}

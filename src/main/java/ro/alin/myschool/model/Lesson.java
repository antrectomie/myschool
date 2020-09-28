package ro.alin.myschool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lesson extends AbstractAuditable{
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lesson_gen")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
}

package ro.alin.myschool.dto;

import lombok.Builder;
import lombok.Data;
import ro.alin.myschool.enums.Generation;

import java.time.LocalDateTime;

@Builder
@Data
public class StudentDto {
    private Long id;
    private String name;
    private String birthYear;
    private Generation generation;
    private Long userId;
    private Long classroom;
    private LocalDateTime createAt;
    private String createBy;
    private LocalDateTime updateAt;
    private String updateBy;
}

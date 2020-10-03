package ro.alin.myschool.mapper;


import ro.alin.myschool.dto.StudentDto;
import ro.alin.myschool.enums.Generation;
import ro.alin.myschool.model.AppUser;
import ro.alin.myschool.model.Classroom;
import ro.alin.myschool.model.Student;

public class StudentMapper {

    public static StudentDto entityToDto(Student student, Long userId){
        return
                StudentDto.builder()
                        .id(student.getId())
                        .name(student.getName())
                        .birthYear(student.getBirthYear())
                        .generation(student.getGeneration())
                        .userId(userId)
                        .createBy(student.getCreatedBy())
                        .updateBy(student.getLastUpdateBy())
                        .createAt(student.getCreated())
                        .updateAt(student.getLastUpdate())
                        .build();
    }

    public static Student dtoToEntity(StudentDto studentDto){
        return Student.builder()
                .name(studentDto.getName())
                .birthYear(studentDto.getBirthYear())
                .generation(studentDto.getGeneration())
                .build();
    }
}

package ro.alin.myschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.alin.myschool.enums.Generation;
import ro.alin.myschool.mapper.StudentMapper;
import ro.alin.myschool.model.Student;
import ro.alin.myschool.service.StudentService;

@SpringBootApplication
public class MyschoolApplication implements CommandLineRunner {
    @Autowired
    StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(MyschoolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Thread.sleep(4000);
//        Student st = new Student(null, "alin", "2345", Generation.FIRST_YEAR, null, null);
//        studentService.saveStudent(StudentMapper.entityToDto(st, null));
    }
}

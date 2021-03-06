package ro.alin.myschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.alin.myschool.dto.StudentDto;
import ro.alin.myschool.model.Student;
import ro.alin.myschool.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDto>getStudentById(@PathVariable Long id){
        StudentDto studentDto = studentService.getStudentById(id);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudentDto = studentService.saveStudent(studentDto);

        return new ResponseEntity<StudentDto>(savedStudentDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent();
    }

}

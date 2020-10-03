package ro.alin.myschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.alin.myschool.dto.StudentDto;
import ro.alin.myschool.model.Student;
import ro.alin.myschool.service.StudentService;
import ro.alin.myschool.userManagement.MyUserDetails;

@RestController
@RequestMapping("/security")
public class LoginController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/principal")
    public ResponseEntity<?> login(@AuthenticationPrincipal MyUserDetails userDetails){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        StudentDto studentDto = studentService.getStudentById(1L);
        System.out.println("aiurea");
        return new ResponseEntity<Student>(new Student(), HttpStatus.OK);
    }
}

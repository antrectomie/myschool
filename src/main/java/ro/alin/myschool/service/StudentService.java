package ro.alin.myschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ro.alin.myschool.dto.StudentDto;
import ro.alin.myschool.exceptions.WrongParameter;
import ro.alin.myschool.mapper.StudentMapper;
import ro.alin.myschool.model.AppUser;
import ro.alin.myschool.model.Student;
import ro.alin.myschool.repository.StudentRepository;
import ro.alin.myschool.userManagement.db.Role;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class StudentService {

    private StudentRepository studentRepository;
    private AppUserService appUserService;

    @Autowired
    public StudentService(StudentRepository studentRepository, AppUserService appUserService) {
        this.studentRepository = studentRepository;
        this.appUserService = appUserService;
    }

    public StudentDto getStudentById(Long id){
//        AppUser appUser = appUserService.getUserByStudentId(id);
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Didn't find student with id: " + id));
        return StudentMapper.entityToDto(student, null);
    }

    public StudentDto saveStudent(StudentDto studentDto) {
        if(studentDto.getUserId() == null) {
            throw new WrongParameter("userId from StudentDto is null");
            }
        AppUser loggedInUser = appUserService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Student student = StudentMapper.dtoToEntity(studentDto);
        student.setAppUser(loggedInUser);
        Student savedStudent = studentRepository.save(student);
        loggedInUser.getRoles().add(new Role(4L,"STUDENT"));

        return StudentMapper.entityToDto(savedStudent, loggedInUser.getId());
    }

    public void deleteStudent() {
        //TODO de vazut daca stergem sau mutam in alt tabel
        //TODO daca stergem trebuie vazut daca se propaga si in user--nu vrem sa stergem si contul
    }

    public StudentDto getStudentByUserId(Long userId) {
        List<Student> students;
        if(userId != null) {
            students = studentRepository.findByAppUserId(userId).orElseThrow(() ->
                    new EntityNotFoundException("No student associated with user id: " + userId));
        }else{
            throw new WrongParameter(" wrong userId parameter");
        }
        return StudentMapper.entityToDto(students.get(0), userId);
    }
}

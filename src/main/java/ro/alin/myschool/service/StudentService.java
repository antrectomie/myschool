package ro.alin.myschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ro.alin.myschool.dto.StudentDto;
import ro.alin.myschool.mapper.StudentMapper;
import ro.alin.myschool.model.AppUser;
import ro.alin.myschool.model.Student;
import ro.alin.myschool.repository.StudentRepository;


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
        Student student = studentRepository.findById(id).orElseThrow(() -> new NullPointerException("Didn't find student with id: " + id));
        return StudentMapper.entityToDto(student, null);
    }

    public StudentDto saveStudent(StudentDto studentDto) {
        if(studentDto.getUserId() == null)
            {throw new NullPointerException("userId from StudentDto is null");}
//        AppUser appUser = appUserService.getUserById(studentDto.getUserId());
        AppUser appUser = appUserService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Student student = StudentMapper.dtoToEntity(studentDto);
        student.setAppUser(appUser);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.entityToDto(savedStudent, appUser);
    }

    public void deleteStudent() {
        //TODO de vazut daca stergem sau mutam in alt tabel
        //TODO daca stergem trebuie vazut daca se propaga si in user--nu vrem sa stergem si contul
    }
}

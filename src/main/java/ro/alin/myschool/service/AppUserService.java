package ro.alin.myschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.alin.myschool.model.AppUser;
import ro.alin.myschool.repository.AppUserRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser getUserByStudentId(Long studentId){
        return appUserRepository.findByStudentId(studentId).orElseThrow(() ->
                new NullPointerException("Didn't find user with id: " + studentId));
    }

    public AppUser getUserById(Long id) {
        return appUserRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Didn't find associated user with id: " + id));
    }


    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public AppUser getUserByUsername(String username) {
        return appUserRepository.findByUsername(username).orElseThrow(
                () -> new NullPointerException("Didn't find appUser with username: " + username));
    }
}

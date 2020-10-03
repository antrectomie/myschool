package ro.alin.myschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.alin.myschool.exceptions.UserNotUniqueException;
import ro.alin.myschool.exceptions.WrongParameter;
import ro.alin.myschool.model.AppUser;
import ro.alin.myschool.repository.AppUserRepository;
import ro.alin.myschool.userManagement.db.Role;

import javax.persistence.EntityNotFoundException;

import java.util.Optional;

@Transactional
@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser getUserByStudentId(Long studentId){
        return appUserRepository.findByStudentId(studentId).orElseThrow(() ->
                new NullPointerException("Didn't find user with id: " + studentId));
    }

    public AppUser getUserById(Long id) {
        System.out.println("BCRYPT AFISAT: " + bCryptPasswordEncoder);
        return appUserRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Didn't find associated user with id: " + id));
    }

    //salvez user cu rol de user. Abia cand user-ul asociaza o entitate(STUDENT, TEACHER) atunci
    // in service-ul respectivei entitati(ex: studentService) i se asociaza rolul corespunzator entitatii
    // ex: STUDENT - se asociaza rol STUDENT in metoda saveStudent() din studentService

    public AppUser save(AppUser appUser) throws UserNotUniqueException {
        if(appUser != null){
            //if(!isUsernameUnique(appUser.getUsername())){
//                throw new UserNotUniqueException("Username already exists in db");
               // return appUserRepository.save(appUser);
           // }else
                {
                appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
                //TODO sa scap de hardcodarea cu role de mai jos
                appUser.getRoles().add(new Role(2L, "USER"));
                return appUserRepository.save(appUser);
            }
        }else{
            throw new NullPointerException("App user is null");
        }
    }



    private boolean isUsernameUnique(String username) {
        Optional<AppUser> optUser = appUserRepository.findByUsername(username);
        if (optUser.isPresent()){
            return false;}
        else{
            return true;
        }
    }

    public AppUser getUserByUsername(String username) {
        if(username == null || username.isEmpty()){
            throw new WrongParameter("User with username " + username + " doesn't exist");
        }
        return appUserRepository.findByUsername(username).orElseThrow(
                () -> new NullPointerException("Didn't find appUser with username: " + username));
    }
}

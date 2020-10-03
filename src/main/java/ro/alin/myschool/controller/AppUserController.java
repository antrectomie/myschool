package ro.alin.myschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.alin.myschool.exceptions.UserNotUniqueException;
import ro.alin.myschool.model.AppUser;
import ro.alin.myschool.service.AppUserService;

@RestController
@RequestMapping("/appUser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getAppUserById(@PathVariable Long id){
        AppUser appUser = appUserService.getUserById(id);
        return new ResponseEntity<AppUser>(appUser, HttpStatus.OK);
    }

    @GetMapping("/username")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        AppUser userByUsername = appUserService.getUserByUsername(username);
        return new ResponseEntity<>(userByUsername, HttpStatus.OK);
    }

    @GetMapping("student/{studentId}")
    public ResponseEntity<AppUser> getAppUserByStudentId(@PathVariable Long studentId){
        AppUser appUser = appUserService.getUserByStudentId(studentId);
        return new ResponseEntity<AppUser>(appUser, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<AppUser>saveAppUser(@RequestBody AppUser appUser) throws UserNotUniqueException {
        AppUser savedUser = appUserService.save(appUser);
        return new ResponseEntity<AppUser>(savedUser, HttpStatus.OK);
    }
}

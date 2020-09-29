package ro.alin.myschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.alin.myschool.model.AppUser;
import ro.alin.myschool.service.AppUserService;

@RestController
@RequestMapping("/appUser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getAppUsesr(@PathVariable Long id){
        AppUser appUser = appUserService.getUserById(id);
        return new ResponseEntity<AppUser>(appUser, HttpStatus.OK);
    }

    @GetMapping("student/{studentId}")
    public ResponseEntity<AppUser> getUserByStudentId(@PathVariable Long studentId){
        AppUser appUser = appUserService.getUserByStudentId(studentId);
        return new ResponseEntity<AppUser>(appUser, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AppUser>saveAppUser(@RequestBody AppUser appUser){
        AppUser savedUser = appUserService.save(appUser);
        return new ResponseEntity<AppUser>(savedUser, HttpStatus.OK);
    }
}

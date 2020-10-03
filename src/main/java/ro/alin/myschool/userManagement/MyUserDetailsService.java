package ro.alin.myschool.userManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.alin.myschool.model.AppUser;
import ro.alin.myschool.repository.AppUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("Couldn't find user with username: " + username));
//        appUser.setPassword("{bcrypt}" + appUser.getPassword());
        System.out.println(new MyUserDetails(appUser));
        return new MyUserDetails(appUser);
    }
}

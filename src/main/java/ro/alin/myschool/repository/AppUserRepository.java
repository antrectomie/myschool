package ro.alin.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.alin.myschool.model.AppUser;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

//    @Query(value = "SELECT u FROM AppUser u  JOIN Student s on u.id = s.appUserId")
    @Query(value = "SELECT app_user.* from  app_user inner join student on app_user.id = student.app_user_id ", nativeQuery = true)
    Optional<AppUser> findByStudentId(Long studentId);

    Optional<AppUser> findByUsername(String username);
}

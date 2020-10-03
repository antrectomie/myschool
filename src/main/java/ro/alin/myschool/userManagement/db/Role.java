package ro.alin.myschool.userManagement.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.alin.myschool.model.AppUser;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

//    @ManyToMany(mappedBy = "roles")
//    private Collection<AppUser> users;

//    public Role(Long id, String name) {
//        this.name = name;
//    }
}

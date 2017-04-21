package maks.core;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(mappedBy = "clothesSet")
    private Set<User> users = new HashSet<>();
    private String name;

    public Clothes() {
    }

    public Clothes( String name) {
        this.name = name;
    }

    public boolean addUser(User user) {
        if(users.add(user)){
            user.addClothes(this);
            return true;
        }
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

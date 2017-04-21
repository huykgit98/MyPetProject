package maks.core;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String name;
    private String email;

    private Set<GroupInvitation> groupInvitations = new HashSet<>();

    @ManyToMany()
    @JoinTable(
            name = "USER_CLOTHES",
            joinColumns = @JoinColumn(name="USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CLOTHES_ID",  referencedColumnName = "ID")
    )
    private Set<Clothes> clothesSet = new HashSet<>();
    @ManyToMany(mappedBy = "users")
    private Set<UserGroup> groups = new HashSet<>();

    public User(){}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public boolean addClothes(Clothes clothes){
        if(clothesSet.add(clothes)){
            clothes.addUser(this);
            return true;
        }
        return false;
    }

    public boolean addClothes(UserGroup userGroup) {
        if(groups.add(userGroup)){
            userGroup.addUser(this);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<UserGroup> groups) {
        this.groups = groups;
    }

    public Set<Clothes> getClothesSet() {
        return clothesSet;
    }

    public void setClothesSet(Set<Clothes> clothesSet) {
        this.clothesSet = clothesSet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
               /* ", clothesSet=" + clothesSet +
                ", groups=" + groups +*/
                '}';
    }

    public Set<GroupInvitation> getGroupInvitations() {
        return groupInvitations;
    }

    public void setGroupInvitations(Set<GroupInvitation> groupInvitations) {
        this.groupInvitations = groupInvitations;
    }

    public void addGroupInvitation(GroupInvitation groupInvitation) {
        groupInvitations.add(groupInvitation);
    }
}

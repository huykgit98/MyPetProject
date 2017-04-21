package maks.core.service;

import maks.core.Clothes;
import maks.core.GroupInvitation;
import maks.core.User;
import maks.core.UserGroup;
import maks.core.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Transactional
    public Set<Clothes> getClothes(User user){
        User current = userRepo.findOne(user.getId());
        Set<Clothes> clothes = current.getClothesSet();
        return new HashSet<>(clothes);
    }


}

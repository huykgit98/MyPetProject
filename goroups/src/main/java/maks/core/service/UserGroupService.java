package maks.core.service;

import maks.core.GroupInvitation;
import maks.core.User;
import maks.core.UserGroup;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserGroupService {

    public void sendInvitation(UserGroup userGroup, User fromUser, User invited){ // in real app from user will be specifid by current user from session
        GroupInvitation groupInvitation = new GroupInvitation(fromUser, invited, userGroup);
        invited.addGroupInvitation(groupInvitation);
    }

    public void configmInvitation(User currentUser){
        Set<GroupInvitation> groupInvitations = currentUser.getGroupInvitations();
    }

}

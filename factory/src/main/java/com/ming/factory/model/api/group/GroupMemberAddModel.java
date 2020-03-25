package com.ming.factory.model.api.group;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hortons
 * on 2020/3/25
 */


public class GroupMemberAddModel {

    private Set<String> users = new HashSet<>();

    public GroupMemberAddModel(Set<String> users) {
        this.users = users;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }
}

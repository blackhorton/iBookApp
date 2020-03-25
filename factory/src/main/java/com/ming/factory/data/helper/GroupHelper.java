package com.ming.factory.data.helper;

import com.ming.factory.data.DataSource;
import com.ming.factory.model.api.group.GroupCreateModel;
import com.ming.factory.model.api.group.GroupMemberAddModel;
import com.ming.factory.model.card.GroupCard;
import com.ming.factory.model.card.GroupMemberCard;
import com.ming.factory.model.db.Group;
import com.ming.factory.model.db.Group_Table;
import com.ming.factory.model.db.view.MemberUserModel;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import retrofit2.Call;

/**
 * 对群的一个简单的辅助工具类
 *
 * @author Hortons
 * on 2020/3/18
 */


public class GroupHelper {

    public static Group find(String groupId) {
        return null;
    }

    /**
     * 从本地找Group
     */
    public static Group findFromLocal(String groupId) {
        return SQLite.select()
                .from(Group.class)
                .where(Group_Table.id.eq(groupId))
                .querySingle();
    }

    public static Group findFromNet(String id) {
        return null;
    }

    public static void create(GroupCreateModel model, final DataSource.Callback<GroupCard> callback) {
    }

    public static Call search(String name, final DataSource.Callback<List<GroupCard>> callback) {
        return null;
    }

    public static void refreshGroups() {
    }

    public static long getMemberCount(String id) {
        return 1;
    }

    public static void refreshGroupMember(Group group) {
    }

    public static List<MemberUserModel> getMemberUsers(String groupId, int size) {
        return null;
    }

    public static void addMembers(String groupId, GroupMemberAddModel model, final DataSource.Callback<List<GroupMemberCard>> callback) {
    }


}
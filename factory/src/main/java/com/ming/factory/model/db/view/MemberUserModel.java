package com.ming.factory.model.db.view;

import com.ming.factory.model.db.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;

/**
 * 群成员对应的用户的简单信息表
 *
 * @author Hortons
 * on 2020/3/18
 */

@QueryModel(database = AppDatabase.class)
public class MemberUserModel {

    /**
     * User-id/Member-userId
     */
    @Column
    public String userId;
    /**
     * User-name
     */
    @Column
    public String name;
    /**
     * Member-alias
     */
    @Column
    public String alias;
    /**
     * User-portrait
     */
    @Column
    public String portrait;
}

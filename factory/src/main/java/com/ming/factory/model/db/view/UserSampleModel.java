package com.ming.factory.model.db.view;

import com.ming.factory.model.db.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.QueryModel;

/**
 * 用户基础信息的Model，可以和数据库进行查询
 *
 * @author Hortons
 * on 2020/3/19
 */

@QueryModel(database = AppDatabase.class)
public class UserSampleModel {

    @Column
    public String id;

    @Column
    public String name;

    @Column
    public String portrait;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}

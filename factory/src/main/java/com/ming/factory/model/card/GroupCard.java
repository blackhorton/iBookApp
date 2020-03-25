package com.ming.factory.model.card;

import com.ming.factory.model.db.Group;
import com.ming.factory.model.db.User;

import java.util.Date;

/**
 * @author Hortons
 * on 2020/3/23
 */


public class GroupCard {
    /**
     * 群Id
     */
    private String id;
    /**
     * 群名称
     */
    private String name;
    /**
     * 群描述
     */
    private String desc;
    /**
     * 群图片
     */
    private String picture;
    /**
     * 持有人的Id
     */
    private String ownerId;
    /**
     * 我在群中的消息通知级别-对象是我当前登录的账户
     */
    private int notifyLevel;
    /**
     * 我的加入时间
     */
    private Date joinAt;
    /**
     * 信息修改时间
     */
    private Date modifyAt;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getNotifyLevel() {
        return notifyLevel;
    }

    public void setNotifyLevel(int notifyLevel) {
        this.notifyLevel = notifyLevel;
    }

    public Date getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(Date joinAt) {
        this.joinAt = joinAt;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }

    /**
     * 把一个群的信息,build为一个群Model
     * 由于卡片中有创建者的ID，但是没有创建者这个人的Model
     * 所以Model需求在外部准备好传递进来
     *
     * @param owner 创建者
     * @return 群信息
     */
    public Group build(User owner) {
        Group group = new Group();
        group.setId(id);
        group.setName(name);
        group.setDesc(desc);
        group.setPicture(picture);
        group.setNotifyLevel(notifyLevel);
        group.setJoinAt(joinAt);
        group.setModifyAt(modifyAt);
        group.setOwner(owner);
        return group;
    }
}

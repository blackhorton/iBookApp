package com.ming.factory.net;

import com.ming.factory.model.api.RspModel;
import com.ming.factory.model.api.account.AccountRspModel;
import com.ming.factory.model.api.account.LoginModel;
import com.ming.factory.model.api.account.RegisterModel;
import com.ming.factory.model.api.user.UserUpdateModel;
import com.ming.factory.model.card.UserCard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * 网络请求的所有的接口
 *
 * @author Hortons
 * on 2020/3/18
 */


public interface RemoteService {


    /**
     * 注册接口
     *
     * @param model 传入的是RegisterModel
     * @return 返回的是RspModel<AccountRspModel>
     */
    @POST("account/register")
    Call<RspModel<AccountRspModel>> accountRegister(@Body RegisterModel model);

    /**
     * 登录接口
     *
     * @param model LoginModel
     * @return RspModel<AccountRspModel>
     */
    @POST("account/login")
    Call<RspModel<AccountRspModel>> accountLogin(@Body LoginModel model);

    /**
     * 绑定设备Id
     *
     * @param pushId 设备Id
     * @return RspModel<AccountRspModel>
     */
    @POST("account/bind/{pushId}")
    Call<RspModel<AccountRspModel>> accountBind(@Path(encoded = true, value = "pushId") String pushId);

    /**
     * 用户更新的接口
     * @param model
     * @return
     */
    @PUT("user")
    Call<RspModel<UserCard>> userUpdate(@Body UserUpdateModel model);

    /**
     * 用户搜索的接口
     * @param name
     * @return
     */
    @GET("user/search/{name}")
    Call<RspModel<List<UserCard>>> userSearch(@Path("name") String name);

    /**
     * 用户关注接口
     * @param userId
     * @return
     */
    @PUT("user/follow/{userId}")
    Call<RspModel<UserCard>> userFollow(@Path("userId") String userId);

    /**
     * 获取联系人列表
     * @return
     */
    @GET("user/contact")
    Call<RspModel<List<UserCard>>> userContacts();

    /**
     * 查询某人的信息
     * @param userId
     * @return
     */
    @GET("user/{userId}")
    Call<RspModel<UserCard>> userFind(@Path("userId") String userId);
//
//    // 发送消息的接口
//    @POST("msg")
//    Call<RspModel<MessageCard>> msgPush(@Body MsgCreateModel model);
//
//    // 创建群
//    @POST("group")
//    Call<RspModel<GroupCard>> groupCreate(@Body GroupCreateModel model);
//
//    // 拉取群信息
//    @GET("group/{groupId}")
//    Call<RspModel<GroupCard>> groupFind(@Path("groupId") String groupId);
//
//    // 群搜索的接口
//    @GET("group/search/{name}")
//    Call<RspModel<List<GroupCard>>> groupSearch(@Path(value = "name", encoded = true) String name);
//
//    // 我的群列表
//    @GET("group/list/{date}")
//    Call<RspModel<List<GroupCard>>> groups(@Path(value = "date", encoded = true) String date);
//
//    // 我的群的成员列表
//    @GET("group/{groupId}/member")
//    Call<RspModel<List<GroupMemberCard>>> groupMembers(@Path("groupId") String groupId);
//
//    // 给群添加成员
//    @POST("group/{groupId}/member")
//    Call<RspModel<List<GroupMemberCard>>> groupMemberAdd(@Path("groupId") String groupId,
//                                                         @Body GroupMemberAddModel model);


}

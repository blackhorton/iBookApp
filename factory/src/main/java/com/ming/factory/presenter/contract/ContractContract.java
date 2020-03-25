package com.ming.factory.presenter.contract;

import com.ming.factory.model.db.User;
import com.ming.factory.presenter.BaseContract;

/**
 * @author Hortons
 * on 2020/3/23
 */


public interface ContractContract {

    /**
     * 什么都不需要额外定义，开始就是调用start即可
     */
    interface Presenter extends BaseContract.Presenter {

    }

    /**
     * 都在基类完成了
     */
    interface View extends BaseContract.RecyclerView<Presenter, User> {}
}

package com.ming.factory.data;

import java.util.List;

/**
 * @author Hortons
 * on 2020/3/19
 */


public interface DbDataSource<Data> extends DataSource {

    void load(SucceedCallback<List<Data>> callback);
}

package com.ming.common.widget.recycler;

/**
 * @author Hortons
 * on 2020/3/5
 */
public interface AdapterCallback<Data> {

    /**
     * RecyclerView的更新
     * @param data
     * @param holder
     */
    void update(Data data, RecyclerAdapter.ViewHolder<Data> holder);
}

package com.ming.ibookapp.frags.search;

import com.ming.common.app.PresenterFragment;
import com.ming.factory.model.card.GroupCard;
import com.ming.factory.presenter.search.SearchContract;
import com.ming.ibookapp.activities.SearchActivity;

import java.util.List;

/**
 * @author Hortons
 * on 2020/3/23
 */


public class SearchGroupFragment extends PresenterFragment<SearchContract.Presenter>
        implements SearchActivity.SearchFragment, SearchContract.GroupView {

    @Override
    protected SearchContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected int getContentLayoutId() {
        return 0;
    }

    @Override
    public void onSearchDone(List<GroupCard> groupCards) {

    }
    @Override
    public void search(String content) {

    }
}

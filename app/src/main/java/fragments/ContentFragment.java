package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dabin.www.yilianxi.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import adapters.ContentAdapter;
import bean.NewBase;
import presenter.UesrPresenter;
import tools.API;
import view.IView;

/**
 * Created by Dabin on 2017/11/5.
 */

public class ContentFragment extends Fragment implements IView{
    View view;
    private XRecyclerView xRecyclerView;
    UesrPresenter uesrPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.content_item,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        uesrPresenter = new UesrPresenter(this);
        uesrPresenter.setUrl(API.BASE);
        xRecyclerView = view.findViewById(R.id.xrecyclerview);
        xRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void getNew(List<NewBase.DataBean> data) {
        xRecyclerView.setAdapter(new ContentAdapter(getActivity(),data));

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                uesrPresenter.setUrl(API.BASE);
                xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {

            }
        });
    }
}

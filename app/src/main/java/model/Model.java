package model;

import java.util.List;

import bean.NewBase;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tools.AipServer;

/**
 * Created by Dabin on 2017/11/5.
 */

public class Model implements IModel{

    List<NewBase.DataBean> data;

    private OnFinish onFinish;

    public interface OnFinish{
        void Finish( List<NewBase.DataBean> data);
    }

    public void getOnFinish(OnFinish onFinish){
        this.onFinish = onFinish;
    }

    @Override
    public void getUrl(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        AipServer aipServer = retrofit.create(AipServer.class);

        Observable<List<NewBase>> base = aipServer.getBase("xbsjxw/page_1.json");

        base.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newBase -> {
                    List<NewBase.DataBean> data = newBase.get(0).getData();
                    onFinish.Finish(data);
                });
    }

}

package presenter;

import java.util.List;

import bean.NewBase;
import model.Model;
import view.IView;

/**
 * Created by Dabin on 2017/11/5.
 */

public class UesrPresenter implements Model.OnFinish{
    private final IView iView;
    private final Model model;

    public UesrPresenter(IView iView) {
        this.iView = iView;
        this.model = new Model();
        model.getOnFinish(this);
    }

    public void setUrl(String url){
        model.getUrl(url);
    }


    @Override
    public void Finish(List<NewBase.DataBean> data) {
        iView.getNew(data);
    }
}

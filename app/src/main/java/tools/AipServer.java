package tools;

import java.util.List;

import bean.NewBase;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Dabin on 2017/11/5.
 */

public interface AipServer {
    @GET
    Observable<List<NewBase>> getBase(@Url String url);


}

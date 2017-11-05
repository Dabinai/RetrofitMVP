package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dabin.www.yilianxi.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import bean.NewBase;

/**
 * Created by Dabin on 2017/11/5.
 */

public class ContentAdapter extends XRecyclerView.Adapter{

    private Context context;
    private List<NewBase.DataBean> data;

    public ContentAdapter(Context context, List<NewBase.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.conadapter_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.textView.setText(data.get(position).getTitle());

        myViewHolder.imageView.setImageURI(data.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyViewHolder extends XRecyclerView.ViewHolder{
        TextView textView;
        SimpleDraweeView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.conimage);
            textView = itemView.findViewById(R.id.conText);
        }
    }
}

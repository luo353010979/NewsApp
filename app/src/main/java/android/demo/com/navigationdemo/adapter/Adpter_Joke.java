package android.demo.com.navigationdemo.adapter;

import android.content.Context;
import android.demo.com.navigationdemo.R;
import android.demo.com.navigationdemo.gson.Info_Joke;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class Adpter_Joke extends RecyclerView.Adapter<Adpter_Joke.JokeViewHodler> {
    Context context;
    List<Info_Joke.ResultBean> infoList;

    public Adpter_Joke(Context context, List<Info_Joke.ResultBean> infoList) {
        this.context = context;
        this.infoList = infoList;
    }

    @Override
    public JokeViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_joke, parent, false);
        return new JokeViewHodler(view);
    }

    @Override
    public void onBindViewHolder(JokeViewHodler holder, int position) {
        String content = infoList.get(position).getContent();
        holder.textView.setText("\u3000\u3000" + content);
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    class JokeViewHodler extends RecyclerView.ViewHolder {
        TextView textView;

        public JokeViewHodler(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_item_joke);
        }
    }
}

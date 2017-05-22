package android.demo.com.navigationdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.demo.com.navigationdemo.MainActivity;
import android.demo.com.navigationdemo.R;
import android.demo.com.navigationdemo.ShowWebView;
import android.demo.com.navigationdemo.gson.Info_News;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class Adapter_News extends RecyclerView.Adapter<Adapter_News.NewsViewHolder> {
    Context context;
    List<Info_News.ResultBean.DataBean> newsList;

    public Adapter_News(Context context, List<Info_News.ResultBean.DataBean> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itme_news, parent, false);
        NewsViewHolder viewHolder = new NewsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        String title = newsList.get(position).getTitle();
        String author = newsList.get(position).getAuthor_name();
        String time = newsList.get(position).getDate();
        final String picurl = newsList.get(position).getThumbnail_pic_s();
        final String newsurl = newsList.get(position).getUrl();

        holder.newsTitle.setText(title);
        holder.newsAuthor.setText(author);
        holder.newsTime.setText(time);
        Glide.with(context)
                .load(picurl)
                .placeholder(R.drawable.picture_download)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.newsImage);


        holder.newsItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowWebView.class);
                intent.putExtra("url", newsurl);
                intent.putExtra("picUrl", picurl);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImage;
        TextView newsTitle;
        TextView newsAuthor;
        TextView newsTime;
        RelativeLayout newsItem;

        public NewsViewHolder(View itemView) {
            super(itemView);
            newsImage = (ImageView) itemView.findViewById(R.id.new_img);
            newsTitle = (TextView) itemView.findViewById(R.id.news_title);
            newsAuthor = (TextView) itemView.findViewById(R.id.news_author);
            newsTime = (TextView) itemView.findViewById(R.id.news_time);
            newsItem = (RelativeLayout) itemView.findViewById(R.id.news_item);
        }
    }
}

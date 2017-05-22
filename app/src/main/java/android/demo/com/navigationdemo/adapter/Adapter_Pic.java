package android.demo.com.navigationdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.demo.com.navigationdemo.R;
import android.demo.com.navigationdemo.ShowPicActivity;
import android.demo.com.navigationdemo.gson.Info_Pic;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class Adapter_Pic extends RecyclerView.Adapter<Adapter_Pic.PicViewHodler> {
    Context context;
    List<Info_Pic.ResultBean> infoList;

    public Adapter_Pic(Context context, List<Info_Pic.ResultBean> infoList) {
        this.context = context;
        this.infoList = infoList;
    }

    @Override
    public PicViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pic, parent, false);
        return new PicViewHodler(view);
    }

    @Override
    public void onBindViewHolder(PicViewHodler holder, int position) {
        String title = infoList.get(position).getContent();
        final String picUrl = infoList.get(position).getUrl();
        holder.title.setText(title);
        Glide.with(context)
                .load(picUrl)
                .placeholder(R.drawable.picture_download)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.img);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowPicActivity.class);
                intent.putExtra("picUrl", picUrl);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    class PicViewHodler extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        CardView cardView;

        public PicViewHodler(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            title = (TextView) itemView.findViewById(R.id.title_pic_item);
            img = (ImageView) itemView.findViewById(R.id.image_pic_item);
        }
    }
}

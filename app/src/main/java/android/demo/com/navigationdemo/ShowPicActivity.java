package android.demo.com.navigationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import uk.co.senab.photoview.PhotoView;

public class ShowPicActivity extends AppCompatActivity {

    PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pic);
        photoView = (PhotoView) findViewById(R.id.photoView);
        Intent intent = getIntent();
        String picUrl = intent.getStringExtra("picUrl");
        Glide.with(this)
                .load(picUrl)
                .placeholder(R.drawable.picture_download)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(photoView);
    }
}

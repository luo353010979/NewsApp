package android.demo.com.navigationdemo;

import android.demo.com.navigationdemo.adapter.Adapter_Pic;
import android.demo.com.navigationdemo.gson.Info_Pic;
import android.demo.com.navigationdemo.util.HttpUtil;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PicActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, RefreshRecyclerView.OnLoadMoreListener {
    Toolbar toolbar;
    SwipeRefreshLayout srl;
    RefreshRecyclerView rv;
    Info_Pic info_pic;
    List<Info_Pic.ResultBean> info_picList = new ArrayList<>();
    Adapter_Pic adapter;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);
        toolbar = (Toolbar) findViewById(R.id.toolBar_pic);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        srl = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout_pic);
        rv = (RefreshRecyclerView) findViewById(R.id.refresh_layout_pic);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLoadMoreEnable(true);

        rv.setFooterResource(R.layout.item_footer);

        srl.setColorSchemeResources(R.color.colorPrimary);

        requestInfoPic();

        srl.setOnRefreshListener(this);
        rv.setOnLoadMoreListener(this);

        adapter = new Adapter_Pic(this, info_picList);
        rv.setAdapter(adapter);
    }

    /**
     * 获取网络数据并用GSON解析
     */
    private void requestInfoPic() {
//        String url = "http://japi.juhe.cn/joke/img/text.from?key=21540cc9231064c46ce6fb677c7ba946&page=" + page + "&pagesize=5";
        String url = "http://v.juhe.cn/joke/randJoke.php?key=21540cc9231064c46ce6fb677c7ba946&type=pic";
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                Gson gson = new Gson();
                info_pic = gson.fromJson(data, Info_Pic.class);
                for (int i = 0; i < info_pic.getResult().size(); i++) {
                    info_picList.add(info_pic.getResult().get(i));
                    Log.d(MainActivity.TAG, "onResponse: " + info_pic.getResult().get(i).getContent());
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rv.notifyData();
                    }
                });
            }
        });
    }

    @Override
    public void loadMoreListener() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                requestInfoPic();
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                srl.setRefreshing(false);
                info_picList.clear();
                requestInfoPic();
            }
        }, 2000);
    }


}

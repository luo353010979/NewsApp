package android.demo.com.navigationdemo;

import android.demo.com.navigationdemo.adapter.Adpter_Joke;
import android.demo.com.navigationdemo.gson.Info_Joke;
import android.demo.com.navigationdemo.util.HttpUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class JokeActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, RefreshRecyclerView.OnLoadMoreListener {
    Toolbar toolbar;
    SwipeRefreshLayout srl;
    RefreshRecyclerView rv;
    Info_Joke info_joke;
    Adpter_Joke adpter;
    List<Info_Joke.ResultBean> infoList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        toolbar = (Toolbar) findViewById(R.id.toolBar_joke);
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

        srl = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout_joke);
        rv = (RefreshRecyclerView) findViewById(R.id.refresh_layout_joke);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLoadMoreEnable(true);

        rv.setFooterResource(R.layout.item_footer);

        srl.setColorSchemeResources(R.color.colorPrimary);


        srl.setOnRefreshListener(this);
        rv.setOnLoadMoreListener(this);

        requstJokeInfo();
        adpter = new Adpter_Joke(this, infoList);
        rv.setAdapter(adpter);
    }

    private void requstJokeInfo() {
        String url = "http://v.juhe.cn/joke/randJoke.php?key=21540cc9231064c46ce6fb677c7ba946&type=";
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                Gson gson = new Gson();
                info_joke = gson.fromJson(data, Info_Joke.class);
                for (int i = 0; i < info_joke.getResult().size(); i++) {
                    infoList.add(info_joke.getResult().get(i));
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
        requstJokeInfo();
    }

    @Override
    public void onRefresh() {
        srl.setRefreshing(false);
        infoList.clear();
        requstJokeInfo();
    }
}

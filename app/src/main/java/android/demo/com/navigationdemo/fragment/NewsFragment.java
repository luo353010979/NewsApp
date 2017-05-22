package android.demo.com.navigationdemo.fragment;


import android.demo.com.navigationdemo.MainActivity;

import android.demo.com.navigationdemo.SpaceItemDecoration;
import android.demo.com.navigationdemo.adapter.Adapter_News;
import android.demo.com.navigationdemo.gson.Info_News;
import android.demo.com.navigationdemo.util.HttpUtil;
import android.os.Bundle;
import android.os.Handler;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.demo.com.navigationdemo.R;

import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    public static final String TABLAYOUT_FRAGMENT = "tab_fragment";
    private int type;
    SwipeRefreshLayout refreshLayout;
    RecyclerView recyclerView;
    List<Info_News.ResultBean.DataBean> newsList = new ArrayList<>();
    Info_News news;
    Adapter_News adapter;
    String newsType;

    public static NewsFragment newInstance(int type) {
        NewsFragment newsFragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TABLAYOUT_FRAGMENT, type);
        newsFragment.setArguments(bundle);
        return newsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = (int) getArguments().getSerializable(TABLAYOUT_FRAGMENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        initView(view);
        return view;
    }


    private void initView(View view) {
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
        recyclerView.addItemDecoration(new SpaceItemDecoration(5));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        switch (type) {
            case 0:
                newsType = "top";
                newsType(newsType);
                break;
            case 1:
                newsType = "shehui";
                newsType(newsType);
                break;
            case 2:
                newsType = "guonei";
                newsType(newsType);
                break;
            case 3:
                newsType = "guoji";
                newsType(newsType);
                break;
            case 4:
                newsType = "yule";
                newsType(newsType);
                break;
            case 5:
                newsType = "tiyu";
                newsType(newsType);
                break;
            case 6:
                newsType = "junshi";
                newsType(newsType);
                break;
            case 7:
                newsType = "keji";
                newsType(newsType);
                break;
            case 8:
                newsType = "caijing";
                newsType(newsType);
                break;
            case 9:
                newsType = "shishang";
                newsType(newsType);
                break;
            default:
                break;
        }

    }

    /**
     * 选择加载新闻类型 同时监听刷新
     **/
    private void newsType(String type) {
        final String url = "http://v.juhe.cn/toutiao/index?type=" + type + "&key=4cba7f79f18f108b14c1807bfc4b850b";
        requestNewsInfo(url);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                        newsList.clear();
                        requestNewsInfo(url);
                        adapter.notifyDataSetChanged();
                    }
                }, 2000);
            }
        });
    }

    /**
     * 获取新闻数据 并使用Gson解析 同时加载适配器
     */

    private void requestNewsInfo(String url) {
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "获取信息失败，请检查网络", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                Gson gson = new Gson();

                news = gson.fromJson(data, Info_News.class);


                for (int i = 0; i < news.getResult().getData().size(); i++) {
                    newsList.add(news.getResult().getData().get(i));
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new Adapter_News(getContext(), newsList);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });

    }

    private Handler handler = new Handler();
}

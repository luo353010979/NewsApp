package android.demo.com.navigationdemo.gson;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class Info_Pic {

    /**
     * reason : success
     * result : [{"content":"睡神无处不在啊","hashId":"03B983053D82B138524AEAF84CA73957","unixtime":"1420696648","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201501/08/03B983053D82B138524AEAF84CA73957.jpg"},{"content":"乱成一锅粥","hashId":"BAFD0A729133F5BC3B6D56576C5DE6E0","unixtime":"1420696648","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201501/08/BAFD0A729133F5BC3B6D56576C5DE6E0.jpg"},{"content":"真是好可爱啊","hashId":"7B86E59A3B057DD00C2D9A7B93185B67","unixtime":"1420696648","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201501/08/7B86E59A3B057DD00C2D9A7B93185B67.jpg"},{"content":"我真不知道怎么说\u2026\u2026","hashId":"C9518C3BD3361F95DF2BB2506C9B5929","unixtime":"1420697847","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201501/08/C9518C3BD3361F95DF2BB2506C9B5929.jpg"},{"content":"这能走到哪里去","hashId":"90562E5ECDCE803F818F8B0E68CC456C","unixtime":"1420697869","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201501/08/90562E5ECDCE803F818F8B0E68CC456C.jpg"},{"content":"哥就是蓝翔毕业的","hashId":"4854873812F1FBC25CABC9D51830A4EE","unixtime":"1420697869","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201501/08/4854873812F1FBC25CABC9D51830A4EE.jpg"},{"content":"为毛我捡的钱和别人的不一样？.","hashId":"CC4998AF25E10C5E905EEEB290D82BA4","unixtime":"1420699095","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201501/08/CC4998AF25E10C5E905EEEB290D82BA4.jpg"},{"content":"欧巴，不要走","hashId":"931A7E80734C0A8CAF4BC477485FE135","unixtime":"1420699130","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201501/08/931A7E80734C0A8CAF4BC477485FE135.jpg"},{"content":"女人都爱无理取闹","hashId":"341DA25B0E4D32B3586E8348A60FD5CC","unixtime":"1420699130","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201501/08/341DA25B0E4D32B3586E8348A60FD5CC.jpg"},{"content":"这回答真是醉了","hashId":"0880BA5F524EABD4A248D86D635C6A8F","unixtime":"1420699130","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201501/08/0880BA5F524EABD4A248D86D635C6A8F.jpg"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 睡神无处不在啊
         * hashId : 03B983053D82B138524AEAF84CA73957
         * unixtime : 1420696648
         * url : http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201501/08/03B983053D82B138524AEAF84CA73957.jpg
         */

        private String content;
        private String hashId;
        private String unixtime;
        private String url;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public String getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(String unixtime) {
            this.unixtime = unixtime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}

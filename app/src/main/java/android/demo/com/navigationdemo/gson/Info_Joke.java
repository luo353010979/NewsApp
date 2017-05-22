package android.demo.com.navigationdemo.gson;

import java.util.List;

/**
 * Created by Administrator on 2017/3/5 0005.
 */

public class Info_Joke {


    /**
     * reason : success
     * result : [{"content":"班里有个萌妹纸胸特大喜欢穿带有长兔子耳朵的衣服，有次我把兔子耳朵系了起来。然后\u2026\u2026她从后面反手解，发现胸显特大！！我告诉了班里男同学，从此之后～～～她的兔子耳朵就经常被系起来了","hashId":"946C64DB30A9D604285A988E2FE8042B","unixtime":"1427710932"},{"content":"跟一女的相亲，她嫌我太瘦弱。 我就小声的跟她说：\u201c晚上我的动静老大了。\u201d 没想到她居然同意跟我相处了。 可是，我就头疼了，我打呼噜的声音那可真的是老大了。","hashId":"E7CFAB592B4A2D604BC6FE243507C2C1","unixtime":"1427710943"},{"content":"片场，杨过对小龙女说\u201c姑姑，你站我后面吧\u201d，小龙女很感动\u201c过儿你是怕金轮法王伤到我是吗？\u201d\u201c姑姑你误会了，是你脸太大挡住我镜头了\u201d。第二天风很大很冷，杨过说\u201c姑姑你还是站我前面吧\u201d，小龙女再次感动\u201c过儿你终于知道，我脸一点都不大对不对？\u201d\u201c姑姑你误会了，风太大，你脸大可以挡一下\u201d","hashId":"3E9628C9300C3AC656DCB53F1126AE0D","unixtime":"1427711529"},{"content":"上课中，坐前方的女神突然回头问我：\u201c我的胸毛美不美？\u201d 我惊呆了，木木的看着她，竟无言以对！ 这时她又来了句：\u201c哦，我是想问，我的眉毛凶不凶？\u201d 我：\u201c\u2026\u2026\u201d","hashId":"734D1745032CDC1C472E3BAB34147E6D","unixtime":"1427711559"},{"content":"作为\u201c好\u201d老公，我的工资一般都由老婆保管。 我还谄媚地对老婆说：\u201c老婆，好老公就是钱包里不能有太多的钱！\u201d 老婆眼一瞪：\u201c好老公哪里有钱包？\u201d 好像也有道理！","hashId":"D73641B8A9B3DEB6B4DBC4D414399D10","unixtime":"1427711559"},{"content":"最近在练车，很紧张\u2026\u2026，这种情况已经好几次了，每次老公把钥匙递给我的时候我整个人就感觉不好了，开门，上车，关门，起动，嗯？？？钥匙呢？？？一阵狂找，哦\u2026\u2026\u2026\u2026，刚才开门的时候插门上了，又默默的出去拿钥匙，老公在旁边已经笑的不行了，哎！","hashId":"212d30f66b57a8e6313b6b209d0dfd5c","unixtime":"1427711632"},{"content":"昨天从老家赶回石家庄，又见到了我那聪明无比小外甥，快七岁的小机灵豆。开车是疯惯了，所以每次从北京回家，或者是从家回北京，总要跟老爸发个短信报个平安，省得老人担心。下午四点就到石家庄了，躺下休息了一会，翻翻书看看报的，把给老爸报平安的事情给忘记了。等想起来的时候，已经六点半了！\u201c我们四点就到了。。。\u201d我边写短信边念着。\u201c然后在门外等了两个多小时。。。\u201d外甥接口说。","hashId":"7e976ac69a631a5f16b2df2bb9460ec5","unixtime":"1427711632"},{"content":"上课时，丁丁上课开小差，被老师发现了，于是老师就叫丁丁抄自己名字一百遍！\r\n人家鸗鱦龜同学上课一直都很认真，\r\n丁丁立刻说到：这真是个看名字的世界啊！","hashId":"5536bf44947ca9a001f73543a1ee49a2","unixtime":"1427711632"},{"content":"刚才我饿了，拿了两个雪饼吃，一边走一边吃。一边手里拿着空袋子。看见前面停一车一美女坐车里开着窗户玩手机。我就一边看着美女一边走。走到车边脑袋怎么抽了一下。把垃圾扔车里了。美女看着我。我嘴里含着雪饼看着美女。\u2026\u2026大家想想我跑的丑样","hashId":"e7ef313140f108e7ca0862f50e20640f","unixtime":"1427711632"},{"content":"老婆有孕在身半年，一直没偿肉之滋味。前两天在公司加班了一会，抓住机遇出去吃肉了。因为在那边都洗了三遍，回到家不想动趟床上准备睡了，这时老婆来了，揪住耳朵就说：怎么不洗就睡？是不是在外面跟谁洗过？还是干的太累了不想动了？当场心中万只小马奔过，吓死我了赶紧起来躲厕所了。这女人真TM能猜，还真TM准！","hashId":"88909b3598444a315c7dcd968796680a","unixtime":"1427711632"}]
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
         * content : 班里有个萌妹纸胸特大喜欢穿带有长兔子耳朵的衣服，有次我把兔子耳朵系了起来。然后……她从后面反手解，发现胸显特大！！我告诉了班里男同学，从此之后～～～她的兔子耳朵就经常被系起来了
         * hashId : 946C64DB30A9D604285A988E2FE8042B
         * unixtime : 1427710932
         */

        private String content;
        private String hashId;
        private String unixtime;

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
    }
}

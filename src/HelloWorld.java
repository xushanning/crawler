import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.https.HttpsUtils;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/**
 * Created by xusn10 on 2017/3/10.
 */
public class HelloWorld {
    public static void main(String[] args) {
        String url = "http://www.oschina.net";
        String baiduUrl = "https://www.baidu.com/";
        String gaemUrl = "http://www.51niu.com/BuyGold/10-227-101-1016-00-0-0-0-0-0-1.html";

        String regex = "1元=.*万金币";
//        String a = "[abdh]e";
//        String b = "hello world";
//        String src = RegexStringUtils.regexString(b, a);
//        System.out.println(src);
        OkHttpUtils.
                post()
                .url(gaemUrl)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onResponse(String s, int i) {
                        //System.out.println(s);
//                        String a = "[abdh]e";
//                        String b = "hello world";
                        String src = RegexStringUtils.regexString(s, regex);
                        System.out.println(src);
                        
                    }
                });
    }

}

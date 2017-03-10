import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.Call;

/**
 * Created by xusn10 on 2017/3/10.
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String url = "http://www.oschina.net";
        OkHttpUtils.
                post()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onResponse(String s, int i) {
                        System.out.println(s);
                    }
                });
    }

}

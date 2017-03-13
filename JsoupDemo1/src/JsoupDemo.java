import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by xusn10 on 2017/3/13.
 */
public class JsoupDemo {

    public static void main(String[] args) {
        String gameUrl = "http://www.51niu.com/BuyGold/10-227-101-1016-00-0-0-0-0-0-1.html";
        try {
            Document document = Jsoup.connect(gameUrl).get();
            //f_red14
            //fl shoplist04
            Elements elements = document.getElementsByClass("fl shoplist04");
            for (Element e : elements) {
                System.out.println(e.getElementsByTag("p").text());

                //System.out.println(e);
                //System.out.println(e.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

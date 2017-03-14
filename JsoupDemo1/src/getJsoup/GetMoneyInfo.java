package getJsoup;

import model.MoneyModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.Constants;
import utils.LogUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by xusn10 on 2017/3/14.
 * 获取每个区的比例信息
 */
public class GetMoneyInfo {
    String areaURL;
    String area;
    private List<MoneyModel> list;

    public GetMoneyInfo(String areaURL, String area) {
        this.areaURL = areaURL;
        this.area = area;
    }

    public List<MoneyModel> getMoneyScale() {
        String substringURL = areaURL.substring(0, areaURL.length() - 6);
        list = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            String realURL = substringURL + i + ".html";
            try {
                Document document = Jsoup.connect(realURL).get();
                Elements elements = document.getElementsByClass("shoplist");
                Elements elements1 = elements.get(0).getElementsByTag("li");
                //先检测是否有内容，如果有，那么则进行解析，没有直接返回已经存有数据的list
                if (elements1.size() != 0) {
                    for (int j = 0; j < elements1.size(); j++) {

                        Element element = elements1.get(j);
                        Elements elements2 = element.getElementsByClass("fl shoplist02 f_red16");
                        String price = elements2.get(0).text();
                        Elements elements3 = element.getElementsByClass("fl shoplist04");
                        String scale = elements3.get(0).getElementsByTag("p").get(1).text();
                        Elements elements4 = element.getElementsByClass("fl shoplist01");
                        String url = Constants.initialURL + elements4.get(0).getElementsByClass("f_blue14").get(0).select("a").first().attr("href");
                        MoneyModel moneyModel = new MoneyModel();
                        moneyModel.setYuan(price);
                        moneyModel.setLianjie(url);
                        moneyModel.setQu(area);
                        moneyModel.setBili(scale);
                        list.add(moneyModel);

                    }
                } else {
                    //如果size==0，说明，没有数据了，return
                    return list;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }
}
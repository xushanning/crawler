package getJsoup;

import model.AreaModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.Constants;
import utils.LogUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xusn10 on 2017/3/14.
 */
public class GetArea {
    private List<AreaModel> list;

    public GetArea() {
    }

    public List<AreaModel> GetAreaInfo() {
        try {
            Document document = Jsoup.connect(Constants.wangtongURL).get();
            Element element = document.getElementById("divServerList");
            Elements elements = element.getElementsByTag("span");
            list = new ArrayList<>();
            //之所以从1开始，是因为第一个是全区的，不用
            for (int i = 1; i < elements.size(); i++) {
                Element element1 = elements.get(i);
                String title = element1.text();
                Element linkElement = element1.select("a").first();
                String areaInfoURL = Constants.initialURL + linkElement.attr("href");
                AreaModel areaModel = new AreaModel();
                areaModel.setArea(title);
                areaModel.setAreaInfo(areaInfoURL);
                list.add(areaModel);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

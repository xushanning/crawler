import getJsoup.GetArea;
import getJsoup.GetMoneyInfo;
import model.AreaModel;
import model.MoneyModel;
import utils.LogUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xusn10 on 2017/3/14.
 */
public class JsoupDemo1 {
    public static void main(String[] args) {
//        String url = "http://www.51niu.com/BuyGold/10-227-101-1010-00-0-0-0-0-0-1.html";
//        String area = "北京四区";
        GetArea getArea = new GetArea();
        List<AreaModel> list = getArea.GetAreaInfo();
        List<MoneyModel> allList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String url = list.get(i).getAreaInfo();
            String area = list.get(i).getArea();
            GetMoneyInfo getMoneyInfo = new GetMoneyInfo(url, area);
            List moneyInfo = getMoneyInfo.getMoneyScale();

            allList.addAll(moneyInfo);
        }

        for (int i = 0; i < allList.size(); i++) {
            LogUtil.Log("大区:" + allList.get(i).getQu() + "  比例:" + allList.get(i).getBili() + "  价格:" + allList.get(i).getYuan() + "  链接:" + allList.get(i).getLianjie());
        }

    }

}

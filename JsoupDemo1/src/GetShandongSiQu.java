import getJsoup.GetMoneyInfo;
import model.MoneyModel;
import utils.LogUtil;

import java.util.List;

/**
 * Created by xusn10 on 2017/3/14.
 * 这个是单独爬山东四区的数据
 */
public class GetShandongSiQu {
    public static void main(String[] args) {
        String url = "http://www.51niu.com/BuyGold/10-227-101-1016-00-0-0-0-0-0-1.html";
        String area = "山东四区";
        GetMoneyInfo getMoneyInfo = new GetMoneyInfo(url, area);
        List<MoneyModel> moneyInfo = getMoneyInfo.getMoneyScale();
        for (int i = 0; i < moneyInfo.size(); i++) {
            LogUtil.Log("大区:山东四区" + "  比例:" + moneyInfo.get(i).getBili() + "  价格:" + moneyInfo.get(i).getYuan() + "  链接：" + moneyInfo.get(i).getLianjie());
        }
    }
}

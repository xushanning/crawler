package model;

/**
 * Created by xusn10 on 2017/3/14.
 */
public class MoneyModel {

    /**
     * qu : 什么区
     * bili : 什么比例
     * yuan : 一共多少钱
     * lianjie : 购买链接
     */

    private String qu;
    private String bili;
    private String yuan;
    private String lianjie;

    public String getQu() {
        return qu;
    }

    public void setQu(String qu) {
        this.qu = qu;
    }

    public String getBili() {
        return bili;
    }

    public void setBili(String bili) {
        this.bili = bili;
    }

    public String getYuan() {
        return yuan;
    }

    public void setYuan(String yuan) {
        this.yuan = yuan;
    }

    public String getLianjie() {
        return lianjie;
    }

    public void setLianjie(String lianjie) {
        this.lianjie = lianjie;
    }
}

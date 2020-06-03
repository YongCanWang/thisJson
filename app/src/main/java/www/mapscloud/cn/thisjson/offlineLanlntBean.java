package www.mapscloud.cn.thisjson;

/**
 * Created by wangyongcan on 2018/5/19.
 */

public class offlineLanlntBean {


    /**
     * areaName : 世界
     * northLatitude : 60.5
     * eastLongitude : 130.5
     * southLatitude : -60.5
     * westLongitude : 20.5
     * mixZoom : 1
     * maxZoom : 19
     */

    private String areaName;
    private double northLatitude;
    private double eastLongitude;
    private double southLatitude;
    private double westLongitude;
    private int mixZoom;
    private int maxZoom;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public double getNorthLatitude() {
        return northLatitude;
    }

    public void setNorthLatitude(double northLatitude) {
        this.northLatitude = northLatitude;
    }

    public double getEastLongitude() {
        return eastLongitude;
    }

    public void setEastLongitude(double eastLongitude) {
        this.eastLongitude = eastLongitude;
    }

    public double getSouthLatitude() {
        return southLatitude;
    }

    public void setSouthLatitude(double southLatitude) {
        this.southLatitude = southLatitude;
    }

    public double getWestLongitude() {
        return westLongitude;
    }

    public void setWestLongitude(double westLongitude) {
        this.westLongitude = westLongitude;
    }

    public int getMixZoom() {
        return mixZoom;
    }

    public void setMixZoom(int mixZoom) {
        this.mixZoom = mixZoom;
    }

    public int getMaxZoom() {
        return maxZoom;
    }

    public void setMaxZoom(int maxZoom) {
        this.maxZoom = maxZoom;
    }
}

package linghu.utils;

public class CalculateUtil {
    private final static double EARTH_RADIUS = 6371.393;//km
    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    public static Double calDistance(double x1,double y1,double x2,double y2){
        double radLat1 = rad(x1);
        double radLat2 = rad(x2);
        double a = radLat1 - radLat2;
        double b = rad(y1) - rad(y2);
        double s = 2 * Math.asin(Math.sqrt(Math.abs(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2))));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 1000);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(calDistance(39.90083300000,116.32810000000,34.79527300000,114.35314000000));
        System.out.println(calDistance(116.32810000000,39.90083300000,114.35314000000,34.79527300000));
    }
}

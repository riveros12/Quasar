package co.com.mercado.libre.business;

import co.com.mercado.libre.business.object.Point;
import co.com.mercado.libre.constants.Constant;
import co.com.mercado.libre.controller.request.SatelliteInfoDTO;
import co.com.mercado.libre.controller.request.SatellitesRequestDTO;

/**
 * @author oscarriveros
 */
public class Location {

    /**
     * getLocation
     *
     * @param satellitesInfo
     * @return
     */
    public static Point getLocation(SatellitesRequestDTO satellitesInfo) {
        Point point = new Point();
        double a1, b1, a2, b2, a3, b3, x, y;
        double r1 = 0, r2= 0, r3= 0;
        a1 = Constant.KENOBI_X;
        b1 = Constant.KENOBI_Y;
        a2 = Constant.SKYWALKER_X;
        b2 = Constant.SKYWALKER_Y;
        a3 = Constant.SOTO_X;
        b3 = Constant.SOTO_Y;
        for(SatelliteInfoDTO sate:satellitesInfo.getSatellites()){
            if(sate.getName().toUpperCase().equals(Constant.KENOBI)){
                r1 =sate.getDistance();
            }else if(sate.getName().toUpperCase().equals(Constant.SKYWALKER)){
                r2=sate.getDistance();
            }else if(sate.getName().toUpperCase().equals(Constant.SATO)){
                r3=sate.getDistance();
            }
        }
        try {
            double a1Sq = a1 * a1,
                    a2Sq = a2 * a2,
                    a3Sq = a3 * a3,
                    b1Sq = b1 * b1,
                    b2Sq = b2 * b2,
                    b3Sq = b3 * b3,
                    r1Sq = r1 * r1,
                    r2Sq = r2 * r2,
                    r3Sq = r3 * r3;
            double numerator1 = (a2 - a1) * (a3Sq + b3Sq - r3Sq) +
                    (a1 - a3) * (a2Sq + b2Sq - r2Sq) +
                    (a3 - a2) * (a1Sq + b1Sq - r1Sq);
            double denominator1 = 2 * (b3 * (a2 - a1) +
                    b2 * (a1 - a3) + b1 *
                    (a3 - a2));
            y = numerator1 / denominator1;
            double numerator2 = r2Sq - r1Sq +
                    a1Sq - a2Sq +
                    b1Sq - b2Sq - 2 *
                    (b1 - b2) * y;
            double denominator2 = 2 * (a1 - a2);
            x = numerator2 / denominator2;
            point.setX(x);
            point.setY(y);
        } catch (RuntimeException e) {
            System.out.println(e.getStackTrace());
        }
        return point;
    }

}

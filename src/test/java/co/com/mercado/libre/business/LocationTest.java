package co.com.mercado.libre.business;

import co.com.mercado.libre.business.object.Point;
import co.com.mercado.libre.controller.request.SatelliteInfoDTO;
import co.com.mercado.libre.controller.request.SatellitesRequestDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LocationTest {

    private Location location;

    private List<SatelliteInfoDTO> dtosList;

    private SatellitesRequestDTO requestDTO;

    public LocationTest() {
        requestDTO = new SatellitesRequestDTO();
        dtosList = new ArrayList<>();
    }

    @Test
    public void getLocation(){
        Point outpoint =new Point();
        outpoint.setX(-487.28591304435724);
        outpoint.setY(1557.0142282661438);
        SatelliteInfoDTO satellite1 = new SatelliteInfoDTO();
        satellite1.setName("kenobi");
        satellite1.setDistance((float)100.0);
        satellite1.setMessage(new ArrayList<>(Arrays.asList("este","","", "mensaje","")));
        dtosList.add(satellite1);

        SatelliteInfoDTO satellite2 = new SatelliteInfoDTO();
        satellite2.setName("skywalker");
        satellite2.setDistance((float)115.5);
        satellite2.setMessage(new ArrayList<>(Arrays.asList("","es" , "", "", "secreto")));
        dtosList.add(satellite2);

        SatelliteInfoDTO satellite3 = new SatelliteInfoDTO();
        satellite3.setName("sato");
        satellite3.setDistance((float)142.7);
        satellite3.setMessage(new ArrayList<>(Arrays.asList("este", "" ,"un", "","")));
        dtosList.add(satellite3);
        requestDTO.setSatellites(dtosList);


        assertEquals(outpoint.getX(),location.getLocation(requestDTO).getX());
        assertEquals(outpoint.getY(),location.getLocation(requestDTO).getY());
    }
}

package co.com.mercado.libre.domain.servicies;


import co.com.mercado.libre.business.Location;
import co.com.mercado.libre.business.Message;
import co.com.mercado.libre.business.object.Point;
import co.com.mercado.libre.controller.request.SatelliteInfoDTO;
import co.com.mercado.libre.controller.request.SatelliteRequestOnoToOneDTO;
import co.com.mercado.libre.controller.request.SatellitesRequestDTO;
import co.com.mercado.libre.controller.response.SatelliteTransmitterDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class SatelliteInfoService {

    private List<SatelliteInfoDTO> dtosList;

    private List<String> satellitesNames;

    private SatellitesRequestDTO requestDTO;


    SatelliteInfoService() {
        satellitesNames = new ArrayList<>();
        satellitesNames.add("KENOBI");
        satellitesNames.add("SKYWALKER");
        satellitesNames.add("SATO");

        requestDTO = new SatellitesRequestDTO();
        dtosList = new ArrayList<>();
    }

    /**
     * getSatelliteInfo
     *
     * @param requestDTO
     * @return
     */
    public SatelliteTransmitterDTO getSatelliteInfo(SatellitesRequestDTO requestDTO) {
        SatelliteTransmitterDTO response = new SatelliteTransmitterDTO();
        String message = null;
        Point point = null;
        try {
            if (requestDTO.getSatellites().get(0).getMessage() != null &&
                    requestDTO.getSatellites().get(1).getMessage() != null &&
                    requestDTO.getSatellites().get(2).getMessage() != null) {
                message = Message.getMessage(requestDTO.getSatellites().get(0).getMessage(),
                        requestDTO.getSatellites().get(1).getMessage(),
                        requestDTO.getSatellites().get(2).getMessage());
            }
            if (requestDTO.getSatellites().get(0).getDistance() != null
                    && requestDTO.getSatellites().get(1).getDistance() != null
                    && requestDTO.getSatellites().get(2).getDistance() != null) {
                point = Location.getLocation(requestDTO);
            }

        } catch (Exception e) {
            //TODO EXCEPTION
        }
        if (message != null && point != null) {
            response.setPosition(point);
            response.setMessage(message);
        } else {
            return null;
        }
        return response;
    }

    /**
     * setInformationTransmitterOneToOne
     *
     * @param nameSatellite
     * @param sattelite
     */
    public Boolean setInformationTransmitterOneToOne(String nameSatellite, SatelliteRequestOnoToOneDTO sattelite) {
        boolean success = true;
        if (satellitesNames.contains(nameSatellite.toUpperCase())) {
            if(dtosList.size()>0){
                //delete if Object exist and add
                for(SatelliteInfoDTO iter:dtosList){
                    if(iter.getName().equals(nameSatellite)){
                        dtosList.remove(iter);
                    }
                }
                SatelliteInfoDTO satellite = new SatelliteInfoDTO();
                satellite.setName(nameSatellite);
                satellite.setDistance(sattelite.getDistance());
                satellite.setMessage(new ArrayList<>(sattelite.getMessage()));
                dtosList.add(satellite);
            }else{
                SatelliteInfoDTO satellite = new SatelliteInfoDTO();
                satellite.setName(nameSatellite);
                satellite.setDistance(sattelite.getDistance());
                satellite.setMessage(new ArrayList<>(sattelite.getMessage()));
                dtosList.add(satellite);
            }
            if (dtosList.size() == 3) {
                requestDTO.setSatellites(dtosList);
            }
        } else {
            success = false;
        }
        return success;
    }

    /**
     * getInformationTransmitterResult
     *
     * @return
     */
    public SatelliteTransmitterDTO getInformationTransmitterResult() {
        SatelliteTransmitterDTO satelliteTransmitterDTO = new SatelliteTransmitterDTO();
        if (dtosList.size() == 3) {
            return getSatelliteInfo(requestDTO);
        } else {
            return null;
        }
    }
}

package co.com.mercado.libre.controller;


import co.com.mercado.libre.controller.request.SatelliteRequestOnoToOneDTO;
import co.com.mercado.libre.controller.request.SatellitesRequestDTO;
import co.com.mercado.libre.controller.response.SatelliteTransmitterDTO;
import co.com.mercado.libre.controller.validator.request.ErrorValidator;
import co.com.mercado.libre.domain.servicies.SatelliteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author oscarriveros
 */
@RestController
@EnableAutoConfiguration
public class QuasarController {

    private SatelliteTransmitterDTO satelliteTransmitterDTO;

    @Autowired
    private SatelliteInfoService satelliteInfoService;


    /**
     * getInformationTransmitter
     *
     * @param satellites
     * @param error
     * @return
     */
    @RequestMapping(value = "/topsecret", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<SatelliteTransmitterDTO> getInformationTransmitter(@RequestBody @Valid SatellitesRequestDTO satellites
            , BindingResult error) {
        ErrorValidator.manejarErroresValidacion(error);
        satelliteTransmitterDTO = satelliteInfoService.getSatelliteInfo(satellites);
        if (satelliteTransmitterDTO == null) {
            return new ResponseEntity<>(new SatelliteTransmitterDTO(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(satelliteTransmitterDTO, HttpStatus.OK);
        }
    }


    /**
     * getInformationTransmitterOneToOne
     *
     * @param satellite_name
     * @param sattelite
     * @param error
     * @return
     */
    @RequestMapping(value = "/topsecret_split/{satellite_name}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<HttpStatus> setInformationTransmitterOneToOne(@PathVariable String satellite_name,
                                                                 @RequestBody @Valid SatelliteRequestOnoToOneDTO sattelite, BindingResult error) {
        ErrorValidator.manejarErroresValidacion(error);
        if (satelliteInfoService.setInformationTransmitterOneToOne(satellite_name, sattelite)) {
            return new ResponseEntity<>(HttpStatus.OK, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * getInformationTransmitterResult
     *
     * @return
     */
    @RequestMapping(value = "/topsecret_split", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<SatelliteTransmitterDTO> getInformationTransmitterResult() {
        satelliteTransmitterDTO = satelliteInfoService.getInformationTransmitterResult();
        if (satelliteTransmitterDTO == null) {
            return new ResponseEntity<>(new SatelliteTransmitterDTO(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(satelliteTransmitterDTO, HttpStatus.OK);
        }
    }


    /**
     * getCheckStatus HealthCheck
     *
     * @return
     */
    @RequestMapping(value = "/topsecret/status", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})
    public @ResponseBody
    ResponseEntity<HttpStatus> getCheckStatus(){
        return new ResponseEntity<>(HttpStatus.OK, HttpStatus.OK);
    }
}

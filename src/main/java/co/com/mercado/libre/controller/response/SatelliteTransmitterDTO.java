package co.com.mercado.libre.controller.response;

import co.com.mercado.libre.business.object.Point;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SatelliteTransmitterDTO {

    private Point position;

    private String message;
}

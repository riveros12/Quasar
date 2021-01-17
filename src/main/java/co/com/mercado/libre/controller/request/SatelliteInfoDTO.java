package co.com.mercado.libre.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class SatelliteInfoDTO {
    @NotNull(message = "name: It cannot be null")
    @Valid
    private String name;
    @NotNull(message = "distance: It cannot be null")
    @Valid
    private Float  distance;
    @NotNull(message = "message: It cannot be null")
    @Valid
    private List<String> message;

}

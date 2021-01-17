package co.com.mercado.libre.controller.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class SatellitesRequestDTO {
    @NotNull(message = "satellites: It cannot be null")
    @Valid
    @Size(min=3, max=3)
    private List<SatelliteInfoDTO> satellites;
}

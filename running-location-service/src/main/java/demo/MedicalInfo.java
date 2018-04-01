package demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
@Data
@RequiredArgsConstructor
public class MedicalInfo {

    private final String vin;

    private long bfr;

    private long fmi;

    @SuppressWarnings("unused")
    private MedicalInfo() {
        this.vin = "";
    }

}

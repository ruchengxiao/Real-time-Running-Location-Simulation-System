package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrentPosition {
    private String runningId;
    private Point location;
    private RunnerStatus runnerStatus;
    private Double speed;
    private Double heading;
    //@Nike Running
    private FaultCode faultCode;
    private SupplyLocation supplyLocation;
    private int heartRate;
}

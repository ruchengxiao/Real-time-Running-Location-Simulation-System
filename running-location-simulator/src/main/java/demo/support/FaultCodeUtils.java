package demo.support;

import demo.model.FaultCode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility to provide random {@link FaultCode}s.
 */
public class FaultCodeUtils {
    /**
     * Private Constructor.
     * Suppress default constructor for non-instantiability
     */

    private FaultCodeUtils() {
        throw new AssertionError();
    }

    public static final List<FaultCode> faultCodes = new ArrayList<>(5);

    static {
        final FaultCode faultCode1 = new FaultCode();
        faultCode1.setBandMake("Fitbit");
        faultCode1.setFaultCode("LTP");
        faultCode1.setFaultCodeId("Fitbit");
        faultCode1.setFaultCodeClassification("ServiceInfo");
        faultCode1.setDescription("Low battery warning");
        faultCode1.setRepairInstructions("Recharge battery as soon as possible");
        faultCode1.setFmi("14");
        faultCode1.setSa(null);
        faultCode1.setBfr("3696");

        final FaultCode faultCode2 = new FaultCode();
        faultCode2.setBandMake("Fitbit");
        faultCode2.setFaultCode("MJR");
        faultCode2.setFaultCodeId("Fitbit");
        faultCode2.setFaultCodeClassification("ServiceSoon");
        faultCode2.setDescription("Band Failure");
        faultCode2.setRepairInstructions("Repair at store");
        faultCode2.setFmi("31");
        faultCode2.setSa(null);
        faultCode2.setBfr("3719");

        final FaultCode faultCode3 = new FaultCode();
        faultCode3.setBandMake("Fitbit");
        faultCode3.setFaultCode("FMW");
        faultCode3.setFaultCodeId("Fitbit");
        faultCode3.setFaultCodeClassification("ServiceInfo");
        faultCode3.setDescription("Firmware Upgrade Required");
        faultCode3.setRepairInstructions("Verify Software update has been completed if available for this Band.");
        faultCode3.setFmi("14");
        faultCode3.setSa(null);
        faultCode3.setBfr("171");

        final FaultCode faultCode4 = new FaultCode();
        faultCode4.setBandMake("Fitbit");
        faultCode4.setFaultCode("OHT");
        faultCode4.setFaultCodeId("Fitbit");
        faultCode4.setFaultCodeClassification("ServiceSoon");
        faultCode4.setDescription("Overheating Warning");
        faultCode4.setRepairInstructions("Cool it down");
        faultCode4.setFmi("15");
        faultCode4.setSa(null);
        faultCode4.setBfr("3719");

        final FaultCode faultCode5 = new FaultCode();
        faultCode5.setBandMake("Fitbit");
        faultCode5.setFaultCode("LOP");
        faultCode5.setFaultCodeId("Fitbit");
        faultCode5.setFaultCodeClassification("StopRunning");
        faultCode5.setDescription("Low battery warning");
        faultCode5.setRepairInstructions("Recharge battery");
        faultCode5.setFmi("7");
        faultCode5.setSa(null);
        faultCode5.setBfr("4334");

        faultCodes.add(faultCode1);
        faultCodes.add(faultCode2);
        faultCodes.add(faultCode3);
        faultCodes.add(faultCode4);
        faultCodes.add(faultCode5);
    }

    public static FaultCode getRandomFaultCode() {
        return faultCodes.get(ThreadLocalRandom.current().nextInt(faultCodes.size()));
    }
}

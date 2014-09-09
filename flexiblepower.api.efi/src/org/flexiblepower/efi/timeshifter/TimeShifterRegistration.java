package org.flexiblepower.efi.timeshifter;

import java.util.Date;

import javax.measure.Measurable;
import javax.measure.quantity.Duration;

import org.flexiblepower.rai.ControlSpaceRegistration;
import org.flexiblepower.rai.values.Commodity;

/**
 * To register an time shifter appliance driver to an energy service the time shifter registration class is used.
 * 
 * @author TNO
 */

public class TimeShifterRegistration extends ControlSpaceRegistration {

    private static final long serialVersionUID = 2453887214286161182L;

    /**
     * The set of all commodities that can be produced or consumed by the appliance.
     */
    private final Commodity.Set supportedCommodities;

    public TimeShifterRegistration(String resourceId,
                                   Date timestamp,
                                   Measurable<Duration> allocationDelay,
                                   Commodity.Set supportedCommodities) {
        super(resourceId, timestamp, allocationDelay);
        this.supportedCommodities = supportedCommodities;
    }

    public Commodity.Set getSupportedCommodities() {
        return supportedCommodities;
    }

    public boolean supportsCommodity(Commodity<?, ?> commodity) {
        return supportedCommodities.contains(commodity);
    }

}

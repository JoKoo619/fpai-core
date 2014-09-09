package org.flexiblepower.rai;

import java.util.Date;

import javax.measure.Measurable;
import javax.measure.quantity.Duration;

import org.flexiblepower.ral.ControllerManager;
import org.flexiblepower.time.TimeService;

/**
 * As soon as an appliance becomes available to an energy application (see {@link ControllerManager}), it will send a
 * {@link ControlSpaceRegistration} message. This message is used to inform the energy application about the
 * capabilities of the appliance. Each of the ControlSpace categories will have its own registration class that is
 * derived from this one. There are no additional attributes in this class. Attributes about specific capabilities are
 * added in the implementation classes.
 */
public abstract class ControlSpaceRegistration extends ResourceMessage {
    private static final long serialVersionUID = 8841022716486854027L;

    private final Measurable<Duration> allocationDelay;

    /**
     * Constructs the {@link ControlSpaceRegistration} object with the given parameters.
     *
     * @param resourceId
     *            The resource identifier
     * @param timestamp
     *            The moment when this constructor is called (should be {@link TimeService#getTime()})
     * @param allocationDelay
     *            The duration of the delay in communications channel from the moment of sending to the moment the
     *            command is executed up by the device.
     */
    public ControlSpaceRegistration(String resourceId, Date timestamp, Measurable<Duration> allocationDelay) {
        super(resourceId, timestamp);
        this.allocationDelay = allocationDelay;
    }

    /**
     *
     * @return The duration of the delay in communications channel from the moment of sending to the moment the command
     *         is executed up by the device.
     */
    public Measurable<Duration> getAllocationDelay() {
        return allocationDelay;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((allocationDelay == null) ? 0 : allocationDelay.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        ControlSpaceRegistration other = (ControlSpaceRegistration) obj;
        if (allocationDelay == null) {
            if (other.allocationDelay != null) {
                return false;
            }
        } else if (!allocationDelay.equals(other.allocationDelay)) {
            return false;
        }
        return true;
    }
}

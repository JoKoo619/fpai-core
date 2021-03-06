package org.flexiblepower.ral.values;

import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;
import javax.measure.quantity.VolumetricFlowRate;

/**
 * The {@link CommodityUncertainMeasurables} is used to store a {@link UncertainMeasure} for each {@link Commodity}.
 */
public final class CommodityUncertainMeasurables extends CommodityMap<UncertainMeasure<?>> {
    /**
     * <p>
     * This helper class makes it easy to create an instance of the {@link CommodityUncertainMeasurables}. To create an
     * instance of this class, use {@link CommodityUncertainMeasurables#create()}.
     * </p>
     *
     * <p>
     * Typical usage looks like this:
     * </p>
     *
     * <p>
     * <code>CommodityUncertainMeasure measure = CommodityUncertainMeasure.create().electricity(electricityMeasure).gas(gasMeasure).build();</code>
     * </p>
     */
    public static class Builder {
        private UncertainMeasure<Power> electricityValue, heatValue;
        private UncertainMeasure<VolumetricFlowRate> gasValue;

        protected Builder() {
        }

        public Builder electricity(UncertainMeasure<Power> value) {
            electricityValue = value;
            return this;
        }

        public Builder gas(UncertainMeasure<VolumetricFlowRate> value) {
            gasValue = value;
            return this;
        }

        public Builder heat(UncertainMeasure<Power> value) {
            heatValue = value;
            return this;
        }

        public CommodityUncertainMeasurables build() {
            return new CommodityUncertainMeasurables(electricityValue, gasValue, heatValue);
        }
    }

    /**
     * @return A new {@link Builder} object that can be used to create the {@link CommodityUncertainMeasurables} more
     *         easily.
     */
    public static Builder create() {
        return new Builder();
    }

    /**
     * @param electricityValue
     *            The measurable value of the electricity
     * @return A {@link CommodityUncertainMeasurables} which only contains a value for {@link Commodity#ELECTRICITY}
     */
    public static CommodityUncertainMeasurables electricity(UncertainMeasure<Power> electricityValue) {
        return new CommodityUncertainMeasurables(electricityValue, null, null);
    }

    /**
     * @param gasValue
     *            The measurable value of the gas
     * @return A {@link CommodityUncertainMeasurables} which only contains a value for {@link Commodity#GAS}
     */
    public static CommodityUncertainMeasurables gas(UncertainMeasure<VolumetricFlowRate> gasValue) {
        return new CommodityUncertainMeasurables(null, gasValue, null);
    }

    /**
     * @param heatValue
     *            The measurable value of the heat
     * @return A {@link CommodityUncertainMeasurables} which only contains a value for {@link Commodity#HEAT}
     */
    public static CommodityUncertainMeasurables heat(UncertainMeasure<Power> heatValue) {
        return new CommodityUncertainMeasurables(null, null, heatValue);
    }

    CommodityUncertainMeasurables(UncertainMeasure<Power> electricityValue,
                                  UncertainMeasure<VolumetricFlowRate> gasValue,
                                  UncertainMeasure<Power> heatValue) {
        super(electricityValue, gasValue, heatValue);
    }

    @SuppressWarnings("unchecked")
    public <BQ extends Quantity, FQ extends Quantity> UncertainMeasure<FQ> get(Commodity<BQ, FQ> commodity) {
        return (UncertainMeasure<FQ>) super.get(commodity);
    }
}

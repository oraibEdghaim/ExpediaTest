package Models;

import com.google.gson.annotations.SerializedName;

public class hotelPricingInfo {

    @SerializedName("averagePriceValue")
    double averagePriceValue;

    public double getAveragePriceValue() {
        return averagePriceValue;
    }

    public void setAveragePriceValue(double averagePriceValue) {
        this.averagePriceValue = averagePriceValue;
    }
}

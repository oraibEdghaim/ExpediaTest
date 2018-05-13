package Models;

import com.google.gson.annotations.SerializedName;

public class Hotel {

    @SerializedName("hotelInfo")
    hotelInfo hotelInfo;

    @SerializedName("hotelPricingInfo")
    hotelPricingInfo hotelPricingInfo;

    public hotelInfo getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelInfo(hotelInfo hotelInfo) {
        this.hotelInfo = hotelInfo;
    }

    public hotelPricingInfo getHotelPricingInfo() {
        return hotelPricingInfo;
    }

    public void setHotelPricingInfo(hotelPricingInfo hotelPricingInfo) {
        this.hotelPricingInfo = hotelPricingInfo;
    }
}

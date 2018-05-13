package Models;

import com.google.gson.annotations.SerializedName;

public class hotelInfo {

    @SerializedName("hotelName")
    String hotelName;

    @SerializedName("hotelStarRating")
    double hotelStarRating;

    @SerializedName("hotelGuestReviewRating")
    double hotelGuestReviewRating;

    @SerializedName("hotelImageUrl")
    String hotelImageUrl;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getHotelStarRating() {
        return hotelStarRating;
    }

    public void setHotelStarRating(double hotelStarRating) {
        this.hotelStarRating = hotelStarRating;
    }

    public double getHotelGuestReviewRating() {
        return hotelGuestReviewRating;
    }

    public void setHotelGuestReviewRating(double hotelGuestReviewRating) {
        this.hotelGuestReviewRating = hotelGuestReviewRating;
    }

    public String getHotelImageUrl() {
        return hotelImageUrl;
    }

    public void setHotelImageUrl(String hotelImageUrl) {
        this.hotelImageUrl = hotelImageUrl;
    }
}

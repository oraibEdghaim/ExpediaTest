package Controller;

import Models.Hotel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;


public class SearchController {

    final  Logger log = Logger.getLogger(SearchController.class);


    final String DESTINATION_NAME = "destinationName";
    final String MIN_TRIP_START_DATE = "minTripStartDate";
    final String MAX_TRIP_START_DATE = "maxTripStartDate";
    final String LENGTH_OF_STAY = "lengthOfStay";
    final String MIN_STAR_RATING = "minStarRating";
    final String MAX_STAR_RATING = "maxStarRating";

    final String URL = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&" +
            "productType=Hotel";


    String getSearchResult(String params){

        try {
            URL url = null;
            HttpURLConnection connection;
            url = new URL(URL + params);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            log.info("search Result:\n"+response);
            return response.toString();

        } catch (MalformedURLException | ProtocolException e) {
            log.fatal("maybe Expedia search API is Down:\n" + Arrays.toString(e.getStackTrace()));
        } catch (IOException e) {
            log.error("Error when reading Expedia API request response :\n" + Arrays.toString(e.getStackTrace()));
        }
        return "";
    }

    List<Hotel> getHotels(JSONArray hotels){
        Gson gson = new Gson();
        List<Hotel> list = new ArrayList<>();
        for(Object object:hotels)
            list.add(gson.fromJson(object.toString(),Hotel.class));
        return list;
    }
    String formatAndValidateDate(String date){

        return date;

    }
    String getAllParams(Map<String,String[]> params){

        StringBuilder str = new StringBuilder();
        if(params.containsKey(DESTINATION_NAME )) {
            str.append("&" + DESTINATION_NAME + "=").append(params.get(DESTINATION_NAME )[0]);
        }

        if(params.containsKey(MIN_TRIP_START_DATE) ){
            String formattedDate = formatAndValidateDate(params.get(MIN_TRIP_START_DATE)[0]);
            str.append("&" + MIN_TRIP_START_DATE + "=").append(formattedDate);
        }

        if(params.containsKey(MAX_TRIP_START_DATE) ){
            String formattedDate = formatAndValidateDate(params.get(MAX_TRIP_START_DATE)[0]);
            str.append("&" + MAX_TRIP_START_DATE + "=").append(formattedDate);
        }

        if(params.containsKey(LENGTH_OF_STAY )){
            str.append("&" + LENGTH_OF_STAY + "=").append(params.get(LENGTH_OF_STAY )[0]);
        }

        if(params.containsKey(MIN_STAR_RATING )){
            str.append("&" + MIN_STAR_RATING + "=").append(params.get(MIN_STAR_RATING)[0]);
        }

        if(params.containsKey(MAX_STAR_RATING )){
            str.append("&" + MAX_STAR_RATING + "=").append(params.get(MAX_STAR_RATING )[0]);
        }
        return str.toString();
    }
    public Object doSearch(Map<String,String[]> params){

        String requestParams = getAllParams(params);
        String str = getSearchResult(requestParams);
        JSONObject jsonResult = new JSONObject(str);
        JSONArray jsonHotels = jsonResult.getJSONObject("offers").getJSONArray("Hotel");

        List<Hotel> hotels = getHotels(jsonHotels);

        Gson gson = new Gson();
        JsonArray result = new JsonArray();
        hotels.stream().map(gson::toJson).collect(Collectors.toList()).forEach(result::add);
        return result;

    }
}

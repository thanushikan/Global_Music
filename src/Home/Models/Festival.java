package Home.Models;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.math.BigInteger;

public class Festival {

    private int id;
    private String city;
    private String postcode;
    private String date;
    private String festival_name;
    private String venue;
    private String description;
    private String tickets_available;
    private String line_up_id;
    private String ticket_price;
    private String event_type;


    public Festival() {

}
//ask Jack about String line up ID; id not this parameter
    public Festival(String city,String postcode,String date,String festival_name,String venue,String description,String tickets_available,
                    String line_up_id,String ticket_price,String event_type){
        this.city = city; this.postcode = postcode; this.date = date; this.festival_name = festival_name; this.venue = venue; this.description = description;
        this.tickets_available = tickets_available; this.line_up_id = line_up_id; this.ticket_price = ticket_price;this.event_type = event_type;
    }

    public int getId() {
            return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getCity(){
        return city;
    }
    public void setCity(String city){this.city = city;}

    public String getPostcode(){
        return postcode;
    }
    public void setPostcode(String postcode){this.postcode = postcode;}

    public String getDate(){
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getFestival_name(){
        return festival_name;
    }
    public void setFestival_name(String festival_name) {
        this.festival_name = festival_name;
    }

    public String getVenue(){
        return venue;
    }
    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTickets_available(){
        return tickets_available;
    }
    public void setTickets_available(String tickets_available) {
        this.tickets_available = tickets_available;
    }

    public String getLine_up_id(){
        return line_up_id;
    }
    public void setLine_up_id(String line_up_id) {
        this.line_up_id = line_up_id;
    }

    public String getTicket_price(){
        return ticket_price;
    }
    public void setTicket_price(String ticket_price) {
        this.ticket_price = ticket_price;
    }

    public String getEvent_type(){
        return event_type;
    }
    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }
}





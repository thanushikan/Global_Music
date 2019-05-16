package Home.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Festival {

    private int id;
    private String city;
    private String postcode;
    private String date;
    private String festival_name;
    private String venue;
    private String description;
    private String tickets_available;
    private String band_id;
    private String ticket_price;
    private String event_type;

    public Festival() {}

    public Festival(String city, String postcode, String date, String festival_name, String venue, String description, String tickets_available,
                    String band_id, String ticket_price, String event_type){
        this.city = city; this.postcode = postcode; this.date = date; this.festival_name = festival_name; this.venue = venue; this.description = description;
        this.tickets_available = tickets_available; this.band_id = band_id; this.ticket_price = ticket_price;this.event_type = event_type;
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


   public String getDate(boolean ukformat) {
        System.out.print(this.date);
        if (ukformat){
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
            Date ndate= null;
            try {
                ndate = format1.parse(this.date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return format2.format(ndate);
        }
        else{
            return this.date;
        }

    }



    public void setDate(boolean ukformat, String date){
        if (ukformat){
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
            Date ndate= null;
            try {
                ndate = format1.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            this.date = format2.format(ndate);
            System.out.print(this.date);
        }
        else{
            if (!date.contains("-")){
                SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                Date ndate= null;
                try {
                    ndate = format1.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                this.date= format2.format(ndate);
                System.out.print(this.date);
            }
            else{
                this.date = date;
            }

        }
    }

   /* public String getDate(){return date;}
    public void setDate(String date){this.date = date;}
    */
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

    public String getBand_id(){
        return band_id;
    }
    public void setBand_id(String band_id) {
        this.band_id = band_id;
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





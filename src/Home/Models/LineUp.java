package Home.Models;

public class LineUp
{
    private int id;
    private String performance_time;
    private String artist_id;
    private String performance_name;

    public LineUp(){}

    public LineUp(String performance_time,String artist_id,String performance_name){
        this.performance_time = performance_time;this.artist_id = artist_id;this.performance_name = performance_name;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getPerformance_time(){return performance_time;}
    public void setPerformance_time(String performance_time){this.performance_time=performance_time;}

    public String getArtist_id(){return artist_id;}
    public void setArtist_id(String artist_id){this.artist_id = artist_id;}

    public String getPerformance_name(){return performance_name;}

    public void setPerformance_name(String performance_name) {
        this.performance_name = performance_name; }
}

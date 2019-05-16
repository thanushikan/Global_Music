package Home.Models;

public class Band
{
    private int id;
    private String agentId;
    private String bandName;

    public Band(){}

    public Band( String artist_id, String band_name){
        this.agentId = artist_id;this.bandName = band_name;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getAgentId(){return agentId;}
    public void setAgentId(String agentId){this.agentId = agentId;}

    public String getBandName(){return bandName;}

    public void setBandName(String bandName) {
        this.bandName = bandName; }
}

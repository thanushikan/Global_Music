package Home.Models;

public class Artist {

    private int id;
    private String first_name;
    private String last_name;
    private String agent_id;


    public Artist(){

    }

    public Artist(String first_name,String last_name){this.first_name = first_name; this.last_name = last_name;}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAgent_id(){return agent_id;}
    public void setAgent_id(String agent_id){
        this.agent_id = agent_id;
    }



}




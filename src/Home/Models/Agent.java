package Home.Models;

import java.math.BigInteger;

public class Agent {


    private int id;
    private String first_name;
    private String last_name;
    private String agent_email;
    private BigInteger agent_contact_no;


   public Agent(){

    }
    public Agent(String first_name,String last_name,String agent_email, BigInteger agent_contact_no)
    {this.first_name = first_name; this.last_name = last_name; this.agent_email = agent_email; this.agent_contact_no =agent_contact_no;}

    public int getId() {
        return id;
    }
    public void setId(int id){this.id = id;}

    public String getFirst_name(){
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

    public String getAgent_email() {
        return agent_email;
    }
    public void setAgent_email(String agent_email) {
        this.agent_email = agent_email;
    }

    public BigInteger getAgent_contact_no() {
        return agent_contact_no;
    }
    public void setAgent_contact_no(BigInteger agent_contact_no) {
        this.agent_contact_no = agent_contact_no;
    }



}



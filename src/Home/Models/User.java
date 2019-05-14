package Home.Models;

import java.math.BigInteger;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class User {

    private int id;
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String county;
    private String postcode;
    private String dob;
    private String contactName;
    private String organisationName;
    private String emailAddress;
    private BigInteger phoneNumber;
    private BigInteger mobileNumber;
    private String webAddress;
    private String password;
    private Boolean isCorporate;
    private Boolean isAdmin;
    private Boolean isOrganiser;

    public User(){

    }

    public User(String title,String firstName,String lastName,String gender,String addressLine1,String addressLine2,String town,String county,
                String postcode,String dob,String contactName,String organisationName,String emailAddress,BigInteger phoneNumber,BigInteger mobileNumber,
                String webAddress, String password,Boolean isCorporate,Boolean isAdmin,Boolean isOrganiser) {
                this.title = title; this.firstName=firstName; this.lastName=lastName; this.gender = gender; this.addressLine1 =addressLine1;
                this.addressLine2 = addressLine2; this.town = town; this.county =county; this.postcode = postcode;
                this.setDOB(false,dob);this.contactName=contactName;
                this.organisationName=organisationName; this.emailAddress=emailAddress;this.phoneNumber=phoneNumber;this.mobileNumber=mobileNumber;this.webAddress=webAddress;
                this.password=password; this.isCorporate=isCorporate;this.isAdmin=isAdmin;this.isOrganiser=isOrganiser;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setTitle(String title){this.title = title; }
    public String getTitle() {return title;}
    public void setGender(String gender){this.gender = gender; }
    public String getGender() {return gender;}
    public void setAddressLine1(String addressLine1){this.addressLine1 = addressLine1; }
    public String getAddressLine1() {return addressLine1;}
    public void setAddressLine2(String addressLine2){this.addressLine2 = addressLine2; }
    public String getAddressLine2() {return addressLine2;}
    public void setTown(String town){this.town = town; }
    public String getTown() {return town;}
    public void setCounty(String county){this.county = county; }
    public String getCounty() {return county;}
    public void setPostcode(String postcode){this.postcode = postcode; }
    public String getPostcode() {return postcode;}

    public void setDOB(boolean ukformat,String dob){
        if (ukformat){
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
            Date date= null;
            try {
                date = format1.parse(dob);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            this.dob= format2.format(date);
            System.out.print(this.dob);
        }
        else{
            if (!dob.contains("-")){
                SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                Date date= null;
                try {
                    date = format1.parse(dob);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                this.dob= format2.format(date);
                System.out.print(this.dob);
               }
            else{
                this.dob = dob;
            }

        }

    }

    public String getDOB(boolean ukformat){
        System.out.print(this.dob);
        if (ukformat){
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
            Date date= null;
            try {
                date = format1.parse(this.dob);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return format2.format(date);
        }
        else{
            return this.dob;
        }
      }

    public void setContactName(String contactName){this.contactName = contactName; }
    public String getContactName() {return contactName;}
    public void setOrganisationName(String organisationName){this.organisationName = organisationName; }
    public String getOrganisationName() {return organisationName;}
    public void setEmailAddress(String emailAddress){this.emailAddress = emailAddress; }
    public String getEmailAddress() {
        System.out.println(this.emailAddress);
        return this.emailAddress;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber = new BigInteger(phoneNumber); }
    public String getPhoneNumber() {return this.phoneNumber.toString();}
    public void setMobileNumber(String mobileNumber){this.mobileNumber = new BigInteger(mobileNumber); }
    public String getMobileNumber() {return this.mobileNumber.toString();}
    public void setWebAddress(String webAddress){this.webAddress = webAddress; }
    public String getWebAddress() {return webAddress;}
    public void setPassword(String password){this.password = password; }
    public String getPassword() {return password;}
    public void setIsCorporate(boolean isCorporate){this.isCorporate = isCorporate; }
    public boolean getIsCorporate() {return isCorporate;}
    public void setIsAdmin(boolean isAdmin){this.isAdmin = isAdmin; }
    public boolean getIsAdmin() {return isAdmin;}
    public void setIsOrganiser(boolean isOrganiser){this.isOrganiser = isOrganiser; }
    public boolean getIsOrganiser() {return isOrganiser;}

}
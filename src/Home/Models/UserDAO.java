package Home.Models;
import java.sql.*;
import java.util.List;
// one DAO Class per table or per view
// use CRUD Create , retrieve, update, delete
public class UserDAO {



    public boolean registerPaymentDetails(String charge, String cardNo, String expireDate, String cardholderName, String cvsNo)throws SQLException {
        boolean queryPassed = true;
        Connection connection = DatabaseUtility.getInstance().getConnection();
       // String querySql = "INSERT INTO `payment` (`id`, `charge`, `card_no`, `expire_Date`, `cardholder_Name`, `cvs_No`) VALUES" +
        //        "(NULL, '"+charge+"', '"+cardNo+"', '"+expireDate+"', '"+cardholderName+"', '"+cvsNo+"');";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement  = connection.prepareStatement("INSERT INTO `payment` (`id`, `charge`, `card_no`, `expire_Date`, `cardholder_Name`, `cvs_No`) " +
                     "VALUES(NULL, '?', '?', '?', '?', '?');");
            preparedStatement.setString(1,charge);
            preparedStatement.setString(2,cardNo);
            preparedStatement.setString(3,expireDate);
            preparedStatement.setString(4,cardholderName);
            preparedStatement.setString(5,cvsNo);

            preparedStatement.executeUpdate();
        }
        catch (Exception ex){
            System.out.println(ex.fillInStackTrace());
            queryPassed = false;
        }
        finally {
            preparedStatement.close();//Issue with exception handling check later once payment model is made!!!
            return queryPassed;
        }
    }

    public boolean registerUser(User user ){
        boolean queryPassed = true;
        Connection connection = DatabaseUtility.getInstance().getConnection();
        //  String sql= "INSERT INTO `USER` (`id`,`title`,`first_name`,`last_name`,`gender`,`address_line`,`address_line2`,`town`,`county`,`postcode`,`dob`,`contact_name`,`organisation_name`,`email_address`,`phone_no`,`mobile_no`,`web_address`,`password`,`is_corporate`,`is_admin`,is_organiser) VALUES (null,'MR','jamie','blunt','female','woburn street','ampthill','ampthill','bedfordshire','mk325ph','2019-05-08','jamie','','jamesBlunts@yahoo.com','01536233740','0757465475','www.happywheels.com','password',FALSE,FALSE,FALSE);";
       // System.out.println(title +firstName+lastName+gender+addressLine1+addressLine2+town+county+postcode+dob+contactName+organisationName+emailAddress+phoneNo+mobileNo+webAddress+password+isCorporate.toString()+isAdmin.toString()+isOrganiser.toString());
        int tinyintIsAdmin,tinyintIsCorporate,tinyintIsOrganiser;
        if (user.getIsAdmin() == false)
        {
         tinyintIsAdmin =0;
        }
        else{
            tinyintIsAdmin =1;
        }

        if (user.getIsCorporate() == false)
        {
            tinyintIsCorporate =0;
        }
        else{
            tinyintIsCorporate =1;
        }

        if ( user.getIsOrganiser() == false)
        {
            tinyintIsOrganiser =0;
        }
        else   {
            tinyintIsOrganiser =1;
        }
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO `USER` " +
                            "(`title`,`first_name`,`last_name`,`gender`,`address_line`,`address_line2`,`town`,`county`," +
                            "`postcode`,`dob`,`contact_name`,`organisation_name`,`email_address`,`phone_no`,`mobile_no`," +
                            "`web_address`,`password`,`is_corporate`,`is_admin`,`is_organiser`)" +
                            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1,user.getTitle());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,user.getGender());
            preparedStatement.setString(5,user.getAddressLine1());
            preparedStatement.setString(6,user.getAddressLine2());
            preparedStatement.setString(7,user.getTown());
            preparedStatement.setString(8,user.getCounty());
            preparedStatement.setString(9,user.getPostcode());
            preparedStatement.setString(10,user.getDOB());
            System.out.println(preparedStatement);
            preparedStatement.setString(11,user.getContactName());
            preparedStatement.setString(12,user.getOrganisationName());
            preparedStatement.setString(13,user.getEmailAddress());
            preparedStatement.setString(14,user.getPhoneNumber());
            preparedStatement.setString(15,user.getMobileNumber());
            preparedStatement.setString(16,user.getWebAddress());
            preparedStatement.setString(17,user.getPassword());
            preparedStatement.setString(18, String.valueOf(tinyintIsCorporate));
            preparedStatement.setString(19,String.valueOf(tinyintIsAdmin));
            preparedStatement.setString(20,String.valueOf(tinyintIsOrganiser));

            System.out.println(preparedStatement);
            preparedStatement.execute();

        }
        catch (Exception  ex){
            System.out.println(ex.fillInStackTrace());
            queryPassed = false;
        }
        finally {
            return queryPassed;
        }

    }

   public boolean LoginUser(String email,String password)
    {
        boolean queryPassed = true;
        try{
          PreparedStatement preparedStatement= DatabaseUtility.getInstance().getConnection().prepareStatement("SELECT * FROM `user` WHERE `email_address` = ? AND `password` = ?;");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            preparedStatement.executeQuery();
        }
        catch (Exception ex){
            System.out.println(ex.fillInStackTrace());
            queryPassed = false;
        }
        finally {
            return queryPassed;
        }
    }

    public void addUser(){

    }


    public User getUser(String email) throws SQLException{
        User user = null;
        PreparedStatement preparedStatement = DatabaseUtility.getInstance().getConnection().prepareStatement("SELECT * FROM `user` WHERE `email_address` = ?;");
       preparedStatement.setString(1,email);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
                user= new User();
                user.setId(rs.getInt("id"));
                user.setTitle(rs.getString("title"));
                user.setFirstName(rs.getString("first_name"));
                user.setFirstName(rs.getString("last_name"));
                user.setGender(rs.getString("gender"));
                user.setAddressLine1(rs.getString("address_line"));
                user.setAddressLine2(rs.getString("address_line2"));
                user.setTown(rs.getString("town"));
                user.setCounty(rs.getString("county"));
                user.setPostcode(rs.getString("postcode"));
                user.setDOB(rs.getString("dob"));
                user.setContactName(rs.getString("contact_name"));
                user.setOrganisationName(rs.getString("organisation_name"));
                user.setEmailAddress(rs.getString("email_address"));
                user.setPhoneNumber(rs.getString("phone_no"));
                user.setMobileNumber(rs.getString("mobile_no"));
                user.setWebAddress(rs.getString("web_address"));
                user.setPassword(rs.getString("password"));
                user.setIsCorporate(rs.getBoolean("is_corporate"));
                user.setIsAdmin(rs.getBoolean("is_admin"));
                user.setIsOrganiser(rs.getBoolean("is_organiser"));

            }


        return  user;

    }

    public List<User> getUsers(){
        return null;
    }

    public void updateUser(User user){

    }

    public void deleteUser(String email){
        //https://www.youtube.com/watch?v=rW8HtUV5D7g
    }
}

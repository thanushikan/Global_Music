package Home.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// one DAO Class per table or per view
// use CRUD Create , retrieve, update, delete
public class UserDAO {

    public boolean registerUser(User user) {
        boolean queryPassed = true;
        Connection connection = DatabaseUtility.getInstance().getConnection();
        int tinyintIsAdmin, tinyintIsCorporate, tinyintIsOrganiser;
        if (user.getIsAdmin() == false) {
            tinyintIsAdmin = 0;
        } else {
            tinyintIsAdmin = 1;
        }

        if (user.getIsCorporate() == false) {
            tinyintIsCorporate = 0;
        } else {
            tinyintIsCorporate = 1;
        }

        if (user.getIsOrganiser() == false) {
            tinyintIsOrganiser = 0;
        } else {
            tinyintIsOrganiser = 1;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `USER` " +
                    "(`title`,`first_name`,`last_name`,`gender`,`address_line`,`address_line2`,`town`,`county`," +
                    "`postcode`,`dob`,`contact_name`,`organisation_name`,`email_address`,`contact_no`,`mobile_no`," +
                    "`web_address`,`password`,`is_corporate`,`is_admin`,`is_organiser`)" +
                    " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, user.getTitle());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setString(5, user.getAddressLine1());
            preparedStatement.setString(6, user.getAddressLine2());
            preparedStatement.setString(7, user.getTown());
            preparedStatement.setString(8, user.getCounty());
            preparedStatement.setString(9, user.getPostcode());
            preparedStatement.setString(10, user.getDOB(false));
            System.out.println(preparedStatement);
            preparedStatement.setString(11, user.getContactName());
            preparedStatement.setString(12, user.getOrganisationName());
            preparedStatement.setString(13, user.getEmailAddress());
            preparedStatement.setString(14, user.getContactNumber());
            preparedStatement.setString(15, user.getMobileNumber());
            preparedStatement.setString(16, user.getWebAddress());
            preparedStatement.setString(17, user.getPassword());
            preparedStatement.setString(18, String.valueOf(tinyintIsCorporate));
            preparedStatement.setString(19, String.valueOf(tinyintIsAdmin));
            preparedStatement.setString(20, String.valueOf(tinyintIsOrganiser));

            System.out.println(preparedStatement);
            preparedStatement.execute();

        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());
            queryPassed = false;
        } finally {
            return queryPassed;
        }

    }

    public boolean LoginUser(String email, String password) {
        boolean queryPassed = false;
        try {
            PreparedStatement preparedStatement = DatabaseUtility.getInstance().getConnection().prepareStatement("SELECT * FROM `user` WHERE `email_address` = ? AND `password` = ?;");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                queryPassed = true;
            } else queryPassed = false;
        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());
            queryPassed = false;
        } finally {

            return queryPassed;
        }
    }

    public void addUser() {

    }


    public User getUser(String email) throws SQLException {
        User user = null;
        PreparedStatement preparedStatement = DatabaseUtility.getInstance().getConnection().prepareStatement("SELECT * FROM `user` WHERE `email_address` = ?;");
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            user = SetUserDetails(rs);
        }
        return user;
    }

    public static List<User> getUsers() throws SQLException {
        User user = null;
        List<User> users = new ArrayList<User>();
        PreparedStatement preparedStatement = DatabaseUtility.getInstance().getConnection().prepareStatement("SELECT * FROM `user` ");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            user = SetUserDetails(rs);
            users.add(user);
        }


        return users;
    }

    private static User SetUserDetails(ResultSet rs) throws SQLException {
        User user;
        user = new User();
        user.setId(rs.getInt("id"));
        user.setTitle(rs.getString("title"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setGender(rs.getString("gender"));
        user.setAddressLine1(rs.getString("address_line"));
        user.setAddressLine2(rs.getString("address_line2"));
        user.setTown(rs.getString("town"));
        user.setCounty(rs.getString("county"));
        user.setPostcode(rs.getString("postcode"));
        user.setDOB(false, rs.getString("dob"));
        user.setContactName(rs.getString("contact_name"));
        user.setOrganisationName(rs.getString("organisation_name"));
        user.setEmailAddress(rs.getString("email_address"));
        user.setContactNumber(rs.getString("contact_no"));
        user.setMobileNumber(rs.getString("mobile_no"));
        user.setWebAddress(rs.getString("web_address"));
        user.setPassword(rs.getString("password"));
        user.setIsCorporate(rs.getBoolean("is_corporate"));
        user.setIsAdmin(rs.getBoolean("is_admin"));
        user.setIsOrganiser(rs.getBoolean("is_organiser"));
        return user;
    }

    public void updateUser(User user) throws SQLException {
        int tinyintIsAdmin, tinyintIsCorporate, tinyintIsOrganiser;
        if (user.getIsAdmin() == false) {
            tinyintIsAdmin = 0;
        } else {
            tinyintIsAdmin = 1;
        }

        if (user.getIsCorporate() == false) {
            tinyintIsCorporate = 0;
        } else {
            tinyintIsCorporate = 1;
        }

        if (user.getIsOrganiser() == false) {
            tinyintIsOrganiser = 0;
        } else {
            tinyintIsOrganiser = 1;
        }
        //  PreparedStatement preparedStatement = DatabaseUtility.getInstance().getConnection().prepareStatement("UPDATE `user` SET `id`=`?`,`title`=`?`,`first_name`=`?`,`last_name`=`?`,`gender`=`?`,`address_line`=`?`,`address_line2`=`?`,`town`=`?`,`county`=`?`,`postcode`=`?`,`dob`=`?`,`contact_name`=`?`,`organisation_name`=`?`,`email_address`=`?`,`phone_no`=`?`,`mobile_no`=`?`,`web_address`=`?`,`password`=`?`,`is_corporate`=`?`,`is_admin`=`?`,`is_organiser`=`?` WHERE `id`=`?`;");
        PreparedStatement preparedStatement = DatabaseUtility.getInstance().getConnection().prepareStatement("UPDATE `user` SET `id`=?,`title`=?,`first_name`=?,`last_name`=?,`gender`=?,`address_line`=?,`address_line2`=?,`town`=?,`county`=?,`postcode`=?,`dob`=?,`contact_name`=?,`organisation_name`=?,`email_address`=?,`contact_no`=?,`mobile_no`=?,`web_address`=?,`password`=?,`is_corporate`=?,`is_admin`=?,`is_organiser`=? WHERE `id`=?;");

        System.out.println(preparedStatement);
        preparedStatement.setString(1, (String.valueOf(user.getId())));
        preparedStatement.setString(2, user.getTitle());
        preparedStatement.setString(3, user.getFirstName());
        preparedStatement.setString(4, user.getLastName());
        preparedStatement.setString(5, user.getGender());
        preparedStatement.setString(6, user.getAddressLine1());
        preparedStatement.setString(7, user.getAddressLine2());
        preparedStatement.setString(8, user.getTown());
        preparedStatement.setString(9, user.getCounty());
        preparedStatement.setString(10, user.getPostcode());
        preparedStatement.setString(11, user.getDOB(false));
        System.out.println(preparedStatement);
        preparedStatement.setString(12, user.getContactName());
        preparedStatement.setString(13, user.getOrganisationName());
        preparedStatement.setString(14, user.getEmailAddress());
        preparedStatement.setString(15, user.getContactNumber());
        preparedStatement.setString(16, user.getMobileNumber());
        preparedStatement.setString(17, user.getWebAddress());
        preparedStatement.setString(18, user.getPassword());
        preparedStatement.setString(19, String.valueOf(tinyintIsCorporate));
        preparedStatement.setString(20, String.valueOf(tinyintIsAdmin));
        preparedStatement.setString(21, String.valueOf(tinyintIsOrganiser));
        preparedStatement.setString(22, (String.valueOf(user.getId())));
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    public void deleteUser(String email) {
        //https://www.youtube.com/watch?v=rW8HtUV5D7g
    }
}

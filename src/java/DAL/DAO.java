/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Human;
import Model.HumanType;
import java.util.Date;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author admin
 */
public class DAO extends DBContext {

    public DAO() {
    }

    public ArrayList<Human> getHuman() {
        ArrayList<Human> humans = new ArrayList<>();
        try {
            String sql = "select h.*, ht.*\n"
                    + "from Human h inner join HumanType ht on h.typeID = ht.typeId  ";

            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Human h = new Human();
                h.setID(rs.getInt("humanId"));
                h.setName(rs.getString("humanName"));
                h.setDob(rs.getDate("humanDOB"));
                h.setGender(rs.getBoolean("humanGender"));

                HumanType ht = new HumanType();

                ht.setTypeId(rs.getInt("typeId"));
                ht.setName(rs.getString("typeName"));

                h.setType(ht);

                humans.add(h);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return humans;
    }

    public void insertHuman(Human u) {

        String sql = "INSERT INTO [dbo].[Human]\n"
                + "           ([humanId]\n"
                + "           ,[humanName]\n"
                + "           ,[humanDOB]\n"
                + "           ,[humanGender]\n"
                + "           ,[typeID])\n"
                + "     VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, u.getID());
            ps.setString(2, u.getName());
            ps.setDate(3, u.getDob());
            ps.setBoolean(4, u.isGender());
            ps.setInt(5, u.getType().getTypeId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public  HumanType getTypeNameById(int id){
        String sql = "select * from HumanType\n" +
                    "where typeId = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new HumanType(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<HumanType> getListHumanType(){
        List<HumanType> listHumanType = new ArrayList<>();
        
        String sql = "select * from HumanType";
        
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                listHumanType.add(new HumanType(rs.getInt(1), rs.getString(2)));
            }
            
        } catch (Exception e) {
        }
        return listHumanType;
    }
    
    public void removeHuman(int id){
        String sql = "DELETE FROM [dbo].[Human]\n" +
                "WHERE humanId = ?";
        
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateHuman(Human human){
        String sql = "UPDATE [dbo].[Human]\n" +
"   SET \n" +
"      [humanName] = ?\n" +
"      ,[humanDOB] = ?\n" +
"      ,[humanGender] = ?\n" +
"      ,[typeID] = ?\n" +
" WHERE humanId = ?";
        
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
           
            ps.setString(1, human.getName());
            ps.setDate(2, human.getDob());
            ps.setBoolean(3, human.isGender());
            ps.setInt(4, human.getType().getTypeId());
            ps.setInt(5, human.getID());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Human getHumanById(int id){
        String sql = "select h.*, ht.*from Human h inner join HumanType ht on h.typeID = ht.typeId\n" +
                    "where h.humanId = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);       
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                HumanType ht = new HumanType(rs.getInt(6), rs.getString(7));
                return new Human(rs.getInt(1), rs.getString(2), rs.getDate(3),rs.getBoolean(4), ht);
            }
        } catch (Exception e) {
        }
        return null;
    }
    

    public static void main(String[] args) {
        DAO dao = new DAO();

        ArrayList<Human> list = dao.getHuman();

        for (Human human : list) {
            System.out.println(human.getType().getName());
        }
//        Human human = dao.getHumanById(5);
//        System.out.println("Human " + human);
        List<HumanType> humanType = dao.getListHumanType();
        for (HumanType humanType1 : humanType) {
            System.out.println(humanType1.getName());
        }
        
//    try {
//            // Get HumanType by id
//            HumanType hmtype = dao.getTypeNameById(1);
//            if (hmtype != null) {
//                // Create a new Human object with the obtained HumanType
//                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//                
//                java.util.Date utilDate = sdf.parse("08-09-2004");
//                
//                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//                
//                dao.insertHuman(new Human(10, "Bá", sqlDate, true, hmtype));
//            } else {
//                System.out.println("Failed to retrieve HumanType. Insertion aborted.");
//            }
//            
//            // Refresh the list after insertion
//            list = dao.getHuman();
//            for (Human human : list) {
//                System.out.println(human);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//    String DOB = "08-05-2003";
//    try {
//         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//            Date date = sdf.parse(DOB);
//            java.sql.Date newDate = new java.sql.Date(date.getTime());
//            System.out.println("newDate" + newDate);
//    } catch (Exception e) {}


    }
        
        
    }


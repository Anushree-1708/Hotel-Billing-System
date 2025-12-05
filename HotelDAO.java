import java.sql.*;
import java.util.ArrayList;

public class HotelDAO {

    public ArrayList<String> getMenu() {
        ArrayList<String> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT item_name, price FROM menu_items");
            while(rs.next()) {
                list.add(rs.getString("item_name") + " - ₹" + rs.getDouble("price"));
            }
        } catch(Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean placeOrder(String customer, String item, int qty, double total) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO orders(customer_name, item_name, quantity, total_price) VALUES(?,?,?,?)"
            );
            ps.setString(1, customer);
            ps.setString(2, item);
            ps.setInt(3, qty);
            ps.setDouble(4, total);
            return ps.executeUpdate() > 0;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

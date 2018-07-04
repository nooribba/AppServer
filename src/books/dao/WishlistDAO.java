package books.dao;
 
import static common.DBTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import books.entity.WishlistDTO;

public class WishlistDAO {

	public ArrayList<WishlistDTO> selectWishlistAll(Connection con, String tmp) {
		ArrayList<WishlistDTO> wllist = new ArrayList<WishlistDTO>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM ZLEEMINHYUK.OYVR_WISH_LIST WHERE USER_ID = ?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, tmp);

			rs = stmt.executeQuery();
			
			while (rs.next()) {
				WishlistDTO dto = new WishlistDTO();
				dto.setUser_id(rs.getString("USER_ID"));
				dto.setPd_id(rs.getString("PD_ID"));
				dto.setPd_name(rs.getString("PD_NAME"));
				dto.setPd_cnt(rs.getString("PD_CNT"));
				dto.setStore_id(rs.getString("STORE_ID"));
				dto.setStore_name(rs.getString("STORE_NAME"));
				dto.setCode_id(rs.getString("CODE_ID"));
				
				wllist.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rs);
				close(stmt);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return wllist;
	}
}

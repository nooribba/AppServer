package books.dao;
 
import static common.DBTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import books.entity.ToxicDTO;
import books.entity.WishlistDTO;

public class AddWishDAO {

	public ArrayList<WishlistDTO> addWishProduct(Connection con, String gds_cd1, int gds_qty1) {
		ArrayList<WishlistDTO> wslist = new ArrayList<WishlistDTO>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		/*sqlSession.update(getSqlId, headerMap);*/
		try {
			//String sql = "SELECT * FROM TB_IROS_11_IR WHERE CHEM_NAME_KOR like ?";
			String sql = "call SP_SC_PRCS_REG_MNG(";

			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, gds_cd1);
			stmt.setInt(2, gds_qty1);

			rs = stmt.executeQuery();
			
			while (rs.next()) {
				WishlistDTO dto = new WishlistDTO();
				dto.setO_PROC_RSLT_SP(rs.getLong("O_PROC_RSLT_SP"));
				dto.setO_PROC_RSLT_CONT(rs.getString("O_PROC_RSLT_CONT"));
				
				wslist.add(dto);
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
		return wslist;
	}
}

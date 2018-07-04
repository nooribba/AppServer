package books.dao;
 
import static common.DBTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import books.entity.ToxicDTO;

public class ToxicDAO {

	public ArrayList<ToxicDTO> selectToxicAll(Connection con, String tmp) {
		ArrayList<ToxicDTO> tslist = new ArrayList<ToxicDTO>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			//String sql = "SELECT * FROM TB_IROS_11_IR WHERE CHEM_NAME_KOR like ?";
			String sql = "SELECT * FROM EAIUSER.TB_IROS_11_IR WHERE CHEM_NAME_KOR like ?";

			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, "%" + tmp + "%");

			rs = stmt.executeQuery();
			
			while (rs.next()) {
				ToxicDTO dto = new ToxicDTO();
				dto.setAbsor(rs.getString("ABSOR"));
				dto.setCas_no(rs.getString("CAS_NO"));
				dto.setCategory_name(rs.getString("CATEGORY_NAME"));
				dto.setChem_id(rs.getString("CHEM_ID"));
				dto.setChem_name_eng(rs.getString("CHEM_NAME_ENG"));
				dto.setChem_name_kor(rs.getString("CHEM_NAME_KOR"));
				dto.setDerma_tox(rs.getString("DERMA_TOX"));
				dto.setDistribu(rs.getString("DISTRIBU"));
				dto.setDosage(rs.getString("DOSAGE"));
				dto.setElimina(rs.getString("ELIMINA"));
				dto.setEnd_points(rs.getString("END_POINT"));
				dto.setKin_meta_info(rs.getString("KIN_META_INFO"));
				dto.setMecha(rs.getString("MECHA"));
				dto.setMetabol(rs.getString("METABOL"));
				dto.setPdf_url(rs.getString("PDF_URL"));
				dto.setRefer(rs.getString("REFER"));
				dto.setRoute(rs.getString("ROUTE"));
				dto.setSpecies(rs.getString("SPECIES"));
				dto.setTotal_count(rs.getString("TOTAL_COUNT"));
				dto.setTox_effect(rs.getString("TOX_EFFECT"));
				dto.setTox_values(rs.getString("TOX_VALUES"));
				dto.setToxic_code(rs.getString("TOXIC_CODE"));
				
				tslist.add(dto);
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
		return tslist;
	}
}

package books.entity;

public class WishlistDTO {
	private String user_id;
	private String pd_id;
	private String pd_name;
	private String pd_cnt;
	private String store_id;
	private String store_name;
	private String code_id;
	private Long O_PROC_RSLT_SP;
	private String O_PROC_RSLT_CONT;
	private String gdx_cd1;
	private Long gds_qty1;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPd_id() {
		return pd_id;
	}
	public void setPd_id(String pd_id) {
		this.pd_id = pd_id;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public String getPd_cnt() {
		return pd_cnt;
	}
	public void setPd_cnt(String pd_cnt) {
		this.pd_cnt = pd_cnt;
	}
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getCode_id() {
		return code_id;
	}
	public void setCode_id(String code_id) {
		this.code_id = code_id;
	}
	/**
	 * @return the o_PROC_RSLT_SP
	 */
	public Long getO_PROC_RSLT_SP() {
		return O_PROC_RSLT_SP;
	}
	/**
	 * @param o_PROC_RSLT_SP the o_PROC_RSLT_SP to set
	 */
	public void setO_PROC_RSLT_SP(Long o_PROC_RSLT_SP) {
		O_PROC_RSLT_SP = o_PROC_RSLT_SP;
	}
	/**
	 * @return the o_PROC_RSLT_CONT
	 */
	public String getO_PROC_RSLT_CONT() {
		return O_PROC_RSLT_CONT;
	}
	/**
	 * @param o_PROC_RSLT_CONT the o_PROC_RSLT_CONT to set
	 */
	public void setO_PROC_RSLT_CONT(String o_PROC_RSLT_CONT) {
		O_PROC_RSLT_CONT = o_PROC_RSLT_CONT;
	}
	/**
	 * @return the gdx_cd1
	 */
	public String getGdx_cd1() {
		return gdx_cd1;
	}
	/**
	 * @param gdx_cd1 the gdx_cd1 to set
	 */
	public void setGdx_cd1(String gdx_cd1) {
		this.gdx_cd1 = gdx_cd1;
	}
	/**
	 * @return the gds_qty1
	 */
	public Long getGds_qty1() {
		return gds_qty1;
	}
	/**
	 * @param gds_qty1 the gds_qty1 to set
	 */
	public void setGds_qty1(Long gds_qty1) {
		this.gds_qty1 = gds_qty1;
	}
	 
}

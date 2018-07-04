package books.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import books.biz.AddWishBiz;
import books.biz.ToxicBiz;
import books.entity.ToxicDTO;
import books.entity.WishlistDTO;


@WebServlet("/awp")
public class AddWishProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected final Logger log = LoggerFactory.getLogger(getClass());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWishProduct() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String gds_cd1 = request.getParameter("gds_cd1");
			String gds_qty1 = request.getParameter("gds_qty1");
			
			/*요청 json*/
			String string = "{'structure':[],'table':[],'variable':[{'GDS_CD1':'"+gds_cd1+"','GDS_QTY1':'"+gds_qty1+"'}]}";
			log.info("##### string : "+string);
			JSONObject jsonObject = new JSONObject(string);
			String userCredentials = "testuser" + ":" + "test1234!";
			
			String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
			
			URL url = new URL("http://52.2.165.121:25004/esb/VR-AW001/");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Authorization", basicAuth);
			connection.setConnectTimeout(60000);
			connection.setReadTimeout(60000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(jsonObject.toString());
			out.close();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			PrintWriter outPrint = response.getWriter();
			String inputLine = "";
			
			while ((inputLine = in.readLine()) != null) {
				log.info("##### inputLine : "+inputLine);
				//outPrint.print(inputLine);
			}
			JSONObject jObject= new JSONObject(inputLine);
			if("S".equals(jObject.getString("returnCd"))){
				outPrint.print("[Success]\n"+jObject.getString("errorMsg"));
			}else{
				outPrint.print("[Fail]\n"+jObject.getString("errorMsg"));
			}
			log.info("\nREST Service Invoked Successfully..");
			outPrint.flush();
			outPrint.close();
			in.close();
		} catch (Exception e) {
			log.error("\nError while calling REST Service");
			e.printStackTrace();
		}
		
		
		/*request.setCharacterEncoding("UTF-8");
		ArrayList<WishlistDTO> addWish = new ArrayList<WishlistDTO>();
		AddWishBiz biz = new AddWishBiz();
		String gds_cd1 = request.getParameter("gds_cd1");
		int gds_qty1 = Integer.parseInt(request.getParameter("gds_qty1"));
		System.out.println("##### gds_cd1 / gds_qty1 : "+gds_cd1+" / "+gds_qty1);
		String key = request.getParameter("callback");
		addWish = biz.callAddWish(gds_cd1, gds_qty1); 
 
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();

		JSONArray addWishJson = new JSONArray();			  
		for( WishlistDTO tmp : addWish) {
			JSONObject aw = new JSONObject();
			aw.put("O_PROC_RSLT_SP", tmp.getO_PROC_RSLT_SP());
			aw.put("O_PROC_RSLT_CONT", tmp.getO_PROC_RSLT_CONT());

			addWishJson.add(aw);			
		}
		
		out.print(key + "(" + addWishJson.toJSONString()+ ")");
		System.out.println("결과 : " + key + "(" + addWishJson.toJSONString()+ ")");	
		out.flush();
		out.close();*/
	}	
	public static void main(String[] args) {
		String string = "{'errorMsg':'OK','returnCd':'S'}";
		JSONArray result = new JSONArray();
		JSONObject jObject= new JSONObject(string);
	    System.out.println(jObject.getString("errorMsg"));
	    
		
	}
}

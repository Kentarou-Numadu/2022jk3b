package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.DataBean;
import conn.Conn;

public class DAO extends Conn implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final int MAXROW = 10;
	
	Connection con;
	
	public DAO() {
		con = conn();//-----スーパークラスのデータベース接続部分を呼び出す。connという変数を利用して参照できる。
		
	}
	
	//----sampleテーブルから取り出したデータをArrayListに格納する。
	
			
		
	public List<DataBean>getAllData(int page,String keyword){
		List<DataBean> data = new ArrayList<DataBean>();
		try {
			if(keyword == null||keyword == "") {
				keyword ="";
				
			}
			
			String sql = "select student_id,kanji_name,furigana from gakusei_master where student_id like ? or kanji_name like ? or furigana like ? limit ?, ?";
			PreparedStatement st = con.prepareStatement(sql);
			int baseRow= (page -1) * MAXROW;
			
			st.setString(1, "%"+keyword+"%");
			st.setString(2, "%"+keyword+"%");
			st.setString(3, "%"+keyword+"%");
			st.setInt(4, baseRow);
			st.setInt(5, MAXROW);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("student_id");
				String name = rs.getString("kanji_name");
				String furigana = rs.getString("furigana");
				
				DataBean b = new DataBean();
				b.setId(id);
				b.setName(name);
				b.setFurigana(furigana);
				data.add(b);
				
			}
		}catch(Exception e) {
			data = null;
			e.printStackTrace();
		}
		return data;
			
		}
	
	
	public List<DataBean>getData(String keyword){
		List<DataBean> data = new ArrayList<DataBean>();
		try {
			String sql = "select * from gakusei_master where name like ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+keyword+"%");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name =rs.getString("name");
				DataBean b = new DataBean();
				b.setId(id);
				b.setName(name);
				data.add(b);
					
			}
		
			
		}catch(Exception e) {
			data = null;
		}
		return data;
	}
	
	public int insertData(DataBean bean) {
		int result = -1;
		try {
			String sql="insert into gakusei_master(student_id, kanji_name,furigana,brith_day,zaip_code,address,telehone,mail,enrollment_status,enrollment_status_day,parents_kanji_name,parents_furigana,parents_zipcode,parents_address,parents_telephone,parents_mail) values(?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, bean.getId());
			st.setString(2, bean.getName());
			st.setString(3,bean.getFurigana());
			st.setString(4, bean.getBirth());
			st.setString(5,bean.getZip());
			st.setString(6,bean.getAddress());
			st.setString(7, bean.getTelephone());
			st.setString(8, bean.getMail());
			st.setInt(9, bean.getStatus());
			st.setString(10, bean.getStatus_day());
			st.setString(11, bean.getP_Name());
			st.setString(12, bean.getP_Furigana());
			st.setString(13, bean.getP_Zip());
			st.setString(14, bean.getP_Address());
			st.setString(15, bean.getP_Telephone());
			st.setString(16, bean.getP_Mail());
			
			result = st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
	
	//-----1レコードを取得取得したレコードを返す（失敗はnull）
	public DataBean getOneRec(String id) {
		DataBean data = new DataBean();// 返却するデータ
		try {
			String sql = "select * from gakusei_master where student_id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(id));
			ResultSet rs = st.executeQuery();rs.next();// 最初のレコードの取り出し
			data.setId(rs.getInt("student_id"));//番号（id）のセット
			data.setName(rs.getString("kanji_name"));
			data.setFurigana(rs.getString("furigana"));
			data.setBirth(rs.getString("birth_day"));
			data.setZip(rs.getString("zip_code"));
			data.setAddress(rs.getString("address"));
			data.setTelephone(rs.getString("telephone"));
			data.setMail(rs.getString("mail"));
			data.setStatus(rs.getInt("enrollment_ status"));
			data.setStatus_day(rs.getString("enrollment_ status_day"));
			data.setP_Name(rs.getString("parents_kanji_name"));
			data.setP_Furigana(rs.getString("parents_furigana"));
			data.setP_Zip(rs.getString("parents_zipcode"));
			data.setP_Address(rs.getString("parents_address"));
			data.setP_Telephone(rs.getNString("parents_telephone"));
			data.setP_Mail(rs.getString("parents_mail"));// 氏名のセット
		} catch(Exception e) {e.printStackTrace();// しくじった時は念のためトレース表示
			data = null;
		}return data;
	}//-----削除する処理処理したレコード数を返す（失敗＝0）
	
	
	
	public boolean isExists(String id) {
		DataBean data = new DataBean(); // 返却するデータ
		boolean result = false;      // 結果を返却する変数(存在しない)
		try {
		    String sql = "select count(*) from sample where id=?";
		    PreparedStatement st = con.prepareStatement(sql);
		    st.setInt(1, Integer.parseInt(id));
		    ResultSet rs = st.executeQuery();
		    rs.next();                   // 最初のレコードの位置へ移動
		    //--- 結果を取り出す
		    if (rs.getInt(1) == 1) {
		    	result = true;  // データが存在するのでtrueを返却
		    }
		} catch (Exception e) {
		    e.printStackTrace(); // しくじった時は念のためトレース表示
		    result = true;  // 何かのエラーがあったので登録できないようにtrue返す
		}
		return result;
	}
	
	public int updateData(DataBean bean) {
		int result = -1;
		try {
			String sql = "update gakusei_master set kanji_name=? furigana=?,brith_day=?,zaip_code=?,address=?,telehone=?,mail=?,enrollment_status=?,enrollment_status_day=?,parents_kanji_name=?,parents_furigana=?,parents_zipcode=?,parents_address=?,parents_telephone=?,parents_mail=?  where student_id=?";// SQL文
			PreparedStatement st = con.prepareStatement(sql);// プリペアドステートメント
			st.setString(1,  bean.getName());// 氏名の登録
			st.setString(2,bean.getFurigana());
			st.setString(3, bean.getBirth());
			st.setString(4,bean.getZip());
			st.setString(5,bean.getAddress());
			st.setString(6, bean.getTelephone());
			st.setString(7, bean.getMail());
			st.setInt(8, bean.getStatus());
			st.setString(9, bean.getStatus_day());
			st.setString(10, bean.getP_Name());
			st.setString(11, bean.getP_Furigana());
			st.setString(12, bean.getP_Zip());
			st.setString(13, bean.getP_Address());
			st.setString(14, bean.getP_Telephone());
			st.setString(15, bean.getP_Mail());
			st.setInt(16,  bean.getId());// IDの登録
			result = st.executeUpdate();//更新の実行 
		}catch(Exception e) {
			e.printStackTrace();// エラーなので、とりあえずスタックトレースを表示する
			result = 0;
		}
		return result;
		
	}
	
	public int getMaxPage(String keyword) {
		int allPage = -1;
		try {
			String sql = "select count(*) as cnt from gakusei_master where kanji_name like ? or furigana like ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + keyword + "%");
			st.setString(2, "%" + keyword + "%");
			ResultSet rs = st.executeQuery();
			rs.next();int records = rs.getInt("cnt");
			allPage = (records -1) / MAXROW + 1;
		} catch (Exception e) {
			e.printStackTrace();
			allPage = 0;
		}
		return allPage;
		}
	
	
}

package GUI;
import java.sql.*;

public class Database {
	Connection con = null;
	public static Statement stmt = null;
	String url = "jdbc:mysql://127.0.0.1:3306/dbstudy";	//dbstudy 스키마
	String user = "root";
	String passwd = "Tkdtn2040!";		//본인이 설정한 root 계정의 비밀번호를 입력하면 된다.
	String idd;
	String pww;
	String nam;
	String ema;
	public static String Area="대구";
	public int numperson;
	ResultSet rs=null;
	public static int idx = 0;
	
	Database() {	//데이터베이스에 연결한다.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			
			System.out.println("MySQL 서버 연동 성공");
		} catch(Exception e) {
			System.out.println("MySQL 서버 연동 실패 > " + e.toString());
		}
	}
	
	void index(int a) {
		idx = a;
	}
	/* 로그인 정보를 확인 */
	boolean logincheck(String _i, String _p) {
		boolean flag = false;
		
		idd = _i;
		pww = _p;
		int count=0;
		try {
			String checkingStr = "SELECT * FROM member WHERE id='" + idd + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			
			
			while(result.next()) {
				if(pww.equals(result.getString("password"))) {
					flag = true;
					System.out.println("로그인 성공");
					Area=result.getString("area");
				}
				
				else {
					flag = false;
					System.out.println("로그인 실패");
				}
				count++;
				numperson=count;
			}
		} catch(Exception e) {
			flag = false;
			System.out.println("로그인 실패 > " + e.toString());
		}
		
		return flag;
	}
	
	boolean joinCheck(String _i, String _p, String _n, String _e, String _a) {
		boolean flag = false;
		
		String id = _i;
		String pw = _p;
		String name= _n;
		String email= _e;
		String area= _a;
			
		try {
			String insertStr = "INSERT INTO member VALUES('" + id + "', '" + pw + 
					"', '"+name+"', '"+email+"', '"+area+"')";
			stmt.executeUpdate(insertStr);
				
			flag = true;
			System.out.println("회원가입 성공");
		} catch(Exception e) {
			flag = false;
			System.out.println("회원가입 실패 > " + e.toString());
		}
			
		return flag;
	}
	
	
	boolean Writing(String a,String b) {
		boolean flag = false;
		String title=a;
		String writing=b;
		String arthor;
		try {
			String insertStr = "INSERT INTO board VALUES('" + title + "', '" +writing+"', '"+ idd +"')";
			stmt.executeUpdate(insertStr);
			flag = true;
			System.out.println("글쓰기 성공");
		} catch(Exception e) {
			flag = false;
			System.out.println("글쓰기 실패 > " + e.toString());
		}
		return flag;
	}

	public String[][] Reading() {
		boolean flag = false;
		String[][] title=new String[100][3];
		String writing;
		String[][] size = null;
		try {
			String checkingStr = "SELECT * FROM board";
			ResultSet result = stmt.executeQuery(checkingStr);
			
			int count = 0;
			while(result.next()) {
				title[count][0]=result.getString("title");
				title[count][1]=result.getString("author");
				title[count][2]=result.getString("writing");
				flag = true;
				
				count++;
			}
			size=new String[count][3];
			for(int i=0;i<count;i++) {
				size[i][0]=title[i][0];
				size[i][1]=title[i][1];
				size[i][2]=title[i][2];
			}
		} catch(Exception e) {
			
		}
		return size;
	}
	
	String id() {
		return idd;
	}
	
	String password() {
		return pww;
	}
	
	int numofperson() {
		boolean flag = false;
		String[][] title=new String[10][3];
		String writing;
		try {
			String checkingStr = "SELECT * FROM member";
			ResultSet result = stmt.executeQuery(checkingStr);
			
			int count = 0;
			while(result.next()) {
				
				flag = true;
				
				count++;
			}
			numperson=count;
		} catch(Exception e) {
			
		}
		return numperson;
	}
	
	String name() {
		
		try {
			String checkingStr = "SELECT * FROM member";
			ResultSet result = stmt.executeQuery(checkingStr);
			
			int count = 0;
			
			while(result.next()) {
				
				if(idd.equals(result.getString("id"))) {
					nam=result.getString("name");
				}
				else {
					
				}
				count++;
			}
		} catch(Exception e) {
			
		}
		
		return nam;
	}
	
	String email() {
		String ema = new String();
		try {
			String checkingStr = "SELECT * FROM member";
			ResultSet result = stmt.executeQuery(checkingStr);
			
			int count = 0;
			while(result.next()) {
				if(idd.equals(result.getString("id"))) {
					ema=result.getString("email");
				}
				else {
					
				}
				count++;
			}
		} catch(Exception e) {
			
		}
		return ema;
	}
	
	void swap(String i,String p,String n,String a) {
		
	      try {
	          String changeStr = "UPDATE member SET name";  // 왠진모르겠는데 전부다 바뀜
	          ResultSet result = stmt.executeQuery(changeStr);
	          stmt.executeUpdate(changeStr);
	          int count = 0;
	          
	          while(result.next()) {
	        	  if(idd.equals(result.getString("id"))) {
					pww=result.getString("password");
					nam=result.getString("name");
					ema=result.getString("email");
					}
					else {
					}
					count++;
				}
			} catch(Exception e) {
				System.out.println("로그인 실패 > " + e.toString());
		}
	    nameswap(p,n,a);
	    
	}
	void nameswap(String pa,String na,String ea) {
		 try {
	         String changeStr = "UPDATE member SET name ='"+na+"',password = '"+pa+"',email = '"+ea+"' WHERE id = '"+idd+"'";  // 왠진모르겠는데 전부다 바뀜
	         stmt.executeUpdate(changeStr);
	         pww=pa;
	         System.out.println("데이터 변경 성공!");
	      } catch(Exception e) {
	         System.out.println("데이터 변경 실패 이유 : " + e.toString());
	      }

	}
	String[] lookwriting(int n) {
		String[] wri=new String[2];
		try {
			String checkingStr = "SELECT * FROM board";
			ResultSet result = stmt.executeQuery(checkingStr);
			
			int count = 0;
			while(result.next()) {
				if(count==n) {
					wri[0]=result.getString("title");
					wri[1]=result.getString("writing");
				}
				count++;
			}
		} catch(Exception e) {
			
		}
		return wri;
	}
	 void removewriting(String s) {
	      try {
	         String removeStr = "DELETE FROM board where title = '"+ s +"'";  // DELETE FROM 테이블네임 where 삭제할 열 = '삭제할이름'
	         stmt.executeUpdate(removeStr);
	         System.out.println("데이터 삭제 성공!");
	      } catch(Exception e) {
	         System.out.println("데이터 삭제 실패 이유 : " + e.toString());
	      }
	   }
}
package tutorial;

import java.util.*;
import java.lang.*;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;

public class authors extends ActionSupport{
	private int authorID;
	private String name;
	private int age;
	private String country;
	
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String findauthor() {
		int a = 0;
		//System.out.println(name.length());
		//System.out.println(name.length());
		//System.out.println(name);
		List<String>list = new ArrayList<String>();
		ActionContext.getContext().put("key", "操作错误，请重新操作！"); 
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String value = "ex3";
		value = request.getParameter("identity");
		if(value==null) {
			value="ex3";
		}
		//System.out.println(value);
		if(value.equals("ex1")) {
			try{
	            Class.forName("com.mysql.jdbc.Driver");
	            String url = "jdbc:mysql://gkmkihwhhwxj.mysql.sae.sina.com.cn:10144/test1";
	            String username = "root";
	            String password = "123456";
	            Connection con = DriverManager.getConnection(url,username,password);
	            
	            Statement stmt=con.createStatement();
	            String sql = "select*from author where name like"+"'"+name+"'";
	            ResultSet rst=stmt.executeQuery(sql);
	            if(!rst.next()) {
	            	ActionContext.getContext().put("key", "抱歉，图书馆内查无此人！"); 
	            	//System.out.println(key);
	            	ActionContext ac=ActionContext.getContext();
	                Map<String, Object> session=ac.getSession();
	                session.put("loginid","directory.jsp");
	            }
	            else {
	            	ActionContext.getContext().put("key", name);
	            	int num = rst.getInt(1);
	            	String sqlc = "select*from books where AuthorID like"+"'"+num+"'";
	            	ResultSet rstc=stmt.executeQuery(sqlc);
	            	while(rstc.next()) {
	            		list.add(rstc.getString("title"));
	            	}
	            	ActionContext.getContext().put("list", list);
	            	a = 1;
	            	rstc.close();
	            }
	            rst.close();
	            stmt.close();
	            con.close();
	     }catch(Exception e){
	    	 System.out.print("登录失败，请重新登录！");
	    	 e.printStackTrace();
	     }
		}
		else {
			ActionContext.getContext().put("key", "未选择功能，请返回上一步重新操作！"); 
		}
		if(a==1) {
			return "success";
		}
		else {
			return "error";
		}
	}

}

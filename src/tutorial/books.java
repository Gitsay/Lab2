package tutorial;

import java.util.*;
import java.lang.*;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;

public class books extends ActionSupport {
    private String title;                //书名
    private int price;                   //价格
    private String publisher;               //出版商
    private String publishdata;               //出版时间
    private String iSBN;                    //书的国际编号
    private int authorID;                //作者ID
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishdata() {
		return publishdata;
	}
	public void setPublishdata(String publishdata) {
		this.publishdata = publishdata;
	}
	public String getiSBN() {
		return iSBN;
	}
	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
    public String findbook() {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	//System.out.println(title);
    	//title = request.getParameter("title");
    	//System.out.println(title);
    	int dum = 0;
    	try{
    		dum = 1;
    		request.setCharacterEncoding("UTF-8");
    		title = request.getParameter("title");
        	//System.out.println(title);
        	//title  =  new  String(request.getParameter("title").getBytes("ISO-8859-1"), "utf-8");
            System.out.println(title);
        	Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://gkmkihwhhwxj.mysql.sae.sina.com.cn:10144/test1";
            String username = "root";
            String password = "123456";
            Connection con = DriverManager.getConnection(url,username,password);
            
            Statement stmt=con.createStatement();
            List<books>list1 = new ArrayList<books>();
            List<authors>list2 = new ArrayList<authors>();
            String sql = "select*from books where Title like"+"'"+title+"'";
            ResultSet rst=stmt.executeQuery(sql);
            int num = 0;
            while(rst.next()) {
            	books boec = new books();
            	boec.iSBN = rst.getString(1);
            	boec.title = rst.getString(2);
            	boec.authorID = rst.getInt(3);
            	num = rst.getInt(3);
            	boec.publisher = rst.getString(4);
            	boec.publishdata = rst.getString(5);
            	boec.price = rst.getInt(6);
            	list1.add(boec);
            	ActionContext.getContext().put("list1", list1);
            }
            String sqlc = "select*from author where AuthorID like"+"'"+num+"'";
            ResultSet rstc=stmt.executeQuery(sqlc);
            while(rstc.next()) {
            	authors authorc = new authors();
            	authorc.setAuthorID(rstc.getInt(1));
            	authorc.setName(rstc.getString(2));
            	authorc.setAge(rstc.getInt(3));
            	authorc.setCountry(rstc.getString(4));
            	list2.add(authorc);
            	ActionContext.getContext().put("list2", list2);
            }
            stmt.close();
            rst.close();
            rstc.close();
            con.close();
     }catch(Exception e){
    	 System.out.print("登录失败，请重新登录！");
    	 e.printStackTrace();
     }
    	if(dum!=0) {
    		return "success";
    	}
    	else {
    		return "error";
    	}
    }
    
    public String update() {
    	int mum = 0;
    	HttpServletRequest request = ServletActionContext.getRequest();
    	try{
    		String name;
    		request.setCharacterEncoding("UTF-8");
    		name = request.getParameter("name");
        	System.out.println(name);
        	Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://gkmkihwhhwxj.mysql.sae.sina.com.cn:10144/test1";
            String username = "root";
            String password = "123456";
            Connection con = DriverManager.getConnection(url,username,password);
            
            Statement stmt=con.createStatement();
            List<books>list1 = new ArrayList<books>();
            List<authors>list2 = new ArrayList<authors>();
            String sqlx = "select*from books where title like"+"'"+title+"'";
            ResultSet rstr=stmt.executeQuery(sqlx);
            if(!rstr.next()) {
            	ActionContext.getContext().put("key", "此书不存在，请添加书目后再进行操作！"); 
            }
            else {
            	mum = 1;
            	String sql = "select*from author where name like"+"'"+name+"'";
                ResultSet rst=stmt.executeQuery(sql);
                int num = 0;
                int cum = 0;
                if(!rst.next()) {
                	cum = 1;
                	sql ="select* from author";
                	rst = stmt.executeQuery(sql);
                	rst.last();
                	num = rst.getInt(1);
                	num = num + 1;
                	PreparedStatement pstmt = con.prepareStatement("insert into author(AuthorID,name) values(?,?)");
                	pstmt.setInt(1, num);
                	pstmt.setString(2, name);
                	//pstmt.setInt(3, 0);
                	//pstmt.setString(4, null);
                	pstmt.executeUpdate();
                	authors authorz = new authors();
                	authorz.setAuthorID(num);
                	authorz.setName(name);
                	list2.add(authorz);
                	ActionContext.getContext().put("list2", list2);
                }
                else {
                	cum = 1;
                	num = rst.getInt(1);
                	authors authorc = new authors();
                	authorc.setAuthorID(rst.getInt(1));
                	authorc.setName(rst.getString(2));
                	authorc.setAge(rst.getInt(3));
                	authorc.setCountry(rst.getString(4));
                	list2.add(authorc);
                	ActionContext.getContext().put("list2", list2);
                }
                int AuthorID = num;
                //System.out.println(title);
                if(cum != 0) {
                	stmt.executeUpdate("update books set AuthorID ="+"'"+AuthorID+"'"+"where title ="+"'"+ title + "'");
                }
                if(!publisher.equals("")) {
                	stmt.executeUpdate("update books set publisher ="+"'"+publisher+"'"+"where title ="+"'"+ title+"'");
                }
                System.out.println(publisher);
                if(!publishdata.equals("")) {
                	stmt.executeUpdate("update books set publishdata ="+"'"+publishdata+"'"+ "where title ="+"'"+ title+"'");
                }
                //System.out.println(publishdata);
                //System.out.println(publishdata.length());
                if(price != 0) {
                	stmt.executeUpdate("update books set price ="+"'"+price+"'" +"where title ="+"'"+ title + "'");
                }
                //System.out.println(price);
                String sqlc = "select*from books where title like"+"'"+title+"'";
                ResultSet rstc=stmt.executeQuery(sqlc);
                while(rstc.next()) {
                	books boed = new books();
                	boed.iSBN = rstc.getString(1);
                	boed.title = rstc.getString(2);
                	boed.authorID = rstc.getInt(3);
                	boed.publisher = rstc.getString(4);
                	boed.publishdata = rstc.getString(5);
                	boed.price = rstc.getInt(6);
                	list1.add(boed);
                	ActionContext.getContext().put("list1", list1);
                }
                stmt.close();
                rst.close();
                rstc.close();
            }
            con.close();
     }catch(Exception e){
    	 System.out.print("登录失败，请重新登录！");
    	 e.printStackTrace();
     }
    	if(mum!=0) {
    		return "success";
    	}
    	else {
    		return "error";
    	}
    }
    
    public String deletebook() {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	//System.out.println(title);
    	//title = request.getParameter("title");
    	//System.out.println(title);
    	try{
    		request.setCharacterEncoding("UTF-8");
    		//title = request.getParameter("title");
        	//System.out.println(title);
    		//System.out.println(iSBN);
        	iSBN  =  new  String(request.getParameter("iSBN").getBytes("ISO-8859-1"), "utf-8");
            //System.out.println(iSBN);
        	Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://gkmkihwhhwxj.mysql.sae.sina.com.cn:10144/test1";
            String username = "root";
            String password = "123456";
            Connection con = DriverManager.getConnection(url,username,password);
            
            Statement stmt=con.createStatement();
            List<books>list1 = new ArrayList<books>();
            String sql = "delete from books where ISBN="+"'"+iSBN+"'";
            
            boolean col=stmt.execute(sql);
            ResultSet rst=stmt.executeQuery("select*from books");
            while(rst.next()) {
            	books boec = new books();
            	boec.iSBN = rst.getString(1);
            	boec.title = rst.getString(2);
            	boec.authorID = rst.getInt(3);
            	boec.publisher = rst.getString(4);
            	boec.publishdata = rst.getString(5);
            	boec.price = rst.getInt(6);
            	list1.add(boec);
            	ActionContext.getContext().put("list1", list1);
            }
            rst.close();
            stmt.close();
            con.close();
     }catch(Exception e){
    	 System.out.print("登录失败，请重新登录！");
    	 e.printStackTrace();
     }
    	return "success";
    }
    
    public String increasebook() {
    	int num = 0;
    	HttpServletRequest request = ServletActionContext.getRequest(); 
    	String value = "ex3";
		value = request.getParameter("identity");
		if(value==null) {
			value = "ex3";
		}
		//System.out.println(value);
		if(value.equals("ex2")) {
			try{
				HttpServletRequest request1 = ServletActionContext.getRequest(); 
	    		String name;
	    		request.setCharacterEncoding("UTF-8");
	    		name = request1.getParameter("name1");
	        	//System.out.println(name);
	        	//System.out.println(iSBN);
	        	//System.out.println(title);
	        	//System.out.println(publisher);
	        	//System.out.println(publishdata);
	        	//System.out.println(price);
	        	if(name.equals("")||iSBN.equals("")||title.equals("")) {
	        		ActionContext.getContext().put("key", "请将必填项填写后再做操作！"); 
	        	}
	        	else {
	        		Class.forName("com.mysql.jdbc.Driver");
		            String url = "jdbc:mysql://gkmkihwhhwxj.mysql.sae.sina.com.cn:10144/test1";
		            String username = "root";
		            String password = "123456";
		            Connection con = DriverManager.getConnection(url,username,password);
		            
		            Statement stmt=con.createStatement();
		            List<books>list1 = new ArrayList<books>();
		            List<authors>list2 = new ArrayList<authors>();
		            String sqlz = "select*from books where ISBN like"+"'"+iSBN+"'";
		            ResultSet rstz=stmt.executeQuery(sqlz);
		            if(rstz.next()) {
		            	ActionContext.getContext().put("key", "ISBN号重复，请返回上一步输入正确的ISBN号操作！");
		            }
		            else {
		            	num = 1;
		            	String sql = "select*from author where name like"+"'"+name+"'";
			            ResultSet rst=stmt.executeQuery(sql);
			            int zum = 0;
			            int cum = 0;
			            int sun = 0;
			            if(!rst.next()) {
			            	cum = 1;
			            	sql ="select* from author";
			            	rst = stmt.executeQuery(sql);
			            	rst.last();
			            	zum = rst.getInt(1);
			            	zum = zum + 1;
			            	PreparedStatement pstmt = con.prepareStatement("insert into author(AuthorID,name) values(?,?)");
			            	pstmt.setInt(1, zum);
			            	pstmt.setString(2, name);
			            	//pstmt.setInt(3, 0);
			            	//pstmt.setString(4, null);
			            	pstmt.executeUpdate();
			            	authors authorz = new authors();
			            	authorz.setAuthorID(num);
			            	authorz.setName(name);
			            	list2.add(authorz);
			            	ActionContext.getContext().put("list2", list2);
			            }
			            else {
			            	zum = rst.getInt(1);
			            }
			            PreparedStatement pstmt = con.prepareStatement("insert into books(ISBN,title,AuthorID) values(?,?,?)");
		            	pstmt.setString(1, iSBN);
		            	pstmt.setString(2, title);
		            	pstmt.setInt(3, zum);
		            	pstmt.executeUpdate();
		            	if(!publisher.equals("")) {
		            		//pstmt = con.prepareStatement("insert into books(publisher) values(?)");
		            		//pstmt.setString(1, publisher);
		            		stmt.executeUpdate("update books set publisher ="+"'"+publisher+"'"+"where title ="+"'"+ title+"'");
		            	}
		            	if(!publishdata.equals("")) {
		            		//pstmt = con.prepareStatement("insert into books(publishdata) values(?)");
		            		//pstmt.setString(1, publishdata);
		            		stmt.executeUpdate("update books set publishdata ="+"'"+publishdata+"'"+"where title ="+"'"+ title+"'");
		            	}
		            	if(price!=0) {
		            		//pstmt = con.prepareStatement("insert into books(price) values(?)");
		            		//pstmt.setInt(1, price);
		            		stmt.executeUpdate("update books set price ="+"'"+price+"'"+"where title ="+"'"+ title+"'");
		            	}
		            	//pstmt.setInt(3, 0);
		            	//pstmt.setString(4, null);
		            	//pstmt.executeUpdate();
		            	ResultSet rstc=stmt.executeQuery("select*from books");
		            	while(rstc.next()) {
		            		books boec = new books();
		                	boec.iSBN = rstc.getString(1);
		                	boec.title = rstc.getString(2);
		                	boec.authorID = rstc.getInt(3);
		                	boec.publisher = rstc.getString(4);
		                	boec.publishdata = rstc.getString(5);
		                	boec.price = rstc.getInt(6);
		                	list1.add(boec);
		                	ActionContext.getContext().put("list1", list1);
		            	}
		            	rst.close();
		            	rstc.close();
		            	pstmt.close();
		            	stmt.close();
		            }
	            	con.close();
	        	}
		}catch(Exception e){
	    	 System.out.print("登录失败，请重新登录！");
	    	 ActionContext.getContext().put("key", "未选择功能，请返回上一步重新操作！"); 
	    	 e.printStackTrace();
	     }
		}
		else {
			ActionContext.getContext().put("key", "未选择功能，请返回上一步重新操作！"); 
		}
		if(num!=0) {
			return "success";
		}
		else {
			return "error";
		}
    }
}

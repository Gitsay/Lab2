package tutorial;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

public class information extends ActionSupport {
	private String name;                    //登录名
    private String sex;                     //性别
    private String telephone;               //手机号
    private String email;                   //邮箱
    private String school;                  //所在学校
	private String studynumber;             //学号
    private String birthday;                //生日
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getStudynumber() {
		return studynumber;
	}
	public void setStudynumber(String studynumber) {
		this.studynumber = studynumber;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String addinformation() {
		return "success";
	}
	public String execute() {
		int a = 0;
		//System.out.println(name);
		try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://gkmkihwhhwxj.mysql.sae.sina.com.cn:10144/test1";
            String username = "root";
            String password = "123456";
            Connection conn = DriverManager.getConnection(url,username,password);
            
            String sql = "insert into informations(name,sex,telephone,Email,school,studynumber,birthday)values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, getName());
            ps.setString(2, getSex());
            ps.setString(3, getTelephone());
            ps.setString(4, getEmail());
            ps.setString(5, getSchool());
            ps.setString(6, getStudynumber());
            ps.setString(7, getBirthday());
            int row = ps.executeUpdate();
            if(row > 0){
            	//System.out.println("登陆成功，请选择你所需要的功能:");
            	a = 1;
            }
            ps.close();
            conn.close();
     }catch(Exception e){
    	 a = 2;
    	 System.out.print("登录失败，请重新登录！");
    	 e.printStackTrace();
     }
		if(a==1) {
			return "success";
		}
		else {
			return "error";
		}
	}
}



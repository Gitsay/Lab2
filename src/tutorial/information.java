package tutorial;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;

public class information extends ActionSupport {
	private String name;                    //��¼��
    private String sex;                     //�Ա�
    private String telephone;               //�ֻ���
    private String email;                   //����
    private String school;                  //����ѧУ
	private String studynumber;             //ѧ��
    private String birthday;                //����
    
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
            	//System.out.println("��½�ɹ�����ѡ��������Ҫ�Ĺ���:");
            	a = 1;
            }
            ps.close();
            conn.close();
     }catch(Exception e){
    	 a = 2;
    	 System.out.print("��¼ʧ�ܣ������µ�¼��");
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



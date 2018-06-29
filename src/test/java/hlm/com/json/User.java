package hlm.com.json;

import java.io.Serializable;
import java.util.Date;


public class User<T> implements Serializable  {


	private static final long serialVersionUID = -6562205181367715396L;
	private String name ;
    private String sex ;
    private Integer age ;
    private Date birth ;
    private Dept dept;
    private boolean isManager;
    private T type;
    private StringBuilder stringBuilder;
    
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public boolean getIsManager() {
		return isManager;
	}
	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}
	public T getType() {
		return type;
	}
	public void setType(T type) {
		this.type = type;
	}
	public StringBuilder getStringBuilder() {
		return stringBuilder;
	}
	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}
    
    
}
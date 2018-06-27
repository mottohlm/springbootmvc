package hlm.com.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {
		

		List<User> userList = new ArrayList<User>();
		buildData(userList);
		for(User u : userList){
			System.out.println(u.toString());
		}
		System.out.println("<-----------我是华丽的分割线------------>");
		userList.sort(new Comparator<User>(){
			@Override
			public int compare(User arg0, User arg1) {
				//这里是根据ID来排序，所以它为空的要剔除掉
				if(arg0.getId()==null || arg1.getId()==null) return 0;
				
				return arg0.getId().compareTo(arg1.getId());//这是顺序
			}			
		});	
		for(User u : userList){
			System.out.println(u.toString());
		}
	}

	public static void buildData(List<User> userList){
		if(userList == null){
			userList = new ArrayList<User>();
		}
		User u1 = new User((Integer)1 ,"1+1", "小明" ,(Integer)0 , "123456");
		User u2 = new User((Integer)2 ,"1+2", "小红" ,(Integer)1 , "123456");
		User u3 = new User((Integer)3 ,"1+3", "小转" ,(Integer)0 , "123456");
		User u4 = new User((Integer)4 ,"1+4", "小黑" ,(Integer)1 , "654321");
		User u5 = new User((Integer)5 ,"1+5", "小兵" ,(Integer)0 , "666666");
		User u6 = new User((Integer)6,"1+6", "小太阳" ,(Integer)1 , "888888");
		userList.add(u5);
		userList.add(u3);
		userList.add(u2);
		userList.add(u1);
		userList.add(u4);
		userList.add(u6);
	}
}

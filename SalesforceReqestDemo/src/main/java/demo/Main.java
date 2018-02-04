package demo;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Main {
	public static void main(String[] args) throws Exception {
		
		HttpServletRequest request=null;
		HttpServletResponse response = null;
		
		HttpPostDemo post=new HttpPostDemo();
		Authentication authorization=new Authentication();
		
		authorization.doPost(request, response);
		post.post(authorization.getLoginInstanceUrl(), authorization.getLoginAccessToken());

	}

}

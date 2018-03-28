package com.sinosoft.web.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.entity.UserEntity;
import com.sinosoft.entity.UserInfoEntity;
import com.sinosoft.web.service.CheckInfoService;
import com.sinosoft.web.service.SaveInfoService;
import com.sinosoft.web.service.ShowPersonInfoService;
import com.sinosoft.web.service.TestService;


/**
 * @author wangj
 * On 2/1/2017.12:36 AM
 */
@Controller
public class MainController {

	@Autowired
	private TestService testService;
	@Autowired
	private CheckInfoService checkInfoService;
	@Autowired
	ShowPersonInfoService showPersonInfoService;
	@Autowired
	SaveInfoService saveInfoService;
	
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(){
//        
        return "test";
    }
    
    @RequestMapping(value = "springTest",method = RequestMethod.GET)
    public String serviceTest() {
    return testService.test();	
    }
    /**
     * 展示页面
     */
    @RequestMapping(value = "login")
    public String showLoginPage(HttpServletRequest re) {
    	return "login";
    }
    /**
     * 验证身份信息
     */
    @RequestMapping(value = "checkInfo")
    public ModelAndView checkLogin(HttpServletRequest re,Model model,@RequestParam(value="username")String username,@RequestParam(value="password")String password) throws Exception {

    	try {  
    		HttpSession session = re.getSession();
    		Subject subject = SecurityUtils.getSubject();
    		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
    		Sha256Hash md5 = new Sha256Hash(password);
    		UserEntity user = checkInfoService.checkInfo(username, md5.toHex());
    	List<UserInfoEntity> userInfo = showPersonInfoService.showPersonInfo(username, md5.toString());
    	UserInfoEntity userInfoEntity;
    	subject.login(token);
    	session.setAttribute("user",user);
    	if(userInfo.size()>0) {
    		 userInfoEntity = userInfo.get(userInfo.size()-1);
    		return new ModelAndView("showPersonInfo","UserInfoEntity",userInfoEntity);
    	}else {
    		userInfoEntity = userInfo.get(0);
    		return new ModelAndView("showPersonInfo","UserInfoEntity",userInfoEntity);
    	}
    	


	    } catch (Exception e) {  
	        //5、身份验证失败 
	    	e.printStackTrace();
	    	return new ModelAndView("error");
	    }  

    }
    /**
     * 展示注册页面
     */
    @RequestMapping(value = "register")
    public ModelAndView register() {
    	return new ModelAndView("register");
    }
    /**
     * 保存注册信息
     */
    @RequestMapping(value = "registerInfo")
    public ModelAndView registerInfo(HttpServletRequest req) {
    	String id = req.getParameter("Id");
    	String password = req.getParameter("password");
    	String md5 = new Sha256Hash(password).toHex();
    	UserEntity user = new UserEntity();
    	user.setUserName(id);
    	user.setPassword(md5.toString());
    	saveInfoService.save(user);

    	try {
    		UserEntity userEntity =  checkInfoService.checkInfo(id, md5);
			
			
			 return new ModelAndView("registerInfo","UserEntity",userEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
    /**
     * 保存个人信息
     */
    @RequestMapping(value = "modifyInfo")
    public ModelAndView showModifyInfo(HttpServletRequest req) {
    	String name = req.getParameter("name");
    	Integer age  = Integer.parseInt(req.getParameter("age"));
    	String address = req.getParameter("address");
    	Integer userInfoId  = Integer.parseInt(req.getParameter("userInfoId"));
    	UserInfoEntity user = new UserInfoEntity();
    	user.setName(name);
    	user.setAge(age);
    	user.setAddress(address);
    	user.setUserInfoId(userInfoId);
    	saveInfoService.save(user);
    	return new ModelAndView("modifyInfo","UserInfoEntity",user);
    }


}
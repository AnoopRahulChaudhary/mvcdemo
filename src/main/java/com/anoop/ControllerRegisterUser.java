package com.anoop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerRegisterUser
{
  @RequestMapping("/Register")
  public String register(@RequestParam("userName") String userName , @RequestParam("userPass") String userPass)
  {
    //Resource resource = new ClassPathResource("dependencyInjection.xml");
    //BeanFactory beanFactory = new XmlBeanFactory(resource);
    DaoRegisterUser daoRegisterUser = new DaoRegisterUser();//(DaoRegisterUser) beanFactory.getBean("e");
    boolean result = daoRegisterUser.register(userName,userPass);

    if(result)
    {
     return "register_success";
    }
    return "register_failure";
  }
}
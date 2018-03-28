package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author wangj
 * @date 2018年3月6日
 * @ClassName: SpringContextHolder
 * @Description: TODO(以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext.)
 *
 */
public class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	/** 
	* 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量. 
	*/
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext; 
	}

	/** 
	* 取得存储在静态变量中的ApplicationContext. 
	*/
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	/** 
	* 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型. 
	*/
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/** 
	* 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型. 
	*/
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return (T) applicationContext.getBeansOfType(clazz);
	}

	/** 
	* 清除applicationContext静态变量. 
	*/
	public static void cleanApplicationContext() {
		applicationContext = null;
	}

	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}

	
	private void getAllBean() {
		WebApplicationContext webApplicationContext = (WebApplicationContext) SpringContextHolder
				.getApplicationContext();
		String[] beanNames = webApplicationContext.getBeanDefinitionNames();
		int allBeansCount = webApplicationContext.getBeanDefinitionCount();

		System.out.println("所有beans的数量是：" + allBeansCount);
		for (String beanName : beanNames) {
			Class<?> beanType = webApplicationContext.getType(beanName);
			Package beanPackage = beanType.getPackage();

			Object bean = webApplicationContext.getBean(beanName);

			System.out.println("BeanName:" + beanName);
			System.out.println("Bean的类型：" + beanType);
			System.out.println("Bean所在的包：" + beanPackage);

			System.out.println("\r\n");
		}
	}
}
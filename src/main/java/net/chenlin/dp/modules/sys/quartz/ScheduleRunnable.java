package net.chenlin.dp.modules.sys.quartz;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.DependsOn;
import org.springframework.util.ReflectionUtils;

import net.chenlin.dp.common.exception.RRException;
import net.chenlin.dp.common.utils.SpringContextUtils;

/**
 * 执行定时任务
 * @author zcl<yczclcn@163.com>
 */
@DependsOn("springContextUtils")
public class ScheduleRunnable implements Runnable {
	
	private Object target;
	
	private Method method;
	
	private String params;
	
	public ScheduleRunnable(String beanName, String methodName, String params) throws NoSuchMethodException, SecurityException {
		this.target = SpringContextUtils.getBean(beanName);
		this.params = params;
		
		if(StringUtils.isNotBlank(params)){
			this.method = target.getClass().getDeclaredMethod(methodName, String.class);
		}else{
			this.method = target.getClass().getDeclaredMethod(methodName);
		}
	}

	@Override
	public void run() {
		try {
			ReflectionUtils.makeAccessible(method);
			if(StringUtils.isNotBlank(params)){
				method.invoke(target, params);
			}else{
				method.invoke(target);
			}
		}catch (Exception e) {
			throw new RRException("执行定时任务失败", e);
		}
	}

}

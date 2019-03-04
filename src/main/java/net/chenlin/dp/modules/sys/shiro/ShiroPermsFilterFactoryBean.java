package net.chenlin.dp.modules.sys.shiro;

import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.utils.SpringContextUtils;
import net.chenlin.dp.modules.sys.dao.SysMenuMapper;
import net.chenlin.dp.modules.sys.entity.SysMenuEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产生责任链，确定每个url的访问权限
 * @author zcl<yczclcn@163.com>
 */
public class ShiroPermsFilterFactoryBean extends ShiroFilterFactoryBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShiroPermsFilterFactoryBean.class);
	
	private SysMenuMapper sysMenuMapper = SpringContextUtils.getBean("sysMenuMapper", SysMenuMapper.class);

	/**
	 * 默认配置权限链
	 */
	public static final Map<String, String> DEFAULT_CHAIN_MAP = new HashMap<>(16);

	/**
	 * 增加数据库权限
	 * @param filterChainDefinitionMap
	 */
	@Override
	public void setFilterChainDefinitionMap(Map<String, String> filterChainDefinitionMap) {
		// 清空默认配置之后保存配置
		DEFAULT_CHAIN_MAP.clear();
		DEFAULT_CHAIN_MAP.putAll(filterChainDefinitionMap);
		// 从菜单表中查询菜单配置
		List<SysMenuEntity> lists = sysMenuMapper.list(new Query());
		for(SysMenuEntity menu : lists) {
			String permKey = menu.getPerms();
			String permUrl = menu.getUrl();
			if(StringUtils.isNotEmpty(permKey) && StringUtils.isNotEmpty(permUrl)) {
				filterChainDefinitionMap.put(permUrl, "perms[" + permKey + "]");
			}
		}
		filterChainDefinitionMap.put("/**", "user");
		super.setFilterChainDefinitionMap(filterChainDefinitionMap);
		LOGGER.info("init perms finished.");
	}

}

package net.chenlin.dp.modules.sys.service;

import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sys.entity.SysOrgEntity;

import java.util.List;

/**
 * 组织机构
 * @author zcl<yczclcn@163.com>
 */
public interface SysOrgService {

	/**
	 * 查询机构列表
	 * @return
	 */
	List<SysOrgEntity> listOrg();

	/**
	 * 查询机构列表：ztree数据源
	 * @return
	 */
	List<SysOrgEntity> listOrgTree();

	/**
	 * 新增机构
	 * @param org
	 * @return
	 */
	R saveOrg(SysOrgEntity org);

	/**
	 * 根据id查询机构
	 * @param orgId
	 * @return
	 */
	R getOrg(Long orgId);

	/**
	 * 更新机构
	 * @param org
	 * @return
	 */
	R updateOrg(SysOrgEntity org);

	/**
	 * 删除机构
	 * @param id
	 * @return
	 */
	R bactchRemoveOrg(Long[] id);

	/**
	 * 查询所有直接子机构集合
	 * @param parentId
	 * @return
	 */
	List<Long> listOrgChildren(Long parentId);

	/**
	 * 递归查询所有子机构集合
	 * @param parentId
	 * @return
	 */
	List<Long> getAllOrgChildren(Long parentId);
	
}

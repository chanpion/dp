package net.chenlin.dp.modules.sys.service;

import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sys.entity.SysMacroEntity;

import java.util.List;

/**
 * 通用字典
 * @author zcl<yczclcn@163.com>
 */
public interface SysMacroService {

	/**
	 * 字典列表
	 * @return
	 */
	List<SysMacroEntity> listMacro();

	/**
	 * 字典上级列表：ztree数据源
	 * @return
	 */
	List<SysMacroEntity> listNotMacro();

	/**
	 * 新增字典
	 * @param macro
	 * @return
	 */
	R saveMacro(SysMacroEntity macro);

	/**
	 * 根据id查询字典
	 * @param id
	 * @return
	 */
	R getObjectById(Long id);

	/**
	 * 修改字典
	 * @param macro
	 * @return
	 */
	R updateMacro(SysMacroEntity macro);

	/**
	 * 批量删除字典
	 * @param id
	 * @return
	 */
	R batchRemove(Long[] id);

	/**
	 * 查询指定类型的参数列表
	 * @param type
	 * @return
	 */
	List<SysMacroEntity> listMacroValue(String type);
	
}

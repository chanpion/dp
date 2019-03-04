package net.chenlin.dp.modules.sys.service.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sys.dao.QuartzJobLogMapper;
import net.chenlin.dp.modules.sys.entity.QuartzJobLogEntity;
import net.chenlin.dp.modules.sys.service.QuartzJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 定时任务日志
 * @author zcl<yczclcn@163.com>
 */
@Service("quartzJobLogService")
public class QuartzJobLogServiceImpl implements QuartzJobLogService {

	@Autowired
	private QuartzJobLogMapper quartzJobLogMapper;

	/**
	 * 分页查询任务日志
	 * @param params
	 * @return
	 */
	@Override
	public Page<QuartzJobLogEntity> listForPage(Map<String, Object> params) {
		Query query = new Query(params);
		Page<QuartzJobLogEntity> page = new Page<>(query);
		quartzJobLogMapper.listForPage(page, query);
		return page;
	}

	/**
	 * 批量删除日志
	 * @param id
	 * @return
	 */
	@Override
	public R batchRemove(Long[] id) {
		int count = quartzJobLogMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	/**
	 * 清空日志
	 * @return
	 */
	@Override
	public R batchRemoveAll() {
		int count = quartzJobLogMapper.batchRemoveAll();
		return CommonUtils.msg(count);
	}


}

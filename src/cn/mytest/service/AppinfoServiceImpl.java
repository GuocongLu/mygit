package cn.mytest.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.mytest.dao.AppMapper;
import cn.mytest.pojo.Appinfo;

@Service
public class AppinfoServiceImpl implements AppinfoService {
    @Resource
    private AppMapper appMapper; 
    
	@Override
	public int getAppCount(String appDescribe) throws Exception {
		return appMapper.getAppCount(appDescribe);
	}

	@Override
	public List<Appinfo> getAppInfoList(String appDescribe, Integer curPage,
			Integer pageSize) throws Exception {
		return appMapper.getAppInfoList(appDescribe,(curPage-1)*pageSize, pageSize);
	}

}

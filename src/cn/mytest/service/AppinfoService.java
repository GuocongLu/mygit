package cn.mytest.service;

import java.util.List;

import cn.mytest.pojo.Appinfo;

public interface AppinfoService {

	public int getAppCount(String appDescribe) throws Exception;
	
	public List<Appinfo> getAppInfoList(String appDescribe,Integer curPage,Integer pageSize) throws Exception;
}

package cn.mytest.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.mytest.pojo.Appinfo;

public interface AppMapper {

	//app信息总条数查询
	public int getAppCount(@Param("appDescribe")String appDescribe);
	
	//app分页查询
	public List<Appinfo> getAppInfoList(@Param("appDescribe")String appDescribe,
			@Param("from")Integer from, @Param("pageSize")Integer pageSize);
}

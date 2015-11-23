package com.xdsc.service.sjjx_system;

import java.io.File;
import java.util.List;

import com.xdsc.model.TabInformation;

/**对通知公告信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public interface SjjxTabInformationManager {

	/**添加一条信息记录到数据库中
	 * @param info
	 */
	public abstract boolean saveSjjxTabInformation(TabInformation info);

	/**上传附件
	 * @param file
	 * @param info
	 * @param path
	 * @param fileName
	 * @return 返回信息记录
	 * @throws Exception
	 */
	public abstract TabInformation savefile(File file, TabInformation info,
			String path, String fileName) throws Exception;


	/**从数据库中删除一条信息记录
	 * @param info
	 */
	public abstract boolean deleteSjjxTabInformation(TabInformation info);

	/**更新一条信息记录
	 * @param info
	 */
	public abstract void updateSjjxTabInformation(TabInformation info);

	/**从数据库中读取到所有实践教学系统发出的通知公告信息
	 * @return 返回所有信息记录
	 */
	public abstract List<TabInformation> getSjjxTZGGTabInformations();

	/**通过信息编号查找到相应信息记录
	 * @param id
	 * @return 返回相应信息记录
	 */
	public abstract TabInformation getSjjxTabInformationByInfoId(int id);

}
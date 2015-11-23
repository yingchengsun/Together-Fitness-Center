package com.xdsc.dao.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabUploadfile;
/**
 * <p>功能：管理员对教辅系统中的上传课件资源进行管理，其中包括：查询资源、删除资源等<br>
 * @author qianxun
 * @version 1.1
 */
public interface AdminResourceManageDAO {

	/**
	 * <p>功能：查找出教辅系统中所有的课件资源<br>
	 * @return list 查找出来的信息列表
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public List<JfptTabUploadfile> findUploadfileInfo();
	/**
	 * <p>功能：根据资源编号进行资源删除<br>
	 * @param FNumber 资源编号
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public void deleteUpfileInfoByID(int FNumber);
	/**
	 * <p>功能：根据资源编号进行资源查找<br>
	 * @param FNumber 资源编号
	 * @return JfptTabUploadfile 资源对象
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber);
}

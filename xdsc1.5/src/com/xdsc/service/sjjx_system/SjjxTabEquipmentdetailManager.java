package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.SjjxTabEquipmentdetail;

/**���豸��������ϸ��Ϣ���в���
 * @author ��ѩ
 * @version1.1
 */
public interface SjjxTabEquipmentdetailManager {

	/**����һ���豸������¼�����ݿ���
	 * @param equipDetail
	 */
	public abstract boolean saveEquipDetail(SjjxTabEquipmentdetail equipDetail);

	/**�����ݿ���ɾ��һ���豸������¼
	 * @param equipDetail
	 * @return
	 */
	public abstract boolean deleteEquipDetail(SjjxTabEquipmentdetail equipDetail);

	/**�����ݿ��ж�ȡ���е��豸������¼
	 * @return �������в��ҵ���¼
	 */
	public abstract List<SjjxTabEquipmentdetail> getEquipDetailList();

	/**ͨ���豸��Ų��ҵ��豸������¼
	 * @param equipId
	 * @return ���ز��ҵ���¼
	 */
	public abstract List<SjjxTabEquipmentdetail> getEquipDetailByEquipId(Integer equipId);

	/**�����豸������¼
	 * @param equipDetail
	 */
	public abstract void updateEquipDetail(SjjxTabEquipmentdetail equipDetail);

}
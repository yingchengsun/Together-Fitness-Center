package com.xdsc.service.sjjx_system;

import java.io.InputStream;
import java.util.List;

import com.xdsc.model.SjjxTabEquipmenttype;

/**���豸������Ϣ��¼���в���
 * @author ��ѩ
 * @version1.1
 */
public interface SjjxTabEquipmenttypeManager {

	/**����һ���豸������Ϣ�����ݿ���
	 * @param equipType
	 */
	public abstract boolean saveEquipType(SjjxTabEquipmenttype equipType);

	/**�����ݿ���ɾ��һ���豸������Ϣ��¼
	 * @param equipType
	 */
	public abstract boolean deleteEquipType(SjjxTabEquipmenttype equipType);

	/**�����ݿ��ж�ȡ���е��豸���ͼ�¼
	 * @return �������в��ҵ���¼
	 */
	public abstract List<SjjxTabEquipmenttype> getEquipTypeList();

	/**ͨ���豸���ͱ�Ų��ҵ��豸���ͼ�¼
	 * @param equipTypeId
	 * @return ���ز��ҵ���¼
	 */
	public abstract SjjxTabEquipmenttype getEquipTypeByEquipTypeId(
			Integer equipTypeId);

	/**ͨ���豸�������Ʋ��ҵ��豸���ͼ�¼
	 * @param equipTypeName
	 * @return ���ز��ҵ���¼
	 */
	public abstract SjjxTabEquipmenttype getEquipTypeByEquipTypeName(
			String equipTypeName);
	
	public abstract List<SjjxTabEquipmenttype> getEquipTypeByEquipTypeName1(String equipTypeName);

	/**����һ���豸���ͼ�¼
	 * @param equipType
	 */
	public abstract void updateEquipType(SjjxTabEquipmenttype equipType);
	


}
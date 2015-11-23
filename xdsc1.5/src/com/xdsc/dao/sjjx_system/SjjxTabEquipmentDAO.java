package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.SjjxTabEquipment;

/**���豸������Ϣ��¼���в���
 * @author ��ѩ
 * @version1.1
 */
public interface SjjxTabEquipmentDAO {

	/**����һ���豸������Ϣ�����ݿ���
	 * @param equip
	 */
	public abstract boolean saveEquip(SjjxTabEquipment equip);

	/**�����ݿ���ɾ��һ���豸������Ϣ��¼
	 * @param equip
	 */
	public abstract boolean deleteEquip(SjjxTabEquipment equip);

	/**�����ݿ��ж�ȡ���е��豸������Ϣ��¼
	 * @return �������в��ҵ���¼
	 */
	public abstract List<SjjxTabEquipment> getEquipList();

	/**ͨ���豸��Ų��ҵ��豸��¼
	 * @param equipId
	 * @return ���ز��ҵ���¼
	 */
	public abstract SjjxTabEquipment getEquipByEquipId(Integer equipId);

	/**ͨ���豸�������Ʋ��Ҹ����������豸��¼
	 * @param equipTypeName
	 * @return �������в��ҵ���¼
	 */
	public abstract List<SjjxTabEquipment> getEquipByEquipTypeName(
			String equipTypeName);

	/**ͨ��ʵ���������ҵ���ʵ���������豸��¼
	 * @param labName
	 * @return �������в��ҵ���¼
	 */
	public abstract List<SjjxTabEquipment> getEquipByLabName(String labName);

	/**����һ���豸��¼
	 * @param equip
	 */
	public abstract void updateEquip(SjjxTabEquipment equip);

}
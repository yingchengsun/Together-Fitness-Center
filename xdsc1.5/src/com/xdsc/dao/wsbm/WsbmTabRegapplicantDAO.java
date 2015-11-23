package com.xdsc.dao.wsbm;

import java.util.List;

import com.xdsc.model.WsbmTabRegapplicant;
/**excel������������
 * @author ��С��
 * @version 1.2
 */
public interface WsbmTabRegapplicantDAO
{
	public void saveWsbmTabRegapplicant(WsbmTabRegapplicant user);

	public void removeWsbmTabRegapplicant(WsbmTabRegapplicant user);

	public WsbmTabRegapplicant findWsbmTabRegapplicantById(Integer id);

	public List<WsbmTabRegapplicant> findAllWsbmTabRegapplicants();

	public void updateWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant);
}

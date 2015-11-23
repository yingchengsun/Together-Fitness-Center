package com.xdsc.service.wsbm;

import java.io.InputStream;
import java.util.List;

import com.xdsc.model.WsbmTabRegapplicant;

/**excel�����������ݿ�
 * @author ��С��
 * @version 1.2
 */
public interface WsbmTabRegapplicantService
{
	public List<WsbmTabRegapplicant> findAll();

	public void save(WsbmTabRegapplicant wsbmTabRegapplicant);

	public void delete(WsbmTabRegapplicant wsbmTabRegapplicant);

	public WsbmTabRegapplicant findWsbmTabRegapplicantById(Integer id);

	public void update(WsbmTabRegapplicant wsbmTabRegapplicant);
	
	public InputStream getInputStream();
}

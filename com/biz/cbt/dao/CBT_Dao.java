package com.biz.cbt.dao;

import java.util.List;

import com.biz.cbt.vo.CBT_VO;
import com.biz.cbt.vo.CBT_VO_02;

public interface CBT_Dao {
	
	public void insert(CBT_VO_02 cbvo);	
	public List<CBT_VO> selectAll();	
	public CBT_VO_02 findById(long id_02);
	public void update (CBT_VO_02 cbvo);
	public void delete(long id_02);
	
}

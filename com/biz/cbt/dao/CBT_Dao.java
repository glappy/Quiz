package com.biz.cbt.dao;

import java.util.List;

import com.biz.cbt.vo.CBT_VO;
import com.biz.cbt.vo.CBT_VO_02;

public interface CBT_Dao {

	// dao class에서 crud 메서드 선언
	public void insert(CBT_VO_02 cbvo);	
	public List<CBT_VO> selectAll();	
	public CBT_VO_02 findById(long id_02);
	public void update (CBT_VO_02 cbvo);
	public void delete(long id_02);
	
}

package com.biz.exec;

import com.biz.cbt.service.CBT_Service;

public class CBT_Exec {

	public static void main(String[] args) {

		CBT_Service cs = new CBT_Service();
		cs.shuffleQue();
		cs.startQue();
		
	}
}
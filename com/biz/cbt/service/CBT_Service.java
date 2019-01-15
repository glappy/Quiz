package com.biz.cbt.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.cbt.dao.CBT_Dao;
import com.biz.cbt.dao.CBT_DaoImp;
import com.biz.cbt.vo.CBT_VO;
import com.biz.cbt.vo.CBT_VO_02;

public class CBT_Service {
	List<CBT_VO> cList; // 사용할 list, vo, scanner 선언
	List<CBT_VO_02> cbList;
	List<String> sList;
	CBT_VO cvo;
	CBT_VO_02 cbvo;
	CBT_Dao cbtDao;
	Scanner scan;

	public CBT_Service() {
		cList = new ArrayList(); // 선언 했던 것들 초기화
		cbList = new ArrayList();
		sList = new ArrayList();
		cbtDao = new CBT_DaoImp();
		scan = new Scanner(System.in);
		cvo = new CBT_VO();
		cbvo = new CBT_VO_02();

	}

	public void shuffleQue() {

		for(CBT_VO vo : cList) {
			System.out.println(vo);
		}
		for (CBT_VO v : cList) { //vo에 있는 데이터 섞기
			sList.add(cvo.getCb_fir());
			sList.add(cvo.getCb_sec());
			sList.add(cvo.getCb_thi());
			sList.add(cvo.getCb_fou());
			Collections.shuffle(sList);
			

			cbvo.setId_02(cvo.getId());
			cbvo.setCb_fir_02(sList.get(0));
			cbvo.setCb_sec_02(sList.get(1));
			cbvo.setCb_thi_02(sList.get(2));
			cbvo.setCb_fou_02(sList.get(3));
			cbvo.setCb_ans_02(cvo.getCb_ans());
			cbList.add(cbvo);
			
		}
		
		/* VO
		 * 1:문제1:보기1:보기2:보기3:보기4:정답
		 *		sList← 보기1	|	보기4
		 * 			←보기2	|	보기1
		 * 			←보기3	|	보기3
		 * 			←보기4	|	보기2
		 * 
		 * VO_02
		 * 1:문제1:sList(0):sList(1):sList(2):sList(3):정답
		 * cbList shuffle
		 */
		
		
		for(CBT_VO_02 cbvo : cbList) {
			Collections.shuffle(cbList);
		}
		
		for(CBT_VO_02 cbvo : cbList) {
			System.out.println(cbvo);
		}

	}

	public void startQue() {
		System.out.println("다음 메뉴 중 하나를 선택하세요");
		System.out.println("1.문제입력   2.문제풀이   0.종료\n");

		while (true) {
			String selected = scan.nextLine();
			/* 메뉴를 보여준 후 사용자에서 입력을 받고 0이면 리턴(메소드 종료), 
			 * 1이면 insertQue 메소드로, 2이면 solveQue메소드로..*/
			int intSel = Integer.valueOf(selected);

			if (intSel == 0) {
				System.out.println("종료합니다.");
				return;
			}

			if (intSel == 1) insertQue();
			if(intSel == 2) solveQue();

		}
	}

	public void insertQue() {
		System.out.println("1.문제등록   2.문제수정   3.문제삭제   0.종료\n");
		
		while(true) {			
			String selected = scan.nextLine();
			int intSel = Integer.valueOf(selected);
			
			if(intSel == 0) return;
			if(intSel == 1) insertQue();
			if(intSel == 2) udpateQue();
			if(intSel == 3) deleteQue();
		}
	}

	private void deleteQue() {
		// TODO 입력받아 삭제하
		System.out.println("삭제할 번호를 눌러주세요");
		String strNum = scan.nextLine();
		int intNum = Integer.valueOf(strNum);
		
		CBT_VO_02 cbvo = cbtDao.findById(intNum);
		
		System.out.println("삭제할 데이터 확인\n");
		System.out.println(cbvo.getCb_que_02());
		System.out.println(cbvo.getCb_fir_02());
		System.out.println(cbvo.getCb_sec_02());
		System.out.println(cbvo.getCb_thi_02());
		System.out.println(cbvo.getCb_fou_02());
		System.out.println("삭제하려면 9를 누르세요\n");
		
		String confirm = scan.nextLine();
		int intCon = Integer.valueOf(confirm);
		
		if(intCon == 9) cbtDao.delete(intNum);
			
	}

	private void udpateQue() {
		// TODO Auto-generated method stub
		System.out.println("수정할 번호 : ");
		// 사용자가 수정하겠다고 하면 입력을 받고 공백("")이 아니면 해당 내용을 변경함
		String insert = scan.nextLine();
		int intIn = Integer.valueOf(insert);
		
		CBT_VO_02 cbvo = new CBT_VO_02();
		
		System.out.println("문제 : " + cbvo.getCb_que_02());
		System.out.println("수정 : ");
		String que = scan.nextLine();

		System.out.println("보기1 : " + cbvo.getCb_fir_02());
		System.out.println("수정 : ");
		String fir = scan.nextLine();
		
		System.out.println("보기2 : " + cbvo.getCb_sec_02());
		System.out.println("수정 : ");
		String sec = scan.nextLine();
		
		System.out.println("보기3 : " + cbvo.getCb_thi_02());
		System.out.println("수정 : ");
		String thi = scan.nextLine();
		
		System.out.println("보기4 : " + cbvo.getCb_fou_02());
		System.out.println("수정 : ");
		String fou = scan.nextLine();
		
		System.out.println("정답 : " + cbvo.getCb_ans_02());
		System.out.println("수정 : ");
		String ans = scan.nextLine();
		
		if(!que.equals("")) cbvo.setCb_que_02(que);
		if(!fir.equals("")) cbvo.setCb_que_02(fir);
		if(!sec.equals("")) cbvo.setCb_que_02(sec);
		if(!thi.equals("")) cbvo.setCb_que_02(thi);
		if(!fou.equals("")) cbvo.setCb_que_02(fou);
	}

	public void solveQue() {
		System.out.println("정답을 입력하세요");
		System.out.println("Q : " + cbvo.getCb_que_02());
		System.out.println("1. " + cbvo.getCb_fir_02());
		System.out.println("2. " + cbvo.getCb_sec_02());
		System.out.println("3. " + cbvo.getCb_thi_02());
		System.out.println("4. " + cbvo.getCb_fou_02());
		
		cbtDao.update(cbvo);

		while (true) {

			String scanNum = scan.nextLine();
			int intNum = Integer.valueOf(scanNum);

			if (cbvo == null)
				break;

			if (intNum == cbvo.getCb_ans_02()) {
				System.out.println("정답입니다.");

			} else {
				System.out.println("다시 생각해보세요");
			}
		}
	}
	


}
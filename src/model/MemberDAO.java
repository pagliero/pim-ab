package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.Member;
import model.MemberFileWriter;

public class MemberDAO {
	private ArrayList<Member> memberList = null;
	
	private File file = null;
	private MemberFileReader fr = null;
	private MemberFileWriter fw = null;
	
	public MemberDAO(File file) {	
		this.file = file;
		try {
			fr = new MemberFileReader(file);
			memberList = fr.readMember();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Member> selectAll() { 
		// �Է��� �޸� �� �����ϴ� ��� ��� ������ ������ ���			
		return memberList;	
	}
	
	public Member selectMember(Member member) {
		int index = -1;
		if((index = searchByID(member)) >= 0)
			return memberList.get(index);
		else
			return null;
	}
	
	public int searchByID(Member member) { 
		int ret = -1; // ret�� 0 �̻��̸� �˻� ����, -1 �̸� �˻� ����
		int index = 0;
		for(Member m : memberList) {
			if(m.getUid().equals(member.getUid())) {
				ret = index;
				break;
			}
			index++;
		}				
		return ret;
	}
	
	public int insert(Member member) {
		int ret = -1;
		try {
			int index = searchByID(member);
			if(index < 0) { // -1�̸� �˻� ����, ��� ������
				fw = new MemberFileWriter(file);
				memberList.add(member);
				fw.saveMember(memberList);
				ret = 0;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return ret;
	}
	
	public int update(Member member) {
		int ret = -1; // 0 �̻��̸� �ش� ���̵� �����ϹǷ� ����, -1�����̸� ���� ����		
		
		
		return ret;
	}	
	public int delete(Member member) {		
		int ret = -1; // 0이상이면 해당 아이디가 존재하므로 삭제, -1 이하면 삭제 실패 
		try { 
			int index = searchByID(member);
			if(index > 0) {  // -1이면 검색 실패, 삭제 불가능, 0이상이어야 삭제가 가능 
				fw = new MemberFileWriter(file);
				memberList.remove(member); 
				/*
				 * ArrayList 객체를 작업에 따라 수정하고, 이를 MemberFileWriter 객체이ㅡ
				 * saveMember() 메소드에 전달 
				 */
				fw.saveMember(memberList);
				ret=0;
			}
			
		}
	catch(IOException e) {
		e.printStackTrace();
		
	}
		
		return ret;
	}
	public void printMemberList() {
		for(Member m : memberList)
			System.out.println(m.getUname() + ":" + m.getUid());
	}
}

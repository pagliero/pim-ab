package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.beans.property.SimpleStringProperty;

public class MemberFileReader {
	Scanner sc = null;
	
	public MemberFileReader(File f) throws FileNotFoundException {
		sc = new Scanner(f);
	}
	public ArrayList<Member> readMember() {
		ArrayList<Member> retObj = new ArrayList<Member>();
		while(sc.hasNext()) {
			Member m = new Member();
			String strArr[] = sc.nextLine().split("\t"); 
			// ���Ͽ� ����� ������ �ٴ����� �а�, �� ���� �� ��ȣ�� ��ĳ���Ͽ� ��ū���� �迭 ��ü�� ����
			System.out.println(">>>>>"+strArr[0] + strArr[1] + strArr[2]);
			m.setUid(strArr[0]);
			m.setUpw(strArr[1]);
			m.setUname(strArr[2]);
			retObj.add(m);			
		}
		return retObj;
	}
}
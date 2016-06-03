package dataservice;

import java.util.List;

import model.Book;
import model.LibraryMember;

public class MemberDataAccess extends iDataAccess {
	public void saveUser(LibraryMember member){
		List<LibraryMember> allMember = getAllItems();
		allMember.add(member);
		save(allMember);
	}
	public LibraryMember serachUser(String memberId){
		List<LibraryMember> allMember = getAllItems();
		for(LibraryMember member:allMember){
			if (member.getMemId().equals(memberId));
				return member;
		}
		return null;

	}

	public List<LibraryMember> getAllMembers(){
		List<LibraryMember> allMembers = getAllItems();
		return allMembers;
	}

	public void updateBook(LibraryMember member) {
		List<LibraryMember> allMember = getAllItems();
		for (int i=0;i<allMember.size();i++) {
			if (allMember.get(i).getMemId().equals(member.getMemId())) {
				allMember.add(i, member);
				//System.out.println(allBook.get(i).getCopies()[0].getCopyNum());
				break;
			}
		}
		//allMember.add(member);
		save(allMember);
	}
}

package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.MemberDAO;
import kr.co.vo.MemberVO;

@Service
public class MemberServiceImpl implements  MemberService{

	@Inject MemberDAO dao;
	
	@Override
	public void register(MemberVO vo) throws Exception{
		dao.register(vo);
	}
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception{
		return dao.login(vo);
	}
	
	
	//Controller에서 보내는 파라미터들을 memberUpdate(MemberVO vo)로 받고
	@Override
	public void memberUpdate(MemberVO vo) throws Exception{
		
		//받은 vo를 DAO로 보내준다.
		dao.memberUpdate(vo);
	}
	
	@Override
	public void memberDelete(MemberVO vo) throws Exception{
		dao.memberDelete(vo);
	}
	
	@Override
	public int passChk(MemberVO vo) throws Exception{
		int result = dao.passChk(vo);
		return result;
	}
}

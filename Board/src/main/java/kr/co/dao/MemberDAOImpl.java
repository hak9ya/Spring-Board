package kr.co.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject	SqlSession sql;
	//회원가입
	
	@Override
	public void register(MemberVO vo) throws Exception{
		sql.insert("memberMapper.register", vo);
	}
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception{
		return sql.selectOne("memberMapper.login", vo);
	}
	
	//서비스에서 보낸 파라미터들을 memberUpdate(MemberVO vo)에 담음
	@Override
	public void memberUpdate(MemberVO vo) throws Exception{
		//vo에 담긴 파라미터들은 memberMapper.xml에 memberMapper라는 namespace에
		//아이디가 memberUpdate인 쿼리에 파라미터들을 넣어줌
		sql.update("memberMapper.memberUpdate", vo);
	}
	
	//업데이트와 같음
	@Override
	public void memberDelete(MemberVO vo) throws Exception{
		//MemberVO에 담긴 값들을 보냄
		//xml에서 memberMapper.memberDelete에 #{userId}, #{userPass}에 파라미터값이 매칭됨
		sql.delete("memberMapper.memberDelete", vo);
	}

	@Override
	public int passChk(MemberVO vo) throws Exception{
		int result = sql.selectOne("memberMapper.passChk", vo);
		return result;
	}
}

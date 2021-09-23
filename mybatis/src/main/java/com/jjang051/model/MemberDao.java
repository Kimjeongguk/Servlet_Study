package com.jjang051.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDao {
	//sqlSession을 만들어줄 공장 SqlSessionFactory  pool
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/jjang051/mybatis/config.xml"; // 외부에 있는 xml파일을 읽어 들여야 한다.
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// connection 만들기 끝
	//메서드
	public List<MemberDto> showAllMember() {
		List<MemberDto> memberList = null;
		SqlSession sqlSession =  sqlSessionFactory.openSession();
		memberList = sqlSession.selectList("showAllMember"); // MemberMapper  에 있는 id 찾아서 쓰기....
		sqlSession.close();
		return memberList;
	}
	
	public MemberDto getSelectOne(int no) {
		MemberDto memberInfo = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		memberInfo = sqlSession.selectOne("getSelectOne",no);
		sqlSession.close();
		return memberInfo;
	}
	
	public int insertMember(MemberDto memberDto) {
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();// commit
		//SqlSession sqlSession = sqlSessionFactory.openSession(true);true를 적으면 자동 커밋
		result = sqlSession.insert("insertMember",memberDto);
		sqlSession.commit(); // select 빼고는 commit();
		sqlSession.close();
		return result;
	}
	
	public String getPassword(int no) {
		String password = "";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		password = sqlSession.selectOne("getPassword",no);
		sqlSession.close();
		return password;
	}
	
	public int deleteMember(int no) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.delete("deleteMember",no);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
}















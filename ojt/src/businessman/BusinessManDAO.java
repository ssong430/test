package businessman;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sqlmap.MyAppSqlConfig;

public class BusinessManDAO {

	private static SqlSessionFactory sqlMapper;
	private static SqlSession session;

	static {
		sqlMapper = MyAppSqlConfig.getSqlMapInstance();
		session = sqlMapper.openSession(true);

	}
	
	public boolean delete(String businessID) {
		boolean flag = false;
		int cnt = session.delete("businessman.delete",businessID);
		if(cnt>0)flag = true;
		return flag;
		
	}
	
	public boolean update(BusinessManDTO dto) {
		boolean flag = false;
		int cnt = session.update("businessman.update",dto);
		if(cnt>0)flag = true;
		return flag;
	}
	
	
	
	public BusinessManDTO read(String businessID) {
		
		BusinessManDTO dto = session.selectOne("businessman.read",businessID);
		return dto;
		
	}
	
	
	
	public boolean create(BusinessManDTO dto) {
		boolean flag = false;
		int cnt = session.insert("businessman.create",dto);
		if(cnt>0)flag = true;
		return flag;
		
	}

}

package notice;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sqlmap.MyAppSqlConfig;

public class NoticeDAO {

	
	private static SqlSessionFactory sqlMapper;
	private static SqlSession session;
	
	static {
		sqlMapper = MyAppSqlConfig.getSqlMapInstance();
		session = sqlMapper.openSession(true);
	}
	
	public boolean create(NoticeDTO dto) {
		
		boolean flag = false;
		int cnt = session.insert("notice.create",dto);
		if(cnt>0)flag = true;
		return flag;
	}
	
	public boolean update(NoticeDTO dto) {
		boolean flag =false;
		int cnt = session.update("notice.update",dto);
		if(cnt>0)flag = true;
		return flag;
	}
	
	public NoticeDTO read(int notice_num) {
		
		NoticeDTO dto = session.selectOne("notice.read",notice_num);
		return dto;
		
	}
	
	public boolean delete(int notice_num) {
		boolean flag = false;
		int cnt = session.delete("notice.delete",notice_num);
		if(cnt>0)flag = true;
		return flag;
	}
	
}

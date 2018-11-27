package businessman;

public class BusinessManTest {

	public static void main(String[] args) {
		BusinessManDAO dao = new BusinessManDAO();

		//create(dao);
		//read(dao);
		//update(dao);
		//delete(dao);
	}

	private static void delete(BusinessManDAO dao) {
		String businessID = "heyyo";
		
		if(dao.delete("heyyo")) {
			p("삭제되었습니다.");
		}else {
			p("삭제 실패");
		}
		
	}

	private static void update(BusinessManDAO dao) {
		BusinessManDTO dto = dao.read("heyyo");
		
		dto.setB_address1("경기도");
		dto.setB_address2("양주");
		dto.setB_phone("010-1234-1234");
		dto.setB_email("heeyyoo@naver.com");
		
		if(dao.update(dto)) {
			p("수정 완료");
		}else {
			p("수정 실패");
		}
		
	}

	private static void read(BusinessManDAO dao) {
		String businessID = "heyyo";
		BusinessManDTO dto = dao.read(businessID);
		p(dto);
		
	}

	private static void create(BusinessManDAO dao) {
		BusinessManDTO dto = new BusinessManDTO();

		dto.setBusinessID("heyyo");
		dto.setB_passwd("1234");
		dto.setB_name("김길동");
		dto.setB_sex("남");
		dto.setB_address1("서울시 종로구");
		dto.setB_address2("솔데스크");
		dto.setB_phone("010-9899-9999");
		dto.setB_email("heyyo@naver.com");

		if (dao.create(dto)) {
			p("create 성공");
		} else {
			p("create 실패");
		}
	}

	private static void p(String string) {
		System.out.println(string);
	}

	public static void p(BusinessManDTO dto) {
		p("아이디 :" + dto.getBusinessID());
		p("비밀번호 :" + dto.getB_passwd());
		p("이름 :" + dto.getB_name());
		p("성별 :" + dto.getB_sex());
		p("주소 :" + dto.getB_address1());
		p("상세주소 :" + dto.getB_address2());
		p("핸드폰 :" + dto.getB_phone());
		p("이메일 :" + dto.getB_email());
	}
}

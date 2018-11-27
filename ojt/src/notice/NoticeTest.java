package notice;

public class NoticeTest {

	public static void main(String[] args) {
		NoticeDAO dao = new NoticeDAO();
		//read(dao);
		//create(dao);
		//update(dao);
		//delete(dao);
	}

	private static void delete(NoticeDAO dao) {
		int notice_num = 2;
		
		if(dao.delete(notice_num)) {
			p("삭제 완료");
		}else {
			p("삭제 실패");
		}
		
	}

	private static void read(NoticeDAO dao) {
		
		 int notice_num = 2;
		 NoticeDTO dto = dao.read(notice_num);
		 p(dto);
	}

	private static void update(NoticeDAO dao) {
		NoticeDTO dto = dao.read(1);
		
		dto.setNotice_title("공지사항 수정5");
		dto.setNotice_content("수정입니다.5");
		
		if(dao.update(dto)) {
			p("수정 완료");
		}else{
			p("수정 실패");
		}
		
	}

	private static void create(NoticeDAO dao) {
		NoticeDTO dto = new NoticeDTO();

		dto.setNotice_num(2);
		dto.setNotice_title("공지사항2");
		dto.setNotice_content("꼭 읽어주세요");
		dto.setNotice_filename("file이름");

		if (dao.create(dto)) {
			p("create성공");
		} else {
			p("create실패");
		}
	}

	private static void p(String string) {
		System.out.println(string);

	}

	public static void p(NoticeDTO dto) {
		p("글번호 :" + dto.getNotice_num());
		p("글제목 :" + dto.getNotice_title());
		p("글내용 :" + dto.getNotice_content());
		p("파일이름 :" + dto.getNotice_filename());

	}
}

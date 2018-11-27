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
			p("���� �Ϸ�");
		}else {
			p("���� ����");
		}
		
	}

	private static void read(NoticeDAO dao) {
		
		 int notice_num = 2;
		 NoticeDTO dto = dao.read(notice_num);
		 p(dto);
	}

	private static void update(NoticeDAO dao) {
		NoticeDTO dto = dao.read(1);
		
		dto.setNotice_title("�������� ����5");
		dto.setNotice_content("�����Դϴ�.5");
		
		if(dao.update(dto)) {
			p("���� �Ϸ�");
		}else{
			p("���� ����");
		}
		
	}

	private static void create(NoticeDAO dao) {
		NoticeDTO dto = new NoticeDTO();

		dto.setNotice_num(2);
		dto.setNotice_title("��������2");
		dto.setNotice_content("�� �о��ּ���");
		dto.setNotice_filename("file�̸�");

		if (dao.create(dto)) {
			p("create����");
		} else {
			p("create����");
		}
	}

	private static void p(String string) {
		System.out.println(string);

	}

	public static void p(NoticeDTO dto) {
		p("�۹�ȣ :" + dto.getNotice_num());
		p("������ :" + dto.getNotice_title());
		p("�۳��� :" + dto.getNotice_content());
		p("�����̸� :" + dto.getNotice_filename());

	}
}

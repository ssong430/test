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
			p("�����Ǿ����ϴ�.");
		}else {
			p("���� ����");
		}
		
	}

	private static void update(BusinessManDAO dao) {
		BusinessManDTO dto = dao.read("heyyo");
		
		dto.setB_address1("��⵵");
		dto.setB_address2("����");
		dto.setB_phone("010-1234-1234");
		dto.setB_email("heeyyoo@naver.com");
		
		if(dao.update(dto)) {
			p("���� �Ϸ�");
		}else {
			p("���� ����");
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
		dto.setB_name("��浿");
		dto.setB_sex("��");
		dto.setB_address1("����� ���α�");
		dto.setB_address2("�ֵ���ũ");
		dto.setB_phone("010-9899-9999");
		dto.setB_email("heyyo@naver.com");

		if (dao.create(dto)) {
			p("create ����");
		} else {
			p("create ����");
		}
	}

	private static void p(String string) {
		System.out.println(string);
	}

	public static void p(BusinessManDTO dto) {
		p("���̵� :" + dto.getBusinessID());
		p("��й�ȣ :" + dto.getB_passwd());
		p("�̸� :" + dto.getB_name());
		p("���� :" + dto.getB_sex());
		p("�ּ� :" + dto.getB_address1());
		p("���ּ� :" + dto.getB_address2());
		p("�ڵ��� :" + dto.getB_phone());
		p("�̸��� :" + dto.getB_email());
	}
}

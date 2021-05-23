package controller;
<<<<<<< HEAD
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
=======
>>>>>>> 0256c1c125ff4c463f1198edcc973869bcb36a1c
import java.util.Scanner;

import entity.Client;
<<<<<<< HEAD
import entity.CompensationHandle;
import entity.Contract;
import entity.ContractManagement;
=======
>>>>>>> 0256c1c125ff4c463f1198edcc973869bcb36a1c
import entity.InsuranceProduct;
import entity.InsuranceProducts;
import entity.Manager;
<<<<<<< HEAD
import entity.Pension;
import list.ClientList;
import service.ClientService;
=======
>>>>>>> 0256c1c125ff4c463f1198edcc973869bcb36a1c
import service.ClientServiceImpl;
import service.InsuranceProductServiceImpl;
import service.ManagerServiceImpl;

public class ConsoleController{
	
	private Scanner sc;
	private ClientServiceImpl clientService;
	private InsuranceProductServiceImpl insuranceProductService;
	private ManagerServiceImpl managerService;
	private Manager managerLogin;
	private Client clientLogin;
	
	public ConsoleController() {
		this.sc = new Scanner(System.in);
		this.clientService = new ClientServiceImpl();
		this.insuranceProductService = new InsuranceProductServiceImpl();
		this.managerService = new ManagerServiceImpl();
		
		this.managerLogin = null;
		this.clientLogin = null;
	}
	
	public void run() {
		this.mainMenu();
	}
	
	private void mainMenu() {
		while(true) {
			System.out.println("\n---MainMenu---");
			System.out.println("1.관리자");
			System.out.println("2.회원");
			System.out.println("3.보험");
			System.out.println("4.끝내기");
			switch(sc.nextInt()) {
			case 1:
				managerMenu();
				break;
			case 2:
				clientMenu();
				break;
			case 3:
				insuranceMenu();
				break;
			case 4:
				return;
			}
		}
	}
	
	//ManagerMenus
	private void managerMenu() {
		while(true) {
			System.out.println("\n---ManagerMenu---");
			System.out.println("1.관리자 등록");
			System.out.println("2.관리자 로그인");
			System.out.println("3.관리자 삭제");
			System.out.println("4.돌아가기");
			switch(sc.nextInt()) {
			case 1:
				System.out.println(managerService.register() ? "등록이 완료되었습니다." : "등록에 실패하였습니다.");
				break;
			case 2:
				if(managerLogin == null) managerLogin = managerService.login();
				if(managerLogin != null) managerWorkMenu();
				else System.out.println("없는 매니저입니다.");
				break;
			case 3:
				System.out.println(managerService.delete() ? "삭제가 완료되었습니다." : "삭제에 실패하였습니다.");
				break;
			case 4:
				return;
			default: 
				System.out.println("잘못된 값을 입력하셨습니다.");
				break;
			}
		}
	}
	
<<<<<<< HEAD
	private void managerRegisterMenu() {
		System.out.println("[JobPosition]");
		System.out.println("[1.蹂댄뿕�긽�뭹媛쒕컻�옄 2.蹂댄뿕�긽�뭹�듅�씤�옄 3.U/W 4.怨꾩빟愿�由ъ옄 5.蹂댁긽泥섎━�옄 6.�쁺�뾽�궗�썝]");
		int input = sc.nextInt();
		Manager manager = ManagerType.values()[input-1].getManager().clone();
		manager.setJobPosition(ManagerType.values()[input-1]);
		sc.nextLine();
		
		//System.out.println("[�씠由�]");
		//manager.setName(sc.nextLine());
		
		//System.out.println("[�굹�씠]");
		//manager.setAge(sc.nextInt());
		//sc.nextLine();
		
		//System.out.println("[�쟾�솕踰덊샇]");
		//manager.setPhoneNumber(sc.nextLine());
		
		System.out.println("[ID]");
		manager.setId(sc.nextLine());
		
		System.out.println("[Password]");
		manager.setPassword(sc.nextLine());
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("current: " + df.format(cal.getTime()));
        cal.add(Calendar.YEAR, 10);
        System.out.println("after: " + df.format(cal.getTime()));
		System.out.println(managerService.register(manager) ? "�벑濡앹씠 �셿猷뚮릺�뿀�뒿�땲�떎." : "�벑濡앹뿉 �떎�뙣�븯����뒿�땲�떎.");
	}
	
	private void managerLoginMenu() {
		sc.nextLine();
		if (managerLogin == null) {
			System.out.println("[ID]");
			String id = sc.nextLine();
			System.out.println("[Password]");
			String pw = sc.nextLine();
			
			managerLogin = managerService.login(id, pw);
		}
		if (managerLogin != null)
			managerWorkMenu();
		else
			System.out.println("�벑濡앸릺吏� �븡��� 留ㅻ땲����엯�땲�떎.");	
	}

	private void managerDeleteMenu() {
		System.out.println("[ID]");
		String id = sc.nextLine();
		System.out.println("[Password]");
		String pw = sc.nextLine();
		
		System.out.println(managerService.delete(id, pw) ? "�궘�젣媛� �셿猷뚮릺�뿀�뒿�땲�떎." : "�궘�젣�뿉 �떎�뙣�븯����뒿�땲�떎.");
	}
	
	private void managerWorkMenu() {//managerWorkMenu
		switch (managerLogin.getJobPosition()) {//manager吏곸뾽留덈떎 �떎瑜� 硫붾돱
=======
	private void managerWorkMenu() {
		switch(managerLogin.getJobPosition()) {
>>>>>>> 0256c1c125ff4c463f1198edcc973869bcb36a1c
		case IP:
			insuranceProductsMenu();
			break;
		case IPA:
			
			break;
		case UW:
			
			break;
		case CM:
			contractManagementMenu();
			break;
			
		case CH:
			
			break;
		case SP:
			
			break;
		}
	}
	
	private void insuranceProductsMenu() {
		InsuranceProducts ip = (InsuranceProducts)managerLogin;
		while(true) {
			System.out.println("\n---InsuranceProductsMenu---");
			System.out.println("1.보험상품 설계");
			System.out.println("2.사후관리");
			System.out.println("3.계약관리");
			System.out.println("3.로그아웃");
			switch(sc.nextInt()) {
			case 1:
				InsuranceProduct developedProduct = ip.designInsurance().developInsurance();
				insuranceProductService.add(developedProduct);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				managerLogin = null;
				return;
			}
		}
	}
<<<<<<< HEAD
	
	private void approvalMenu(InsuranceProduct insuranceProduct) {
		System.out.println("\n1.蹂댄뿕�듅�씤 2.蹂댄뿕�듅�씤嫄곗젅 3.�룎�븘媛�湲�");
		int a = sc.nextInt();
		switch (a) {
		case 1:
			insuranceProduct.setApproval(true);
			System.out.println("�듅�씤�씠 �셿猷뚮릺�뿀�뒿�땲�떎.");
			return;
		case 2:
			insuranceProductService.showInsuranceProductIsNotApproval().remove(insuranceProduct);
			System.out.println("�듅�씤�씠 嫄곗젅 �릺�뿀�뒿�땲�떎. 紐⑸줉�뿉�꽌 �궘�젣�빀�땲�떎.");
			return;
		case 3:
			return;
		}
	}
	
	private void approvalInsuranceDelete() {//�듅�씤�븳蹂댄뿕�궘�젣
		System.out.println("--�궘�젣�븷 蹂댄뿕�쓣 �꽑�깮�빐二쇱꽭�슂.--");
		int x = sc.nextInt();
		System.out.println("1.�궘�젣�븯湲� 2.�룎�븘媛�湲�");
		int y = sc.nextInt();
		switch(y) {
		case 1:
			insuranceProductService.showInsuranceProductIsApproval().remove(x-1);
			System.out.println(insuranceProductService.showInsuranceProductIsApproval().size());
			System.out.println("�궘�젣媛� �셿猷뚮릺�뿀�뒿�땲�떎.");
			break;
		case 2:
			return;
		}
	}
	
	private void emailSend() {//�씠硫붿씪 蹂대궡湲� (21.05.18)
		String user = ""; // gmail怨꾩젙
		String password = ""; // �뙣�뒪�썙�뱶

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("hm5395@naver.com")); // �닔�떊�옄
			message.setSubject("Test"); // 硫붿씪 �젣紐⑹쓣 �엯�젰
			message.setText("Test"); // 硫붿씪 �궡�슜�쓣 �엯�젰
			Transport.send(message); // �쟾�넚
			System.out.println("Message sent successfully...!!");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private void followUpInsurance() {//�궗�썑愿�由�
		System.out.println("蹂댄뿕紐⑸줉�뿉�꽌 �궗�썑愿�由ы븷 蹂댄뿕�쓣 �꽑�깮�빐二쇱꽭�슂.");
		InsuranceProduct selectedInsuranceProduct = this.insuranceMenu(insuranceProductService.showInsuranceProductIsApproval());
		System.out.println("�빐�떦 蹂댄뿕�쓣 �닔�젙�븯�떆寃좎뒿�땲源�? 1.�닔�젙�븯湲�, 2.�뮘濡쒓��湲�");
		int input = sc.nextInt();
		sc.nextLine();
		switch(input) {
		case 1:
			this.modifyInsuranceProduct(selectedInsuranceProduct);
			break;
		case 2:
			return;
		}
		
	}

	private void modifyInsuranceProduct(InsuranceProduct selectedInsuranceProduct) {
		switch(selectedInsuranceProduct.getInsuranceProductType()) {
		case ACTUALEXPENSE:
			this.developActualExpense(selectedInsuranceProduct);
			break;
		case CANCER:
			this.developCancer(selectedInsuranceProduct);
			break;
		case PENSION:
			this.developPension(selectedInsuranceProduct);
			break;
		case LIFE:
			this.developLife(selectedInsuranceProduct);
			break;
		}

	}

	private void underWriterMenu() {//UW(UW)
//		UW uw = (UW)managerLogin;
=======
	private void contractManagementMenu() {
		ContractManagement cm = (ContractManagement)managerLogin;
>>>>>>> 0256c1c125ff4c463f1198edcc973869bcb36a1c
		while(true) {
			System.out.println("\n---ContractManagementMenu");
			System.out.println("1.계약한 보험 관리");
			System.out.println("2.만료된 보험계약 관리");
			System.out.println("3.로그아웃");
			switch(sc.nextInt()) {
			case 1:
				Contract c
			}
		}
	}
	
<<<<<<< HEAD
	private Contract selectUnderWriteContract() {
		ArrayList<Contract> contractList = contractService.selectNotApproval();
		if (contractList.size() > 0) {
			System.out.println("[�씤�닔�떖�궗 怨꾩빟 紐⑸줉]");
			for (int i = 0; i < contractList.size(); i++)
				System.out.println(String.format("%d.%5s%10s", i + 1, contractList.get(i).getClientID(),
						contractList.get(i).getProductName()));
			System.out.println("�씤�닔�떖�궗�븷 怨꾩빟�쓽 踰덊샇瑜� �엯�젰�빐二쇱꽭�슂.");
			int input = sc.nextInt();
			Contract contract = contractList.get(input - 1);
			this.showClientInfo(contract.getClientID());
//			this.showInsuranceProductDetail(contract.getProductName());
			return contract;
		} else {
			System.out.println("�쁽�옱 �떖�궗�븷 怨꾩빟�씠 �뾾�뒿�땲�떎.");
			return null;
		}
	}
	
	private void showClientInfo(String clientID) {
		Client client = clientService.login(clientID, clientID);
		System.out.println("[怨좉컼 �젙蹂�]");
		System.out.println("�씠由�: " + client.getName());
		System.out.println("�굹�씠: " + client.getAge());
		System.out.println("�꽦蹂�: " + (client.isGender() ? "�궓�옄" : "�뿬�옄"));
		System.out.println("吏곸뾽: " + client.getJob().getJobName());
		System.out.println("�븫寃쎈젰: " + client.getMedicalHistory().getClientCancerCareer().getCancerName() + "(蹂몄씤)"
				+ client.getMedicalHistory().getFamilyCancerCareer().getCancerName() + "(媛�議�)");
		System.out.println("�엯�썝�궡�뿭: " + client.getMedicalHistory().getNumberOfHospitalizations());
		System.out.println("蹂묒썝吏꾨즺: " + client.getMedicalHistory().getNumberOfHospitalVisits());
	}
	
	private void contractManagerMenu() {// CM(怨꾩빟愿�由ъ옄)
		// ContractManagement contractManagement = (ContractManagement)managerLogin;
		
	}
	
	private void compensationHandleMenu() {// CH(蹂댁긽泥섎━�옄)
		CompensationHandle compensationHandle = (CompensationHandle) managerLogin;
		while (true) {
			System.out.println("\n---CompensationHandleMenu---");
			System.out.println("1.�궗怨좎쿂由�");
			System.out.println("2.濡쒓렇�븘�썐");
			switch (sc.nextInt()) {
			case 1:
				this.accidentHandlingMenu(compensationHandle);
				break;
			case 2:
				managerLogin = null;
				break;
			}
		}
	}
	
	private void accidentHandlingMenu(CompensationHandle compensationHandle) {
		while(true) {
			System.out.println("蹂닿퀬�떢��� �궗怨좎쓽 蹂댄뿕醫낅쪟瑜� �꽑�깮�빐二쇱꽭�슂.");
			System.out.println("[1.�떎鍮꾨낫�뿕, 2.�븫蹂댄뿕, 3.�뿰湲덈낫�뿕, 4.醫낆떊蹂댄뿕, 5.�룎�븘媛�湲�]");
			int input = sc.nextInt();
			if(input == 5) break; 
			ArrayList<Accident> accidentList = contractService.showAccidentListByProductType(InsuranceProductType.values()[input-1]);		
			System.out.println("[�궗怨� 紐⑸줉]");
			int i = 0;
			for(Accident accident : accidentList) {
				Client client = accident.getClient();
				System.out.println(String.format("%d.%5s%10s%12s", i+1, client.getName(), accident.getInsuranceProduct().getProductName(), accident.getReceptionDate().toString()));
				i++;
			}
			System.out.println("�긽�꽭�젙蹂대�� 蹂닿퀬 �떢��� �궗怨좎쓽 踰덊샇瑜� �엯�젰�빐二쇱꽭�슂.");
			input = sc.nextInt();
			this.showAccidentDetail(compensationHandle, accidentList.get(input-1));
		}
	}
	
	private void showAccidentDetail(CompensationHandle compensationHandle, Accident accident) {
		Client client = accident.getClient();
		System.out.println("[�긽�꽭�젙蹂�]");
		System.out.println("怨좉컼 �씠由�: " + client.getName());
		System.out.println("怨좉컼 �굹�씠: " + client.getAge());
		System.out.println("�젒�닔 �궡�슜: " + accident.getAccidentDetail());
		System.out.println("�젒�닔 �궇吏�:" + accident.getReceptionDate());
		
		System.out.println("\n1.蹂댄뿕湲� �엯�젰");
		System.out.println("2.�룎�븘媛�湲�");
		switch(sc.nextInt()) {
			case 1:
				System.out.println("蹂댄뿕湲덉쓣 �엯�젰�빐二쇱꽭�슂.");
				System.out.println(compensationHandle.payInsuranceMoney(sc.nextInt(), client)? "蹂댄뿕湲� 吏�湲됱씠 �셿猷뚮릺�뿀�뒿�땲�떎." : "蹂댄뿕湲� 吏�湲됱뿉 �떎�뙣�븯����뒿�땲�떎.");
				break;
			case 2:
				return;
		}
	}
	
	private void salesPersonMenu() {//SP(�쁺�뾽�궗�썝)
		while(true) {
			System.out.println("\n---salesPersonMenu---");
			System.out.println("1.�쁺�뾽 �솢�룞 愿�由�");
			System.out.println("2.紐⑤뱺 蹂댄뿕 議고쉶");
			System.out.println("4.濡쒓렇�븘�썐");
			switch(sc.nextInt()) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				managerLogin = null;
				break;
			}
		}
	}
	
	private void clientWorkMenu() {//誘몄셿�꽦
		System.out.println("1.紐⑤뱺 蹂댄뿕 議고쉶�븯湲� 2.媛��엯�븳 蹂댄뿕 議고쉶�븯湲� 3.濡쒓렇�븘�썐");
		switch (sc.nextInt()) {
		case 1:
			if(insuranceMenu(insuranceProductService.showInsuranceProductIsApproval()) == null) {
				System.out.println("\n�씠�쟾 �럹�씠吏�濡� �룎�븘媛묐땲�떎.");
				return;
			}else
			contractRegisterClient();
		case 2:
			signUpInsuranceProductMenu();
		case 3:
			clientLogin = null;
			return;
		}
	}
	
	private void contractRegisterClient() {//誘몄셿�꽦
			System.out.println("/n1.媛��엯�븯湲� 2.�룎�븘媛�湲�");
			int a = sc.nextInt();
			switch(a) {
			case 1://怨꾩빟 由ъ뒪�듃�뿉 �꽔湲�
				
				break;
			case 2:
				return;
			}
		}
	
	private void signUpInsuranceProductMenu() {//誘몄셿�꽦
		
	}
	
	private void clientMenu() {// clientMenu
		while (true) {
=======
	//clientMenus
	private void clientMenu() {
		while(true) {
>>>>>>> 0256c1c125ff4c463f1198edcc973869bcb36a1c
			System.out.println("\n---ClientMenu---");
			System.out.println("1.회원가입");
			System.out.println("2.회원 로그인");
			System.out.println("3.회원 탈퇴");
			System.out.println("4.돌아가기");
			switch(sc.nextInt()) {
			case 1:
				clientService.register();
				break;
			case 2:
				if(clientLogin == null) clientLogin = clientService.login();
				break;
			case 3:
				clientService.delete();
				break;
			case 4:
				return;
			}
		}
	}
<<<<<<< HEAD

	private void clientRegisterMenu() {
		sc.nextLine();
		Client client = new Client();
		//clientService.checkClientID(client.getId()) == null
		System.out.println("[ID]");
		client.setId(sc.nextLine());
		
		if(clientService.checkClientID(client.getId()) !=null) {
			System.out.println("�씠誘� 媛��엯�맂 ID�엯�땲�떎. �떎�떆 �엯�젰�빐二쇱꽭�슂.");
			client.setId(sc.nextLine());
		}
		System.out.println(client.getId());
		System.out.println("鍮꾨��踰덊샇瑜� �엯�젰�븯�꽭�슂");
		client.setPassword(sc.nextLine());
		System.out.println(client.getPassword());
		System.out.println("[�씠由�]");
		client.setName(sc.nextLine());
		System.out.println("[�굹�씠]");
		client.setAge(sc.nextInt());
		//System.out.println("[Email]");
		//client.setEmail(sc.nextLine());
		//sc.nextLine();
		/*System.out.println("[�꽦蹂� (1.�궓 2.�뿬)]");
		if (sc.nextInt() == 1) {
			client.setGender(true);
			System.out.println("�궓�옄");
		} else {
			client.setGender(false);
			System.out.println("�뿬�옄");
		}*/
		/*System.out.println("[ClientJobType]");
		System.out.println("[1.援곗씤 2.PW 3.AF 4.DRIVER 5.ETC]");
		int input = sc.nextInt();
		ClientJobType.values()[input - 1].getJobName();
		System.out.println(ClientJobType.values()[input - 1].getJobName());
		sc.nextLine();
		System.out.println("二쇱냼瑜� �엯�젰�븯�꽭�슂.");
		client.setAddress(sc.nextLine());
		System.out.println("�빖�뱶�룿 踰덊샇瑜� �엯�젰�븯�꽭�슂.");
		client.setPhoneNumber(sc.nextLine());
		System.out.println("二쇰�쇰벑濡앸쾲�샇瑜� �엯�젰�븯�꽭�슂.");
		client.setResidentRegistrationNumber(sc.nextLine());
		System.out.println("怨꾩쥖踰덊샇瑜� �엯�젰�븯�꽭�슂.");
		client.setBankAccountNumber(sc.nextLine());*/
		
		System.out.println(clientService.register(client) ? "�쉶�썝媛��엯�씠 �셿猷뚮릺�뿀�뒿�땲�떎." : "�쉶�썝媛��엯�뿉 �떎�뙣�뻽�뒿�땲�떎.");
	}

	private void clientLoginMenu(){
		if (clientLogin == null) {sc.nextLine();
			System.out.println("--ID瑜� �엯�젰�빐二쇱꽭�슂.--");
			String id = sc.nextLine();
			System.out.println("--Password瑜� �엯�젰�빐二쇱꽭�슂.--");
			String pw = sc.nextLine();
			clientLogin = clientService.login(id, pw);
		}
		if (clientLogin != null) {
			clientWorkMenu();
		} else
			System.out.println("�엯�젰�븯�떊 �젙蹂대�� �솗�씤�빐二쇱꽭�슂.");
	}
=======
>>>>>>> 0256c1c125ff4c463f1198edcc973869bcb36a1c
	
	//insuranceMenus
	private void insuranceMenu() {
		System.out.println("\n---InsuranceList---");
		int i = 1;
<<<<<<< HEAD
		if (insuranceProductList.isEmpty()) {
			System.out.println("�쁽�옱 以�鍮꾨맂 �긽�뭹�씠 �뾾�뒿�땲�떎.");
		} else {
			for (InsuranceProduct insuranceProduct : insuranceProductList) {
				System.out.println(i + ". " + insuranceProduct.getProductName() + " "
						+ insuranceProduct.getInsuranceProductType().getInsuranceName());
				i++;
			}
				System.out.println("\n蹂댄뿕�긽�뭹�쓽 踰덊샇瑜� �엯�젰�빐二쇱꽭�슂.");
				InsuranceProduct selectInsurance = insuranceProductList.get(sc.nextInt() - 1);
				this.showInsuranceProductDetail(selectInsurance);
				return selectInsurance;
=======
		for(InsuranceProduct insuranceProduct : insuranceProductService.showAllList()) {
			System.out.println(i+". " + insuranceProduct.getProductName() +" "+ insuranceProduct.getInsuranceProductType().getInsuranceName());
			i++;
>>>>>>> 0256c1c125ff4c463f1198edcc973869bcb36a1c
		}
	//contractMenu
	private void contractMenu() {
		System.out.println("\n---ContractList---");
		int i = 1;
		for()
	}
	}
	

}

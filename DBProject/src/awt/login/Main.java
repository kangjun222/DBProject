package awt.login;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main extends WindowAdapter implements ActionListener {
	private Frame f, fMain, fMain2, bMain1, bMain2, bMain3, bMain4, bMain5, bMain6, bMain7, bMain8, bMain9;
	private TextField tfId, tfPwd, tfMsg, tfMsg1, tfid2, tfpwd2, tfpwd4, tfname, tfname1, tfname2, name, name2, tfname3,
			phonenumber, password4, tfMsg2, tfMsg3;
	private Button bLogin, bjoin, enter, bt1, bt2, bt3, enter1, enter2, enter3, enter4, enter5, enter6, enter7, enter8,
			enter9;
	private MemberDAO dao;
	private Connection con;
	private Statement stmt, pstmt2;
	private ResultSet rs;
	private Connection con1;
	private ResultSet as;
	private String driver, input, input1, input2, input3;

	public Main() {
		dao = new MemberDAO();
//        String name = dao.list("강승진");

		f = new Frame("Bank Login");
		f.setSize(500, 300);
		f.setLocation(100, 100);

		f.setLayout(null);
		f.addWindowListener(this);

		Label lid = new Label("ID : ");
		lid.setBounds(50, 50, 100, 40);

		tfId = new TextField();
		tfId.setBounds(160, 60, 190, 40);

		Label lpwd = new Label("Password : ");
		lpwd.setBounds(50, 130, 100, 40);

		tfPwd = new TextField();
		tfPwd.setBounds(160, 130, 190, 40);
		tfPwd.setEchoChar('*');

		bLogin = new Button("Login");
		bLogin.setBounds(380, 110, 80, 50);
		bLogin.addActionListener(this);

		bjoin = new Button("Join");
		bjoin.setBounds(380, 50, 80, 50);
		bjoin.addActionListener(this);

		tfMsg = new TextField();
		tfMsg.setBounds(50, 200, 370, 40);
		tfMsg.setEditable(false);
		tfMsg.setFocusable(false);

		f.add(lid);
		f.add(tfId);
		f.add(lpwd);
		f.add(tfPwd);
		f.add(bLogin);
		f.add(tfMsg);
		f.add(bjoin);

		f.setVisible(true);
	}

	public static void main(String[] args) {

		new Main();
	}

	public void windowClosing(WindowEvent e) {// 창닫기 추가해주기
		if (e.getComponent() == fMain) {
			fMain.dispose();
		} else if (e.getComponent() == f) {
			f.dispose();
		} else if (e.getComponent() == fMain2) {
			fMain2.dispose();
		} else if (e.getComponent() == bMain1) {
			bMain1.dispose();
		} else if (e.getComponent() == bMain2) {
			bMain2.dispose();
		} else if (e.getComponent() == bMain3) {
			bMain3.dispose();
		} else if (e.getComponent() == bMain4) {
			bMain4.dispose();
		} else if (e.getSource() == bMain5) {
			bMain5.dispose();
		} else if (e.getSource() == bMain7) {
			bMain7.dispose();
		} else if (e.getSource() == bMain8) {
			bMain8.dispose();
		}

	}

	@Override // 로그인
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bLogin) {

			System.out.println("Click!");
			System.out.println(tfId.getText() + " : " + tfPwd.getText());

			String strId = tfId.getText();

			ArrayList<MemberVo> list = dao.list(strId);

			System.out.println("list.size() : " + list.size());
			if (list.size() == 1) {
				MemberVo data = (MemberVo) list.get(0);
				String id = data.getId();
				String pwd = data.getPassword();

				System.out.println("DB ==> " + id + " : " + pwd);

				if (tfPwd.getText().equals(pwd)) {

					tfMsg.setText("로그인이 되었습니다!");

					fMain = new Frame("은행선택");
					fMain.setBounds(380, 400, 680, 500);
					fMain.addWindowListener(this);
					fMain.setLayout(null);// border 레이아웃
					fMain.setVisible(true);
					bt1 = new Button("junhyungBank");
					bt2 = new Button("woonkiBank");
					bt3 = new Button("sinwooBank");

					Label Bc = new Label("Bank Choice");

					Bc.setBounds(300, 50, 100, 100);
					fMain.add(Bc);

					bt1.addActionListener(this);// 클릭했을때 액션을취하는거
					bt2.addActionListener(this);
					bt3.addActionListener(this);

					bt1.setBounds(30, 170, 202, 250);
					bt2.setBounds(230, 170, 202, 250);
					bt3.setBounds(430, 170, 202, 250);

					fMain.add(bt1);
					fMain.add(bt2);
					fMain.add(bt3);

				} else {
					System.out.println("다시 입력하세요.");
					tfMsg.setText("다시 입력하세요.");
				}
			} else {
				tfMsg.setText("ID가 틀렸습니다. 다시 입력하세요.");
			}
		} else if (e.getSource() == bjoin) {
			fMain2 = new Frame("회원가입");
			fMain2.setBounds(300, 400, 500, 350);
			fMain2.addWindowListener(this);
			fMain2.setVisible(true);

			Label lid2 = new Label("ID : ");
			lid2.setBounds(100, 120, 60, 20);

			tfid2 = new TextField();
			tfid2.setBounds(170, 110, 190, 40);
			tfid2.setVisible(true);

			fMain2.add(lid2);
			fMain2.add(tfid2);

			Label pwd2 = new Label("Pwd: ");
			pwd2.setBounds(90, 200, 60, 50);
			fMain2.add(pwd2);
			fMain2.setLayout(null);

			tfpwd2 = new TextField();
			tfpwd2.setBounds(170, 200, 190, 40);
			fMain2.add(tfpwd2);

			enter = new Button("Enter");
			enter.setBounds(400, 130, 40, 40);
			enter.addActionListener(this);

			fMain2.add(enter);

			enter.addActionListener(new ActionListener() {/////////// 회원가입

				public void actionPerformed(ActionEvent e) {// 회원가입 엔터눌렀을
					String id = tfid2.getText();
					String pw = tfpwd2.getText();

					String query = "insert into Member(ID,PASSWORD)values(?,?)";

					try {
						dao.connDB();
						Connection conn = dao.getCon();
						PreparedStatement pstmt = conn.prepareStatement(query);

						pstmt.setString(1, id);
						pstmt.setString(2, pw);

						int rs = pstmt.executeUpdate();
						System.out.println("변경된 row " + rs);
					} catch (SQLException e1) {
						System.out.println(e1);
					}

				}
			});

		} else if (e.getSource() == bt1) {
			bMain1 = new Frame("준형은행");
			bMain1.setBounds(300, 400, 500, 350);
			bMain1.addWindowListener(this);
			bMain1.setVisible(true);
			bMain1.setLayout(null);

			enter1 = new Button("Account opening");// 계좌 개설
			enter1.setBounds(30, 150, 200, 80);
			enter1.addActionListener(this);
			bMain1.add(enter1);

			enter2 = new Button("account verification");// 계좌 확인
			enter2.setBounds(280, 150, 200, 80);
			enter2.addActionListener(this);
			bMain1.add(enter2);
		} else if (e.getSource() == enter2) {
			bMain7 = new Frame("계좌 확인");///////////////////////////////////// ACCOUNT
										///////////////////////////////////// 확인///////////////////////////////////////////////////////////////////////
			bMain7.setBounds(300, 400, 500, 300); // 300,400,400,200
			bMain7.addWindowListener(this);
			bMain7.setVisible(true);
			bMain7.setLayout(null);

			tfpwd4 = new TextField();
			tfpwd4.setBounds(150, 80, 190, 40);
			bMain7.add(tfpwd4);
			Label lid4 = new Label("Account Number : ");
			lid4.setBounds(50, 50, 100, 100);
			bMain7.add(lid4);

			enter6 = new Button("Enter");
			enter6.setBounds(400, 50, 80, 80); // 200,130,40,40
			enter6.addActionListener(this);
			bMain7.add(enter6);

			enter6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					input = tfpwd4.getText();

					tfMsg2 = new TextField();
					tfMsg2.setBounds(100, 200, 270, 40);
					tfMsg2.setEditable(false);
					tfMsg2.setFocusable(false);
					bMain7.add(tfMsg2);

					try {
						MemberDAO md = new MemberDAO();/////////////////////////////////////////// asdasdsad
						md.connDB();
						String query = " SELECT ACCOUNTNUMBER FROM ACCOUNT WHERE ACCOUNTNUMBER = '" + input + "'";
						Connection conn = md.getCon();
						PreparedStatement pstmt2 = conn.prepareStatement(query);
						rs = pstmt2.executeQuery();
						rs.next();////////////////////////////////////////////////////////////////////////////// 선생님

						if (rs.getRow() == 0) {
							System.out.println("값이 없음");
							tfMsg2.setText("계좌를 생성해주세요!!!!!");

						} else {
							System.out.print("값을 찾음");
							bMain6 = new Frame("입금 출금 창");
							bMain6.setBounds(300, 400, 500, 350);
							bMain6.setVisible(true);
							bMain6.setLayout(null);
							tfMsg2.setText("입금 출금 창으로 넘어갑니다");
							Label lid3 = new Label("Deposit : ");
							lid3.setBounds(100, 80, 60, 20);
							bMain6.add(lid3);

							Label lid5 = new Label("Withdraw : ");
							lid5.setBounds(90, 130, 60, 20);
							bMain6.add(lid5);

							tfMsg3 = new TextField();
							tfMsg3.setBounds(100, 250, 310, 40); /// 출금창 (밑에) 대한 텍스트 필드
							tfMsg3.setEditable(false);
							tfMsg3.setFocusable(false);
							bMain6.add(tfMsg3);

							name = new TextField();
							name.setBounds(170, 70, 190, 40); // 입금창에대한 텍스트 필드
							name.setVisible(true);
							bMain6.add(name);

							tfname3 = new TextField();
							tfname3.setBounds(170, 125, 190, 40); // 출금창 돈 넣는거 에대한 텍스트 필드
							tfname3.setVisible(true);
							bMain6.add(tfname3);

							enter7 = new Button("deposit");/////////////////// 입금
							enter7.setBounds(400, 65, 80, 40); // 옆 위 크기
							bMain6.add(enter7);

							enter8 = new Button("withdraw");///////////////// 출금
							enter8.setBounds(400, 120, 80, 40);
							bMain6.add(enter8);

							enter9 = new Button("Balance check");
							enter9.setBounds(160, 170, 200, 50);
							bMain6.add(enter9);

						}

					} catch (SQLException e2) {
						System.out.println(e2);
					}
					enter7.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {/////////////////////////////// 찾았다
							input1 = name.getText();
							try {
								MemberDAO a = new MemberDAO();
								a.connDB();
								Connection conn = a.getCon();

								String query = "SELECT NVL(DEPOSIT,0) AS DEPOSIT FROM ACCOUNT WHERE ACCOUNTNUMBER='"
										+ input + "'";
								System.out.println(query);
//					         	System.out.println(input);

//					         	System.out.println("돈을넘");

								PreparedStatement pstmt2 = conn.prepareStatement(query);
								ResultSet rs = pstmt2.executeQuery();
								rs.next();
								String acc = rs.getString("DEPOSIT");
								int dp = Integer.parseInt(acc);
								int inp = Integer.parseInt(input1);
								int result = dp + inp;
								System.out.println("잔액 : " + dp);
								System.out.println("입금 금액 : " + inp);
								String dpCoin = String.valueOf(result);

								tfMsg3.setText(inp + "원 입급 되었습니다! ****" + "현재잔액:" + result + "원****");

								// ACCOUNT NUMBER123 에 돈이 있어야댐 ,
								// ACCOUNT NUMBER123에 플러스 해서 값이 나와야댐

								// console 창에 출력할 것
								// deposit에 입력한 값
								// 계좌번호 : 1234

								// query < 잔액 deposit
								// deposit + input1 = ??
								// ?? -> 변수하나 더 선언해서 밑에 query1 에 추가하기
								String query1 = "update ACCOUNT set DEPOSIT='" + dpCoin + "' where ACCOUNTNUMBER='"
										+ input + "'";

								System.out.println(query1);

								System.out.println("돈 넘");
								PreparedStatement pstmt3 = conn.prepareStatement(query1);
								int r1 = pstmt3.executeUpdate();
								System.out.println("변경된 row : " + r1);

								System.out.println("잔여 금액 : " + result);

							} catch (SQLException e2) {
								System.out.print(e2);
							}

//							"update ACCOUNT set DEPOSIT = '" + input1 + "' where ACCOUNTNUMBER = '" + tfpwd4.getText() + "'" ;

						}

					});
					enter8.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {/////////////////////////////// 찾았다
							input2 = tfname3.getText();
							try {
								MemberDAO b = new MemberDAO();
								b.connDB();
								Connection conn = b.getCon();

								String query = "SELECT NVL(DEPOSIT,0) AS DEPOSIT FROM ACCOUNT WHERE ACCOUNTNUMBER='"
										+ input + "'";
								System.out.println(query);
//					         	System.out.println(input);

//					         	System.out.println("돈을넘");

								PreparedStatement pstmt2 = conn.prepareStatement(query);
								ResultSet rs = pstmt2.executeQuery();
								rs.next();
								String bcc = rs.getString("DEPOSIT");
								int dp = Integer.parseInt(bcc);
								int inp = Integer.parseInt(input2);
								int result = dp - inp;
								System.out.println("잔액 : " + dp);
								System.out.println("출금금액 : " + inp);
								String dpCoi = String.valueOf(result);

								tfMsg3.setText(inp + "원 출금 되었습니다! ****" + "현재잔액:" + result + "원****");

								String query1 = "update ACCOUNT set DEPOSIT='" + dpCoi + "' where ACCOUNTNUMBER='"
										+ input + "'";
								System.out.println(query1);

								System.out.println("돈 뺌");
								PreparedStatement pstmt3 = conn.prepareStatement(query1);
								int r1 = pstmt3.executeUpdate();
								System.out.println("변경된 row : " + r1);

								System.out.println("잔여 금액 : " + result);

							} catch (SQLException e2) {
								System.out.print(e2);

							}

						}
					});

					enter9.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							MemberDAO c = new MemberDAO();
							c.connDB();
							Connection conn = c.getCon();

							try {
								String query = "SELECT NVL(DEPOSIT,0) AS DEPOSIT FROM ACCOUNT WHERE ACCOUNTNUMBER='"
										+ input + "'";
								System.out.println(query);
								PreparedStatement pstmt2 = conn.prepareStatement(query);
								ResultSet rs = pstmt2.executeQuery();
								rs.next();
								String bcc = rs.getString("DEPOSIT");
								int dp = Integer.parseInt(bcc);
								tfMsg3.setText(input + "계좌 잔액은 : " + bcc);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}

						}
					});

				}
			});
		}

		if (e.getSource() == enter1) {/////////////////// 계좌 개설 1단계 이름,전화번호,4자리 패스워드
			bMain5 = new Frame("계좌 개설");
			bMain5.setBounds(300, 400, 500, 500);
			bMain5.addWindowListener(this);
			bMain5.setVisible(true);
			bMain5.setLayout(null);

			Label name = new Label("NAME");
			name.setBounds(60, 100, 100, 50);

			bMain5.add(name);

			Label name1 = new Label("PHONE-NUMBER");
			name1.setBounds(60, 140, 100, 50);
			bMain5.add(name1);

			Label name2 = new Label("ACCOUNT-NUMBER");
			name2.setBounds(60, 180, 100, 50);
			bMain5.add(name2);

			tfname = new TextField();
			tfname.setBounds(160, 100, 190, 40);

			bMain5.add(tfname);

			tfname1 = new TextField();
			tfname1.setBounds(160, 140, 190, 40);
			bMain5.add(tfname1);

			tfname2 = new TextField();
			tfname2.setBounds(160, 180, 190, 40);
			bMain5.add(tfname2);

			enter5 = new Button("Enter");
			enter5.setBounds(400, 130, 40, 40);
			enter5.addActionListener(this);

			bMain5.add(enter5);

			tfMsg1 = new TextField();
			tfMsg1.setBounds(50, 300, 370, 80);
			tfMsg1.setEditable(false);
			tfMsg1.setFocusable(false);
			bMain5.add(tfMsg1);

			enter5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {///////// 계좌 개설 디비

					String n = tfname.getText();
					String p = tfname1.getText();
					String w = tfname2.getText();

					String query = "insert into ACCOUNT(NAME,PHONENUMBER,ACCOUNTNUMBER)values(?,?,?)";

					try {

						new MemberDAO();
						dao.connDB();
						Connection conn = dao.getCon();
						PreparedStatement pstmt2 = conn.prepareStatement(query);

						pstmt2.setString(1, n);
						pstmt2.setString(2, p);
						pstmt2.setString(3, w);
						int as = pstmt2.executeUpdate();
						System.out.println("계좌 개설 성공 " + as);
					} catch (SQLException e2) {
						System.out.println(e2);

					}
					if (e.getSource() == enter5) {

						tfMsg1.setText("계좌번호:" + w);

					}
				}

			});

		}

		else if (e.getSource() == bt2) {
			bMain2 = new Frame("웅기은행");
			bMain2.setBounds(300, 400, 500, 350);
			bMain2.addWindowListener(this);
			bMain2.setVisible(true);
			bMain2.addWindowListener(this);

		} else if (e.getSource() == bt3) {
			bMain3 = new Frame("우철은행");
			bMain3.setBounds(300, 400, 500, 350);
			bMain3.addWindowListener(this);
			bMain3.setVisible(true);
			bMain3.addWindowListener(this);

		}

	}
}


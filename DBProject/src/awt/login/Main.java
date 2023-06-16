package awt.login;

import java.awt.Button;
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
	private Frame f, fMain, fMain2, bMain1, bMain2, bMain3;
	private TextField tfId, tfPwd, tfMsg, tfid2, tfpwd2, tfpwd3;
	private Button bLogin, bjoin, enter, bt1, bt2, bt3;
	private MemberDAO dao;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##himedia";
	String password = "himedia";

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

	public void windowClosing(WindowEvent e) {
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
		}
	}

	@Override
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

			Label pwd2 = new Label("pwd: ");
			pwd2.setBounds(90, 200, 60, 50);
			fMain2.add(pwd2);
			fMain2.setLayout(null);

			tfpwd2 = new TextField();
			tfpwd2.setBounds(170, 200, 190, 40);
			fMain2.add(tfpwd2);

			enter = new Button("enter");
			enter.setBounds(400, 130, 40, 40);
			enter.addActionListener(this);

			fMain2.add(enter);

			enter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {//회원가입 엔터눌렀을
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
			bMain1.addWindowListener(this);

		} else if (e.getSource() == bt2) {
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
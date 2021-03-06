package com.HuangYuhui.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.HuangYuhui.DaoImpl.ManageUserInfoImpl;
import com.HuangYuhui.Model.User;
import com.HuangYuhui.View.function.Register_JFrame_function;

/**
 * 
 * @Project Instant messaging software - QQ
 * @Package com.YUbuntu.view
 * @Description User register interface.
 * @Author #YUbuntu
 * @Date Dec 30, 2018-2:08:10 PM
 * @version 1.0
 */
public class Register_JFrame extends JFrame implements Register_JFrame_function
{

	private JPanel contentPane;
	private JTextField UserName_TextField;
	private JPasswordField UserPassword_PasswordField;
	private JPasswordField ConfirmPassword_PasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Register_JFrame frame = new Register_JFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register_JFrame()
	{
		setResizable(false);
		setAlwaysOnTop(true);//Set the User register interface always on the top.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTelephoneemail = new JLabel("User name");
		lblTelephoneemail.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		UserName_TextField = new JTextField();
		UserName_TextField.setFont(new Font("SimSun", Font.BOLD, 12));
		UserName_TextField.setColumns(10);
		
		UserPassword_PasswordField = new JPasswordField();
		
		ConfirmPassword_PasswordField = new JPasswordField();
		
		JButton ConfirmRegister_JButton = new JButton("Confirm");
		ConfirmRegister_JButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Function_AddUserInfo(e);
			}
		});
		ConfirmRegister_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		JButton GoLoginInterface_JButton = new JButton("Back");
		GoLoginInterface_JButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Interface_GoBackUserLoginInterface(e);
			}
		});
		GoLoginInterface_JButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblConfirmPassword)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(51)
									.addComponent(ConfirmRegister_JButton)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(81)
									.addComponent(GoLoginInterface_JButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(ConfirmPassword_PasswordField)
										.addComponent(UserPassword_PasswordField)
										.addComponent(UserName_TextField, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblPassword)
						.addComponent(lblTelephoneemail))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelephoneemail)
						.addComponent(UserName_TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(UserPassword_PasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmPassword)
						.addComponent(ConfirmPassword_PasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(GoLoginInterface_JButton)
						.addComponent(ConfirmRegister_JButton))
					.addGap(59))
		);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * 
	 * @Title Function
	 * @Description Write new user information into the specified file.
	 * @param Performed action
	 * @return void
	 * @date Jan 2, 2019-1:34:05 PM
	 * @throws no
	 *
	 */
	protected void Function_AddUserInfo(ActionEvent e)
	{
		String userName = UserName_TextField.getText();
		String userPassword = UserPassword_PasswordField.getText();
		String confirmPassword = ConfirmPassword_PasswordField.getText();
		//Tip
		if(!(userPassword.equals(confirmPassword)))
		{
			JOptionPane.showMessageDialog(this, "Password inconsistent !", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		//Store
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		//Write 
		try
		{
			ManageUserInfoImpl loginIn_IOImpl = new ManageUserInfoImpl();
			loginIn_IOImpl.UserRegist(user);
			JOptionPane.showMessageDialog(this, "Success to register !", "Tip", JOptionPane.INFORMATION_MESSAGE);
		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}	
	}

	/**
	 * 
	 * @Title Function
	 * @Description Go back the User login interface.
	 * @param Performed action
	 * @return void
	 * @date Dec 30, 2018-2:31:02 PM
	 * @throws no
	 *
	 */
	public void Interface_GoBackUserLoginInterface(ActionEvent e)
	{
		Login_JFrame login_JFrame = new Login_JFrame();
		
		//Open the User login interface.
		login_JFrame.setVisible(true);
		//Close the User register interface.
		Register_JFrame.this.setVisible(false);
	}
}

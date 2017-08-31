package com.zhiyou100.web.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @ClassName: Mail
 * @Description: TODO
 * @author lyb
 * @date 2017��8��28�� ����2:06:39
 * 
 */
public class MailUtil {
	// �޸�Ϊ�Լ���qq�����˺�
	private static String myEmailAccount = "15903697671@163.com";
	// �޸�Ϊ�Լ���������Ȩ��
	private static String myEmailPassword = "wgs15903697671";
	// �����qq���䲻���޸ģ������163���䣬�޸�Ϊsmtp.163.com
	private static String myEmailSMTPHost = "smtp.163.com";

	private static String sendUser = "���ν���";

	/**
	 * @Title: send @Description: TODO @param @param �ռ������� @param @param
	 * ���� @param @param ���� @param @throws Exception void @throws
	 */
	public static void send(String receive, String title, String body) throws Exception {
		// 1. ������������, ���������ʼ��������Ĳ�������
		Properties props = new Properties();
		// ʹ�õ�Э�飨JavaMail�淶Ҫ��
		props.setProperty("mail.transport.protocol", "smtp");
		// �����˵������ SMTP ��������ַ
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		// ��Ҫ������֤
		props.setProperty("mail.smtp.auth", "true");
		/*
		 * ��ҪSSL��ȫ���õ���Ҫ�������� SMTP �������Ķ˿� (�� SSL ���ӵĶ˿�һ��Ĭ��Ϊ 25, ���Բ����, ��������� SSL
		 * ����, ��Ҫ��Ϊ��Ӧ����� SMTP �������Ķ˿�, ����ɲ鿴��Ӧ�������İ���, QQ�����SMTP(SLL)�˿�Ϊ465��587,
		 * ������������ȥ�鿴)
		 */
		final String smtpPort = "465";
		props.setProperty("mail.smtp.port", smtpPort);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		// 2. �������ô����Ự����, ���ں��ʼ�����������
		Session session = Session.getDefaultInstance(props);
		// ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
		session.setDebug(true);
		// 3. ����һ���ʼ�
		MimeMessage message = createMimeMessage(session, myEmailAccount, receive, title, body);
		// 4. ���� Session ��ȡ�ʼ��������
		Transport transport = session.getTransport();
		// 5.ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
		transport.connect(myEmailAccount, myEmailPassword);
		// 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���,
		// ������, ������
		transport.sendMessage(message, message.getAllRecipients());
		// 7. �ر�����
		transport.close();
	}

	/**
	 * @Title: createMimeMessage @Description: TODO @param @param session
	 * ���ʼ������������ĻỰ���� @param @param sendMail �����˵������ʺ� @param @param receiveMail
	 * �ռ��˵������ʺ� @param @param title �ʼ����� @param @param body �ʼ����� @param @return
	 * �������ʼ����� @param @throws Exception MimeMessage @throws
	 */
	private static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String title,
			String body) throws Exception {
		// 1. ����һ���ʼ�
		MimeMessage message = new MimeMessage(session);

		// 2. From: ������(�����������ַ,����������,�����ʽ)
		message.setFrom(new InternetAddress(sendMail, sendUser, "UTF-8"));

		// 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "�𾴵��û�", "UTF-8"));

		// 4. Subject: �ʼ�����
		message.setSubject(title, "UTF-8");

		// 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
		message.setContent(body, "text/html;charset=UTF-8");

		// 6. ���÷���ʱ��
		message.setSentDate(new Date());

		// 7. ��������
		message.saveChanges();

		return message;
	}

}

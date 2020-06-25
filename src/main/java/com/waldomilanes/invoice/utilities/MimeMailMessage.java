package com.waldomilanes.invoice.utilities;

import java.io.File;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;

import org.springframework.mail.MailMessage;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MimeMailMessage implements MailMessage {

    private JavaMailSender mailSender;
    private SimpleMailMessage simpleMailMessage;
    private final MimeMessageHelper helper;

    /**
     * Create a new MimeMailMessage based on the given MimeMessageHelper.
     *
     * @param mimeMessageHelper the MimeMessageHelper
     */
    public MimeMailMessage(MimeMessageHelper mimeMessageHelper) {
        this.helper = mimeMessageHelper;
    }

    /**
     * Create a new MimeMailMessage based on the given JavaMail MimeMessage.
     *
     * @param mimeMessage the JavaMail MimeMessage
     */
    public MimeMailMessage(MimeMessage mimeMessage) {
        this.helper = new MimeMessageHelper(mimeMessage);
    }

    public MimeMailMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Return the MimeMessageHelper that this MimeMailMessage is based on.
     */
    public final MimeMessageHelper getMimeMessageHelper() {
        return this.helper;

    }

    /**
     * Return the JavaMail MimeMessage that this MimeMailMessage is based on.
     */
    public final MimeMessage getMimeMessage() {
        return this.helper.getMimeMessage();
    }

    public void setFrom(String from) throws MailParseException {
        try {
            this.helper.setFrom(from);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void setReplyTo(String replyTo) throws MailParseException {
        try {
            this.helper.setReplyTo(replyTo);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void setTo(String to) throws MailParseException {
        try {
            this.helper.setTo(to);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void setTo(String[] to) throws MailParseException {
        try {
            this.helper.setTo(to);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void setCc(String cc) throws MailParseException {
        try {
            this.helper.setCc(cc);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void setCc(String[] cc) throws MailParseException {
        try {
            this.helper.setCc(cc);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void setBcc(String bcc) throws MailParseException {
        try {
            this.helper.setBcc(bcc);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void setBcc(String[] bcc) throws MailParseException {
        try {
            this.helper.setBcc(bcc);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void addAttatchment(String fileName, File file) throws MailParseException {
        try {
            this.helper.addAttachment(fileName, file);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void setSentDate(Date sentDate) throws MailParseException {
        try {
            this.helper.setSentDate(sentDate);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void setSubject(String subject) throws MailParseException {
        try {
            this.helper.setSubject(subject);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void setText(String text) throws MailParseException {
        try {
            this.helper.setText(text);
        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
    }

    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String dear, String content) {

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(simpleMailMessage.getFrom());
            helper.setTo(simpleMailMessage.getTo());
            helper.setSubject(simpleMailMessage.getSubject());
            helper.setText(String.format(
                    simpleMailMessage.getText(), dear, content));

            FileSystemResource file = new FileSystemResource("C:\\log.txt");
            helper.addAttachment(file.getFilename(), file);

        } catch (MessagingException e) {
            throw new MailParseException(e);
        }
        mailSender.send(message);
    }
}

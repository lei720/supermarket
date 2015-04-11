package edu.cuit.main;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.Color;

/**
 * �������
 * 
 * @author 
 */
public class BackgroundPanel extends JPanel {
    private Image image;// ����ͼƬ    
    public BackgroundPanel() {
    	setBackground(new Color(160, 82, 45));
        setOpaque(false);
        setLayout(null);// ʹ�þ��Զ�λ���ֿؼ�
    }    
    /**
     * ���ñ���ͼƬ����ķ���
     * 
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }    
    /**
     * ��������
     */
    protected void paintComponent(Graphics g) {
        if (image != null) {// ���ͼƬ�Ѿ���ʼ��
            // ����ͼƬ
            g.drawImage(image, 0, 0, this);
        }
        super.paintComponent(g);
    }
}

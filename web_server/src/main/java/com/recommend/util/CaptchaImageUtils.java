package com.recommend.util;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Random;

/**
 * @Description: 生成验证码的工具
 * @Author liuxing
 * @Date: 2025/1/14
 **/
@Slf4j
public class CaptchaImageUtils {
    private int weight = 100;           //验证码图片的长和宽
    private int height = 40;
    private String text;                //用来保存验证码的文本内容
    private Random random = new Random();    //获取随机数对象
    private String[] fontNames = {"Georgia"};  //字体数组
    private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ"; //验证码数组

    /**
     * 获取随机的颜色
     */
    private Color randomColor() {
        int r = this.random.nextInt(225);  //这里为什么是225，因为当r，g，b都为255时，即为白色，为了好辨认，需要颜色深一点。
        int g = this.random.nextInt(225);
        int b = this.random.nextInt(225);
        return new Color(r, g, b);            //返回一个随机颜色
    }

    /**
     * 获取随机字体
     */
    private Font randomFont() {
        int index = random.nextInt(fontNames.length);  //获取随机的字体
        String fontName = fontNames[index];
        int style = random.nextInt(4);         //随机获取字体的样式，0是无样式，1是加粗，2是斜体，3是加粗加斜体
        int size = random.nextInt(10) + 24;    //随机获取字体的大小
        return new Font(fontName, style, size);   //返回一个随机的字体
    }

    /**
     * 获取随机字符
     */
    private char randomChar() {
        int index = random.nextInt(codes.length());
        return codes.charAt(index);
    }

    /**
     * 画干扰线，验证码干扰线用来防止计算机解析图片
     */
    private void drawLine(BufferedImage image) {
        int num = random.nextInt(10); //定义干扰线的数量
        Graphics2D g = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = random.nextInt(weight);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(weight);
            int y2 = random.nextInt(height);
            g.setColor(randomColor());
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 创建图片
     */
    private BufferedImage createImage() {
        //创建图片缓冲区
        BufferedImage image = new BufferedImage(weight, height, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics2D g = (Graphics2D) image.getGraphics();
        //设置背景色随机
        g.setColor(new Color(255, 255, random.nextInt(245) + 10));
        g.fillRect(0, 0, weight, height);
        //返回一个图片
        return image;
    }

    /**
     * 获取验证码图片
     *
     * @return
     */
    public BufferedImage getImage() {
        BufferedImage image = createImage();
        Graphics2D g = (Graphics2D) image.getGraphics(); //获取画笔
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++)             //画四个字符即可
        {
            String s = randomChar() + "";      //随机生成字符，因为只有画字符串的方法，没有画字符的方法，所以需要将字符变成字符串再画
            sb.append(s);                      //添加到StringBuilder里面
            float x = i * 1.0F * weight / 4;   //定义字符的x坐标
            g.setFont(randomFont());           //设置字体，随机
            g.setColor(randomColor());         //设置颜色，随机
            g.drawString(s, x, height - 5 * 1.0F);
        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }

    /**
     * 获取验证码文本的方法
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * 将验证码图片输出到指定的流
     *
     * @param image 图像
     * @param out   输出流
     * @throws IOException ioexception
     */
    public static void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPG", out);
    }

    /**
     * 获取图片对应的base64值
     *
     * @param image 图像
     * @return {@link String}
     */
    public static String getBase(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String base64 = null;
        try {
            output(image, baos);
            byte[] bytes = baos.toByteArray();
            bytes = Base64.getEncoder().encode(bytes);
            base64 = new String(bytes);
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        } finally {
            close(baos);
        }
        return base64;
    }

    /**
     * 关闭流
     */
    private static void close(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }
}

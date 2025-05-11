package com.easy_pan.back.biz.service.account;

import com.easy_pan.back.infra.utils.StringUtils;
import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;

public class GetImgVerifyCodeService {
    private int width = 160; //图片宽度
    private int height = 40; //图片高度
    private int codeLength = 6; //验证码长度
    private int lineCount = 20; //验证码干扰线数
    @Getter
    private String verifyCode; //验证码
    @Getter
    private BufferedImage bufferedImg; //验证码图片buffer
    Random random = new Random(); //随机生成器

    public GetImgVerifyCodeService() {
        this.createImage();
    }
    public GetImgVerifyCodeService(int width, int height) {
        this.width = width;
        this.height = height;
        this.createImage();
    }
    public GetImgVerifyCodeService(int width, int height, int codeLength) {
        this.width = width;
        this.height = height;
        this.codeLength = codeLength;
        this.createImage();
    }
    public GetImgVerifyCodeService(int width, int height, int codeLength, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeLength = codeLength;
        this.lineCount = lineCount;
        this.createImage();
    }

    // 生成图片
    private void createImage() {
        int fontWidth = this.width / this.codeLength, fontHeight = this.height - 5; //设置每一个验证码数字的宽度和高度
        int posY = this.height - 8;
        // 绘制图像buffer
        this.bufferedImg = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = this.bufferedImg.getGraphics();
        // 背景颜色
        graphics.setColor(this.getRandColor(180, 250));
        graphics.fillRect(0, 0, this.width, this.height);
        // 噪点
        float noiseRate = 0.01f; // 噪声率
        int area = (int) (noiseRate * this.width * this.height);
        for (int i = 0; i < area; i++) {
            int x = this.random.nextInt(this.width), y = this.random.nextInt(this.height);
            this.bufferedImg.setRGB(x, y, this.random.nextInt(255));
        }
        // 字体
        graphics.setFont(new Font("Times New Roman", Font.BOLD, fontHeight));
        // 干扰线
        for (int i = 0; i < this.lineCount; i++) {
            int x0 = this.random.nextInt(this.width), y0 = this.random.nextInt(this.height);
            int x1 = x0 + this.random.nextInt(this.width), y1 = y0 + this.random.nextInt(this.height);
            graphics.setColor(this.getRandColor(1, 255));
            graphics.drawLine(x0, y0, x1, y1);
        }
        // 获取随机字符串并完成绘制
        this.verifyCode = StringUtils.randomStr(this.codeLength);
        for (int i = 0; i < this.codeLength; i++) {
            String code = "" + this.verifyCode.charAt(i);
            graphics.setColor(this.getRandColor(1, 255));
            graphics.drawString(code, i * fontWidth + 3, posY);
        }
    }

    // 生成随机颜色
    private Color getRandColor(int fc, int bc) {
        fc = Math.min(fc, 255);
        bc = Math.min(bc, 255);
        return new Color(fc + this.random.nextInt(bc-fc), fc + this.random.nextInt(bc-fc),fc + this.random.nextInt(bc-fc));
    }

    // 输出图片验证码
    public ByteBuffer writeImg() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(this.bufferedImg, "png", outputStream);
        outputStream.close();
        return ByteBuffer.wrap(outputStream.toByteArray());
    }
}

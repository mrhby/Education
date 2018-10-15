package com.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CodeUtil {

    private static int width = 90;
    private static int height = 40;
    private static int codeCount = 4;
    private static int xx = 16;
    private static int codeY = 26;
    private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u'
            ,'v','w','x','y','z','0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public static Map<String,Object> generateCodeAndPic() {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        Random random = new Random();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        Font font = new Font("宋体", Font.BOLD, 23);
        graphics.setFont(font);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0, 0, width - 1, height - 1);
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
        StringBuffer randomCode = new StringBuffer();
        int red, green, blue;
        for (int i = 0; i < codeCount; i++) {
            String code = String.valueOf(codeSequence[random.nextInt(62)]);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            graphics.setColor(new Color(red, green, blue));
            graphics.drawString(code, (i + 1) * xx, codeY);
            randomCode.append(code);
        }
        Map<String, Object> map = new HashMap();
        map.put("code", randomCode);
        map.put("codePic", bufferedImage);
        return map;
    }
}

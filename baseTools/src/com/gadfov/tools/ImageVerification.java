package com.gadfov.tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;


/**
 * @author : gadfov
 * @description : 图片校验及处理类
 */
public class ImageVerification {

    private static final Logger log = Logger.getLogger("ImageVerification");

    public static boolean checkImage(File srcFile) {
        //1.先判断文件是否存在
        if (!srcFile.exists()) {
            log.info("图片文件校验异常==============>图片文件不存在!");
            return false;
        }
        //2.文件存在情况
        Image image = null;
        try {
            image = ImageIO.read(srcFile);
            //3.检查文件是否有高度与宽度，即通过图片的特性检验图片
            return image != null && image.getWidth(null) > 0 && image.getHeight(null) > 0;
        } catch (IOException e) {
            log.info("图片文件校验==============>文件读取失败!");
            return false;
        }
    }
}

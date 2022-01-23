package com.szx.server.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 验证码配置
 */
@Configuration
public class CaptchaConfig {
    @Bean
    public DefaultKaptcha defaultKaptcha() {
        // 验证码生成器
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        // 配置
        Properties properties = new Properties();
        // 边框设置
        properties.setProperty("kaptcha.border", "yes");
        // 边框颜色
        properties.setProperty("kaptcha.border.color", "red");
        // 边框粗细
        properties.setProperty("kaptcha.border.thickness", "1");
        // 验证码
        properties.setProperty("kaptcha.session.key", "code");
        // 验证码文本设置
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        properties.setProperty("kaptcha.textproducer.font.size", "30");
        // 验证码文本范围
        properties.setProperty("kaptcha.textproducer.char.string","abcdefghijklmnopqrstuvwxyz1234567890!");
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "5");
        // 字符jianju
        properties.setProperty("kaptcha.textproducer.char.space", "3");
        // 验证码宽度高度
        properties.setProperty("kaptcha.image.width", "120");
        properties.setProperty("kaptcha.image.height", "40");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}

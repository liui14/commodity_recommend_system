package com.recommend.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.codec.Base64;
import java.security.SecureRandom;

public class HashUtil {

    private static final int SALT_LENGTH = 16; // 盐值长度

    /**
     * 生成随机盐值
     *
     * @return 盐值字符串（Base64编码）
     */
    public static String generateSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        new SecureRandom().nextBytes(salt);
        return Base64.encode(salt);
    }

    /**
     * 对密码进行哈希处理
     *
     * @param password 原始密码
     * @param salt     盐值（Base64编码）
     * @return 哈希后的字符串，格式为 `salt:hash`
     */
    public static String hashPassword(String password, String salt) {
        if (StrUtil.isEmpty(password) || StrUtil.isEmpty(salt)) {
            throw new IllegalArgumentException("密码和盐值不能为空");
        }
        String hash = SecureUtil.sha256(salt + password); // 使用 SHA-256
        return salt + ":" + hash;
    }

    /**
     * 验证密码是否匹配
     *
     * @param password 原始密码
     * @param stored   存储的哈希值（格式为 `salt:hash`）
     * @return 是否匹配
     */
    public static boolean verifyPassword(String password, String stored) {
        if (StrUtil.isEmpty(password) || StrUtil.isEmpty(stored)) {
            throw new IllegalArgumentException("密码和存储值不能为空");
        }
        String[] parts = stored.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("存储的哈希格式不正确");
        }
        String salt = parts[0];
        String expectedHash = parts[1];

        String actualHash = SecureUtil.sha256(salt + password);
        return StrUtil.equals(expectedHash, actualHash);
    }

    public static void main(String[] args) {
        // 测试示例
        String password = "mySecurePassword";
        String salt = HashUtil.generateSalt();
        System.out.println("生成的盐值: " + salt);

        String hashedPassword = HashUtil.hashPassword(password, salt);
        System.out.println("哈希后的密码: " + hashedPassword);

        boolean isMatch = HashUtil.verifyPassword(password, hashedPassword);
        System.out.println("密码匹配: " + isMatch);
    }
}


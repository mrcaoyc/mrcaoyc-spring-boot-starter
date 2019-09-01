package com.github.mrcaoyc.keygen.autoconfigure;


import com.github.mrcaoyc.keygen.IpSectionStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author CaoYongCheng
 */
@ConfigurationProperties(prefix = "mrcaoyc.keygen")
public class GeneratorProperties {
    /**
     * 工作Id实现侧率
     */
    private String workerIdStrategy = IpSectionStrategy.class.getName();

    /**
     * 系统初始年
     */
    private short year = 2019;

    /**
     * 系统初始月，从1开始
     */
    private byte month = 1;

    /**
     * 系统初始日
     */
    private byte day = 1;

    /**
     * 是否启用Id生成器
     */
    private boolean enabled = true;

    /**
     * 指定workId,如果指定了具体的workerId，则workerIdStrategy将不生效
     */
    private Long workerId;

    /**
     * 机器位，由于已有1符号位+41时间戳，所有还剩下64-1-41=22位
     * 22=机器位+序列化，所有机器位应当小于22
     */
    private byte workerIdBits = 10;

    /**
     * 获取机器号测量生成器类型全限定名
     *
     * @return 生成器类型全限定名
     */
    public String getWorkerIdStrategy() {
        return workerIdStrategy;
    }

    /**
     * 设置机器号测量生成器类型全限定名
     *
     * @param workerIdStrategy 生成器类型全限定名
     */
    public void setWorkerIdStrategy(String workerIdStrategy) {
        this.workerIdStrategy = workerIdStrategy;
    }

    /**
     * 获取开始年份 默认值：2019
     *
     * @return 年份
     */
    public short getYear() {
        return year;
    }

    /**
     * 设置开始年份
     *
     * @return 年份
     */
    public void setYear(short year) {
        this.year = year;
    }

    /**
     * 获取开始月份 ，范围（1-12）。默认值：1
     *
     * @return 月份
     */
    public byte getMonth() {
        return month;
    }

    /**
     * 设置月份
     *
     * @param month 月份
     */
    public void setMonth(byte month) {
        this.month = month;
    }

    /**
     * 获取开始日：用于计算相对时间戳用，范围（1-31）。默认值：1
     *
     * @return 开始日
     */
    public byte getDay() {
        return day;
    }

    /**
     * 设置开始日：用于计算相对时间戳用，范围（1-31）。默认值：1
     *
     * @param day 开始日
     */
    public void setDay(byte day) {
        this.day = day;
    }

    /**
     * 获取生成器是否启用
     *
     * @return 是否启用生成器
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 设置是否启用键生成器
     *
     * @param enabled 是否启用
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取机器ID
     *
     * @return 机器ID
     */
    public Long getWorkerId() {
        return workerId;
    }

    /**
     * 设置机器ID
     *
     * @param workerId 机器ID
     */
    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    /**
     * 获取机器ID占用的二进制位，默认值10
     *
     * @return 机器ID二进制位
     */
    public byte getWorkerIdBits() {
        return workerIdBits;
    }

    /**
     * 设置机器ID占用的二进制位，默认值10
     *
     * @param workerIdBits 机器ID二进制位
     */
    public void setWorkerIdBits(byte workerIdBits) {
        this.workerIdBits = workerIdBits;
    }
}

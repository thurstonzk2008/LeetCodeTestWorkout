package com.zhk.snowflake;

/**
 * snowflake的java版本
 *https://segmentfault.com/a/1190000011282426
 * https://www.cnblogs.com/relucent/p/4955340.html
 *
 * 1位，不用。二进制中最高位为1的都是负数，但是我们生成的id一般都使用整数，所以这个最高位固定是0
 * 41位，用来记录时间戳（毫秒）。

 * 41位可以表示$2^{41}-1$个数字，
 * 如果只用来表示正整数（计算机中正数包含0），可以表示的数值范围是：0 至 $2^{41}-1$，减1是因为可表示的数值范围是从0开始算的，而不是1。
 * 也就是说41位可以表示$2^{41}-1$个毫秒的值，转化成单位年则是$(2^{41}-1) / (1000 * 60 * 60 * 24 * 365) = 69$年
 * 10位，用来记录工作机器id。

 * 可以部署在$2^{10} = 1024$个节点，包括5位datacenterId和5位workerId
 * 5位（bit）可以表示的最大正整数是$2^{5}-1 = 31$，即可以用0、1、2、3、....31这32个数字，来表示不同的datecenterId或workerId
 * 12位，序列号，用来记录同毫秒内产生的不同id。

 * 12位（bit）可以表示的最大正整数是$2^{12}-1 = 4095$，即可以用0、1、2、3、....4094这4095个数字，来表示同一机器同一时间截（毫秒)内产生的4095个ID序号
 */
public class IdWorker {
    private long workerId;
    private long datacenterId;
    private long sequence;

    public IdWorker(long workerId, long datacenterId, long sequence){
        // sanity check for workerId
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0",maxDatacenterId));
        }
        System.out.printf("worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
                timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId);

        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }
    //起始时间戳，用于用当前时间戳减去这个时间戳，算出偏移量
    private long twepoch = 1288834974657L;
    //workerId占用的位数：5
    private long workerIdBits = 5L;
    //datacenterId占用的位数：5
    private long datacenterIdBits = 5L;
    //位运算得出workIdBits位的最大整数 这里结果是31
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    //位运算得出datacenterits位的最大整数，这里结果是31
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    //序列在id中占的位数
    private long sequenceBits = 12L;
    //机器ID向左移12位
    private long workerIdShift = sequenceBits;
    //数据标识id向左移17位(12+5)
    private long datacenterIdShift = sequenceBits + workerIdBits;
    //时间截向左移22位(5+5+12)
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    //生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** 上次生成ID的时间截 */
    private long lastTimestamp = -1L;

    public long getWorkerId(){
        return workerId;
    }

    public long getDatacenterId(){
        return datacenterId;
    }

    public long getTimestamp(){
        return System.currentTimeMillis();
    }

    /**
     * 获得下一个ID (该方法是线程安全的)
     * @return SnowflakeId
     */
    public synchronized long nextId() {
        long timestamp = timeGen();

        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }
        //如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            //用mask防止溢出,保证序列号是0-4095
            sequence = (sequence + 1) & sequenceMask;
            //毫秒内序列溢出
            if (sequence == 0) {
                //阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
            //时间戳改变，毫秒内序列重置
        } else {
            sequence = 0;
        }
        //上次生成ID的时间截
        lastTimestamp = timestamp;

        //移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }
    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen(){
        return System.currentTimeMillis();
    }

    //---------------测试---------------
    public static void main(String[] args) {
        IdWorker worker = new IdWorker(1,1,1);
        for (int i = 0; i < 30; i++) {
            System.out.println(worker.nextId());
        }
    }
}

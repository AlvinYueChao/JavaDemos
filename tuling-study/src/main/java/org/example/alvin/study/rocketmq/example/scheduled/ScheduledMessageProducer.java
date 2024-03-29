package org.example.alvin.study.rocketmq.example.scheduled;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.example.alvin.study.rocketmq.example.LocalConstant;

public class ScheduledMessageProducer {

  public static void main(String[] args) throws Exception {
    // 实例化一个生产者来产生延时消息
    DefaultMQProducer producer = new DefaultMQProducer("ScheduledProducer");
    // 设置NameServer的地址
    producer.setNamesrvAddr(LocalConstant.NAME_SERVER_ADDR);
    // 启动Producer实例
    producer.start();
    int totalMessagesToSend = 100;
    for (int i = 0; i < totalMessagesToSend; i++) {
      Message message = new Message("ScheduledTopic", ("Hello scheduled message " + i).getBytes());
      // 设置延时等级3,这个消息将在10s之后投递给消费者(详看delayTimeLevel)
      // delayTimeLevel：(1~18个等级)"1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h"
      message.setDelayTimeLevel(3);
      // 发送消息
      producer.send(message);
    }
    // 关闭生产者
    producer.shutdown();
  }
}

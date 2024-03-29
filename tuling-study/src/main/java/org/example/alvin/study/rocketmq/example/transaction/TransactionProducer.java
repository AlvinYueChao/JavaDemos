/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example.alvin.study.rocketmq.example.transaction;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;

@Slf4j
public class TransactionProducer {

  public static void main(String[] args) throws MQClientException, InterruptedException {
    // 创建事务监听器
    TransactionListener transactionListener = new TransactionListenerImpl();
    // 创建消息生产者
    TransactionMQProducer producer = new TransactionMQProducer("TransactionProducer");
    // 设置NameServer的地址
    producer.setNamesrvAddr("localhost:9876");
    // 创建线程池
    ExecutorService executorService =
        new ThreadPoolExecutor(
            2,
            5,
            100,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2000),
            r -> {
              Thread thread = new Thread(r);
              thread.setName("client-transaction-msg-check-thread");
              return thread;
            });
    // 设置生产者回查线程池
    producer.setExecutorService(executorService);
    // 生产者设置监听器
    producer.setTransactionListener(transactionListener);
    // 启动消息生产者
    producer.start();
    String[] tags = new String[] {"TagA", "TagB", "TagC"};
    for (int i = 0; i < 3; i++) {
      try {
        Message msg =
            new Message(
                "TransactionTopic",
                tags[i % tags.length],
                "KEY" + i,
                ("Hello RocketMQ " + i).getBytes(StandardCharsets.UTF_8));
        SendResult sendResult = producer.sendMessageInTransaction(msg, null);
        log.info("{}", sendResult);
        Thread.sleep(1000);
      } catch (MQClientException e) {
        e.printStackTrace();
      }
    }

    for (int i = 0; i < 100000; i++) {
      Thread.sleep(1000);
    }
    producer.shutdown();
  }
}

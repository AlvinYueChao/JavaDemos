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
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.example.alvin.study.rocketmq.example.batch;

import java.util.ArrayList;
import java.util.List;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.example.alvin.study.rocketmq.example.LocalConstant;

public class BatchProducer {

  public static void main(String[] args) throws Exception {
    // 实例化消息生产者Producer
    DefaultMQProducer producer = new DefaultMQProducer("BatchProducer");
    // 设置NameServer的地址
    producer.setNamesrvAddr(LocalConstant.NAME_SERVER_ADDR);
    // 启动Producer实例
    producer.start();

    String topic = "BatchTest";
    List<Message> messages = new ArrayList<>();
    messages.add(new Message(topic, "Tag", "OrderID001", "Hello world 0".getBytes()));
    messages.add(new Message(topic, "Tag", "OrderID002", "Hello world 1".getBytes()));
    messages.add(new Message(topic, "Tag", "OrderID003", "Hello world 2".getBytes()));
    try {
      producer.send(messages);
    } catch (Exception e) {
      producer.shutdown();
      e.printStackTrace();
    }
    // 如果不再发送消息，关闭Producer实例。
    producer.shutdown();
  }
}

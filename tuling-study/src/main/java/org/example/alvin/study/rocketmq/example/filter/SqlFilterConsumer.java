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

package org.example.alvin.study.rocketmq.example.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.example.alvin.study.rocketmq.example.LocalConstant;

@Slf4j
public class SqlFilterConsumer {

  public static void main(String[] args) throws Exception {

    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("SqlFilterConsumer");
    consumer.setNamesrvAddr(LocalConstant.NAME_SERVER_ADDR);

    // Don't forget to set enablePropertyFilter=true in broker
    consumer.subscribe(
        "SqlFilterTest",
        MessageSelector.bySql(
            "(TAGS is not null and TAGS in ('TagA', 'TagB'))"
                + "and (a is not null and a between 0 and 3)"));

    consumer.registerMessageListener(
        (MessageListenerConcurrently)
            (msgs, context) -> {
              log.info("{} Receive New Messages: {}", Thread.currentThread().getName(), msgs);
              return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });

    consumer.start();
    log.info("Consumer Started.");
  }
}

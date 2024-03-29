/*
 * Copyright 2013-2018 Lilinfeng.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example.alvin.study.network.netty.serializable.protogenesis;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Mark老师 享学课堂 https://enjoy.ke.qq.com 往期课程和VIP课程咨询 依娜老师 QQ：2133576719 类说明：测试序列化后字节大小
 */
public class TestUserInfo {

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    UserInfo info = new UserInfo();
    info.buildUserID(100).buildUserName("Welcome to Netty");
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(bos);
    os.writeObject(info);
    os.flush();
    os.close();
    byte[] b = bos.toByteArray();
    System.out.println("The jdk serializable length is : " + b.length);
    bos.close();
    System.out.println("-------------------------------------");
    System.out.println("The byte array serializable length is : " + info.codeC().length);
  }
}

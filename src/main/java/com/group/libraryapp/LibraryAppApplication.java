package com.group.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 어노테이션 : 스프링푸트를 사용할 때 다양한 설정을 자동으로 해줌!!
public class LibraryAppApplication {

  public static void main(String[] args) {

    SpringApplication.run(LibraryAppApplication.class, args); // 실제 서버 클래스를 실행시키는 코드
  }

}

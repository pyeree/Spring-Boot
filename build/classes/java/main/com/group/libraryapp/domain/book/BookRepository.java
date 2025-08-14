package com.group.libraryapp.domain.book;

import com.group.libraryapp.domain.book.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    // JpaRepository는 기본적인 CRUD 메서드를 제공한다.
    // 추가적인 메서드가 필요하면 여기에 정의할 수 있다.
    // domain Book에 관한 jpa이고 Id 타입은 Long이다.

}

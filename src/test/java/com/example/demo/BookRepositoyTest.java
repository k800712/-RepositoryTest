package com.example.demo;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BookRepositoyTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    @DisplayName("책 저장 테스트")
    void createBookTest() {
        // [미완성된 코드]
        // given
        Book book = new Book("아이야", "한강",
                "1111111111111", 10000, 2024);

        // when
        // TODO: bookRepository를 사용하여 책을 저장하세요
        Book savedBook = bookRepository.save(book);

        // then
        // TODO: assertThat을 사용하여 결과를 검증하세요
        // 저장된 책의 ID가 null이 아닌지 확인하세요
        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("아이야");
        assertThat(savedBook.getAuthor()).isEqualTo("한강");
        assertThat(savedBook.getIsbn()).isEqualTo("1111111111111");
        assertThat(savedBook.getPrice()).isEqualTo(10000);
        assertThat(savedBook.getPublishedYear()).isEqualTo(2024);

    }

    @Test
    @DisplayName("ID로 책 조회 테스트")
    void findBookByIdTest() {
        // [미완성된 코드]
        // given
        Book book = new Book("아이야", "한강",
                "1111111111111", 10000, 2024);
        // TODO: 테스트용 책 데이터를 생성하고 저장하세요
        Book saveBook = bookRepository.save(book);

        // when
        // TODO: bookRepository의 findById를 사용하여 책을 조회하세요
        // 저장된 책의 ID로 책을 조회하세요
        Book foundBook = bookRepository.findById(saveBook.getId()).orElseThrow();

        // then
        // TODO: assertThat을 사용하여 결과를 검증하세요
        // 조회된 책의 정보가 저장한 데이터와 일치하는지 확인하세요
        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getId()).isEqualTo(saveBook.getId());
        assertThat(foundBook.getTitle()).isEqualTo("아이야");
        assertThat(foundBook.getAuthor()).isEqualTo("한강");
        assertThat(foundBook.getIsbn()).isEqualTo("1111111111111");
        assertThat(foundBook.getPrice()).isEqualTo(10000);
        assertThat(foundBook.getPublishedYear()).isEqualTo(2024);
    }

    @Test
    @DisplayName("책 정보 수정 테스트")
    void updateBookTest() {
        // [미완성된 코드]
        // given
        Book book = new Book("아이야", "한강",
                "1111111111111", 10000, 2024);
        // TODO: 테스트용 책 데이터를 생성하고 저장하세요
        Book saveBook = bookRepository.save(book);

        // when
        saveBook.setPrice(12000);
        // TODO: 책의 가격을 수정하고 저장하세요
        Book updateBook = bookRepository.save(saveBook);

        // then
        Book foundBook = bookRepository.findById(saveBook.getId()).orElseThrow();
        // TODO: assertThat을 사용하여 수정된 가격을 검증하세요
        // 수정된 책 정보를 조회하여 가격이 정상적으로 변경되었는지 확인하세요
        assertThat(foundBook.getPrice()).isEqualTo(12000);
        assertThat(foundBook.getTitle()).isEqualTo("아이야");
        assertThat(foundBook.getAuthor()).isEqualTo("한강");
        assertThat(foundBook.getIsbn()).isEqualTo("1111111111111");
        assertThat(foundBook.getPublishedYear()).isEqualTo(2024);

    }
    @Test
    @DisplayName("책 삭제 테스트")
    void deleteBookTest() {
        // [미완성된 코드]
        // given
        Book book = new Book("아이야", "한강",
                "1111111111111", 10000, 2024);
        // TODO: 테스트용 책 데이터를 생성하고 저장하세요
        Book saveBook = bookRepository.save(book);

        // when
        bookRepository.deleteById(saveBook.getId());
        // TODO: bookRepository의 deleteById 메서드를 사용하여 책을 삭제하세요

        // then
        // TODO: assertions를 사용하여 책이 정상적으로 삭제되었는지 검증하세요
        assertThat(bookRepository.findById(saveBook.getId())).isEmpty();
        // 삭제된 책의 ID로 조회했을 때 데이터가 존재하지 않는지 확인하세요
        assertThat(bookRepository.existsById(saveBook.getId())).isFalse();
    }
}
//////

package com.example.scrolling.repository;

import com.example.scrolling.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepo extends JpaRepository<Person,Long> {
    //Первичная загрузка
    @Query(value = "select * from person order by id desc limit 10", nativeQuery = true)
    Iterable<Person> findLast10();

    //Последующая загрузка
    Iterable<Person> findAllByIdBetweenOrderByIdDesc(Long start, Long finish);
}

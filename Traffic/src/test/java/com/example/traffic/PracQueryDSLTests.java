package com.example.traffic;

import com.example.traffic.prac_one.PracEntity;
import com.example.traffic.prac_one.QPracEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class PracQueryDSLTests {

    @Autowired
    EntityManager em;

    @Test
    void contextLoads(){

        JPAQueryFactory query = new JPAQueryFactory(em);
        QPracEntity qPracEntity = QPracEntity.pracEntity;

        List<PracEntity> result = query.selectFrom(qPracEntity).fetch();

        assertThat(result).hasSize(4);

        System.out.println(result.get(0));
        System.out.println(result.get(1));
        System.out.println(result.get(2));
        System.out.println(result.get(3));

    }
}

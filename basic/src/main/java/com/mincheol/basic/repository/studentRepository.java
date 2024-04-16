package com.mincheol.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mincheol.basic.entity.StudentEntity;

// Repository 레이어 : 
// - 데이터베이스와 관련된 작업들을 처리하는 영역
// - Service가 비즈니스 로직 수행 중 데이터베이스 작업이 필요할 때 Repository를 거쳐서 데이터베이스 작업을 수행

// @Repository : 해당 클래스를 Spring Bean으로 등록하는 어노테이션, @Component와 동일
// - interface에 @Repository를 사용한 이유
// -JPA를 사용하면 JpaRepository 인터페이스를 상속받은 인터페이스의 구현체를 JPA가 자동으로 생성
@Repository

public interface studentRepository
                // JpaRepository (T,ID) :
                // - JPA 기반의 Repository를 구현하는 주요 인터페이스
                // - 기본 CRUD, 정렬 기능을 제공
                // - JPA 기반 Repository를 생성할때 반드시 상속해야함
                // - 매개타입 T : 해당 Repository가 어떤 entity의 Repository 인지 나타내는 매개타입
                // - 매개타입 ID : 해당 repository에서 사용하는 Entityt의 Primary key 데이터타입을 지정하는 매개타입

                extends JpaRepository<StudentEntity, Integer> {
        // Student 테이블에서 address가 '서울특별시'인 레코드를 조회

        // SQL 표현
        // SELECT * FROM student
        // WHERE address = '서울특별시';

        // SELCT * ALL = find , BY Adress 조건 절, () 값
        List<StudentEntity> findByAddress(String address);

        // SQL
        // SELECT * FROM student
        // WHERE graduation IS true
        // ORDER BY age DESC;

        // Query method 로 변경
        // 반환 되는 개수의 형태를 표현하기 위해 (0개부터 무한대) 리스트로 받아줌
        List<StudentEntity> findByGraduationOrderByAgeDesc(boolean graduation);

        // SQL
        // SELECT * FROM student
        // WHERE student_number = 5
        // AND age > 20
        // (student_number 의 유니크키 조건으로 인해 AND 조건일시 0개부터 1개까지 받을수 있기에)
        StudentEntity findByStudentNumberAndAgeGreaterThan(Integer studentNumber, Integer age);

        // SQL
        // SELECT count(*) FROM student
        // WHERE graduation is false
        int countByGraduation(Boolean graduation);

        // address가 '서울특별시' 이면서 graduation이 true인 레코드가 존재하는가?
        // 받을 타입을 앞쪽에 적어주면됨
        boolean existsByAddressAndGraduation(String address, boolean graduation);

        // @query :
        // - 쿼리 메서드 생성 방식만으로는 실제 SQL을 작성하는데 한계가 있음
        // - 쿼리 메서드는 복잡한 쿼리, 조인, 서브쿼리, 그룹화를 사용할 수 없음
        // - 작업 SQL 문으로 쿼리를 생성하도록 하는 어노테이션

        // 예시 )
        // SELECT * FROM student
        // WHERE student_number = 5
        // AND age > 20

        // JPQL (Java Persistance Query Language) :
        // - 표준 SQL과 매우 흡사하지만 Entity명과 Entity 속성으로 쿼리를 작성하는 방법
        // 여기서 s는 엔티티인 StudentEntity를 나타내며, studentNumber가 5이고 age가 20보다 큰 학생 엔티티를 검색하는 쿼리입니다.
        // FROM student s(AS studentEntity 얼라이언스가 생략 되어 있음)
        @Query(value = "SELECT s FROM student s WHERE s.studentNumber=5 AND s.age > 20 ", nativeQuery = false)
        // 두 개의 매개변수를 받아 쿼리를 실행하여 이 메서드를 호출하면 studentEntity 개체의 리스트가 반환됨
        List<StudentEntity> getStudent2(Integer StudentNumber, Integer age);

        // Native SQL :
        // - 현재 사용하고 있는 RDBMS의 SQL 문법을 그대로 따르는 방식

        @Query(
                        // value="SELECT * FROM student WHERE student_number = ?1 AND age > ?2",
                        value = "SELECT " +
                                        "student_number As stundentNumber, " +
                                        "name, " +
                                        "age, " +
                                        "address, " +
                                        "graduation " +
                                        "FROM student" +
                                        "WHERE student_number=?1" +
                                        "AND age > 72 ", nativeQuery = true)
        // 반환 타입 <반환받을 것> getString(받아올 것들) getString은 내 마음대로 지정해도 됨
        List<StudentEntity> getStudent(Integer StudentNumber, Integer age);

        @Query(value = "SELECT " +
                        "student_number As stundentNumber, " +
                        "name, " +
                        "age, " +
                        "address, " +
                        "graduation " +
                        "FROM student " + // 여기서 공백 추가
                        "WHERE student_number= :student_number " + // 여기서 공백 추가, 파라미터 이름 앞에 띄어쓰기 제거
                        "AND age > :age ", nativeQuery = true) //nativeQuery = true 로 설정하면 기존의 SQL 문을 그대로 쿼리 언어로 사용 가능하다
        List<StudentEntity> getStudent3(
                        @Param("student_number") Integer StudentNumber,
                        @Param("age") Integer age);

                        StudentEntity findByStudentNumber(Integer studentNumber);
}

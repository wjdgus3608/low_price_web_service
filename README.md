# low_price_web_service  
> ## 쇼핑 최저가 검색 웹 서비스  

## 기술 스택  

### front-end  
- **Vue.js**  

### back-end   
- **Java, Spring framework, JPA, Hibernate, MySQL, Gradle, AWS EC2, Redis, Docker, Jenkins**  

## 비즈니스 요구사항  
- 간편하게 상품별 최저가 비교를 할 수 있도록 한다.  
- 검색어에 따른 상품들을 비교 할 수 있어야한다.(ex. 고기)  
- 카테고리 필터링이 가능해야한다.(동적으로 얻어와야함)  
- 유효한 상품인지 확인해야한다.(해당 상품이 아닐수 있음)

## 구현 요구사항 및 유의사항  
- 데이터는 네이버 쇼핑 검색 OpenAPI를 사용함  
- 테스트 코드 기반 TDD(테스트 커버리지 툴 사용해보기)  
- 검색 API 사용시 일 25,000번 제한사항 고려  
- 검색 1회 100개, 최대건수 1,100건 제한사항 고려  
- Spring MVC 패턴으로 구현  
- Redis를 사용하여 캐시 고려  
- 필요 정보 DB에 관리  
- 응답속도 측정 해보기  
- 유효 상품 확인방법 고려(머신러닝, 이미지 인식 API 등)  
- MSA구조로 모듈간 의존성 줄이기  
- 서비스 배포 및 구동 자동화(docker-compose, Jenkins)  

## 시스템 구성  
### 전체 구성도  
### 모듈 구성  
- 어플리케이션(웹)  
- API 모듈  
- batch 모듈  
- core 모듈(DB접근, 도메인)  
- DB  

### 엔티티 구성  
### 클래스 다이어그램  
### 스퀀스 다이어그램  

# low_price_web_service  
> ### 쇼핑 최저가 검색 서비스

## 기술 스택  

### front-end  
- **Vue.js**  

### back-end   
- **Java, Spring framework, JPA, Hibernate, MySQL, Gradle, AWS EC2, Redis, Docker, Jenkins**  

## 비즈니스 요구사항  
- 간편하게 상품별 최저가 비교를 할 수 있도록 한다.  
- 회원가입시 관리자 승인이 필요하도록 한다.  
- 검색어에 따른 상품들을 비교 할 수 있어야한다.(ex. 고기)  
- 비교바구니에서 상품 저장 및 비교가능  
- 비교바구니에서 단위 설정 및 상품명에서 자동입력 계산 가능  
- 비교바구니 가격순 자동정렬  
- 비교바구니 상품순서 고정가능  
- 카테고리 필터링이 가능해야한다.(동적으로 얻어와야함, 개인화 필터링 설정/해제 가능해야함)  
- 유효한 상품인지 확인해야한다.(해당 상품이 아닐수 있음)  
- 무관 상품은 바로 X로 삭제가능(복구도 가능)  
- 무관 상품 삭제시 제외 키워드 선택 가능  
- 유저에 따라 검색 결과가 다르게 필터링
- 정렬 기준에 따른 정렬 가능  

## 구현 요구사항 및 유의사항  
- 데이터는 네이버 쇼핑 검색 OpenAPI를 사용함  
- 테스트 코드 기반 TDD(테스트 커버리지 툴 사용해보기)  
- 검색 API 사용시 일 25,000번 제한사항 고려  
- 검색 1회 100개, 최대건수 1,100건 제한사항 고려  
- 개인화 검색 정보 건수 제한 및 자동 삭제  
- Spring MVC 패턴으로 구현  
- Redis를 사용하여 캐시 고려  
- 필요 정보 DB에 관리  
- 응답속도 측정 해보기  
- 유효 상품 확인방법 고려(~~머신러닝, 이미지 인식 API 등~~ 유저가 선택하는 방식으로 채택)  
- MSA구조로 모듈간 의존성 줄이기  
- 서비스 배포 및 구동 자동화(docker-compose, Jenkins)  

## 추후 부가기능  
- 오류 검색어 정정  
- 쇼핑인사이트 정보 제공  
- 검색어 관리 화면  
- 즐겨찾기 검색 N개 유지  
- 검색어별 레벨 화면  


## 시스템 구성  
### 전체 구성도  
<img width="989" alt="스크린샷 2023-02-11 20 57 13" src="https://user-images.githubusercontent.com/31335823/218256785-4df31f43-6750-4eeb-849a-193922879832.png">. 

### 모듈 구성  
![모듈구성도](https://user-images.githubusercontent.com/31335823/218269137-00a4baa4-8ea9-4c1b-b6c9-913670e8337f.PNG)  


상품 모듈 추가  

### 테이블 구성  
  
![lowPriceERD](https://user-images.githubusercontent.com/31335823/218268925-ae241988-feb9-4a5a-9c60-3bc4029d1aa4.PNG)  

### 클래스 다이어그램  

![ClassDiagram1](https://user-images.githubusercontent.com/31335823/218271737-f6ca89f8-b339-4c93-872e-5deb411dda43.png)  

### 웹 페이지 구성  

- 로그인  
- 회원가입  
- 승인요청내역  
- 검색 메인  
- 상품리스트  
- 회원정보 메인  
- 키워드 내역 상세
  
### 스퀀스 다이어그램  


* 메모  
- 상품조회 결과, API 정보는 캐시 적극활용  
- 설계 > 젠킨스 빌드/배포 로컬 테스트 > 원격 빌드/배포 설정 > 테스트 코드 작성 > 서버개발 > 웹
- Controller 테스트 참조 링크 : https://mangkyu.tistory.com/145 , https://wooody92.github.io/spring%20boot/Spring-Boot-%ED%86%B5%ED%95%A9%ED%85%8C%EC%8A%A4%ED%8A%B8%EC%99%80-%EB%8B%A8%EC%9C%84%ED%85%8C%EC%8A%A4%ED%8A%B8/  
- 기본적인 서비스 CRUD는 통합테스트로, 로직은 단위테스트로 테스트

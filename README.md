# low_price_web_service  
> ## 개인화 쇼핑 검색 서비스  

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
### 모듈 구성  
![모듈구성도](https://user-images.githubusercontent.com/31335823/216994747-7a8708bb-155e-4663-ac47-d7517bc32aef.PNG)  

### 엔티티 구성  
  
![lowPriceERD](https://user-images.githubusercontent.com/31335823/216988706-2b04ca8d-2f50-4398-a29b-f367c4b02e9f.PNG)

### 클래스 다이어그램  

- User  
  * String userId  
  * String userPw  
  * String userName  
  * int userType  
 
- ApiUsage  
  * long _id  
  * int apiType  
  * BigInteger currentUsage  
  * BigInteger maxUsage  

- ExcludeProductInfo  
  * long excludeProductInfoId  
  * String searchKeyword  
  * String ownerId  
  * long totalCnt  

- ExcludeProduct_Keyword  
  * long _id  
  * long excludeProductInfoId  
  * String excludeKeyword  

- CompareCart  
  * long cartId  
  * String ownerId  
  * long totalCnt  
 
- Cart_Product  
  * long _id  
  * long cartId  
  * long productId  

- UserRepository  
- ApiUsageRepository  
- ExcludeProductInfoRepository  
- CompareCartRepository  

- UserService  
  * join()  
  * withdrawal()  
  * login()  
  * logout()  
  * approval()  
  
- ApiUsageService  
  * getUsage()  
  * increaseUsage()  
  * initUsage()  
  
- ExcludeProductInfoService  
  * findAllProductWithFilter()  
  * excludeProduct()  
  * addExcludeKeyword()  
  * findKeywords()  
  * removeKeyword()  
  * removeExcludeKeyword()  
  
- CompareCartService  
  * findCartProduct()  
  * addProduct()  
  * removeProduct()  
  * fixProduct()  
  * removeAllProduct()  
  
- WebPageService  

- UserController  
- ApiUsageController  
- ExcludeProductInfoController  
- CompareCartController  
- WebPageController   

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

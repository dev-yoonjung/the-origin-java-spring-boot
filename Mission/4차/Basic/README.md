# 4차 Basic Mission

로그인, 회원가입 구현

Spring Security를 활용하여, 로그인, 회원가입 기능을 구현해 봅시다. 
강의에서 사용한 UserDetailsService를 활용하되, 필요한 정보를 다 포함할 수 있도록 합시다.

- ```UserEntity```는 저희가 사용자를 저장하기 위해 정의했던 ```Entity```입니다. 잠시 리뷰를 해봅시다.
  - ```username```, ```password```는 일반적인 서비스의 아이디, 비밀번호로 활용됩니다.
  - ```residence```는 AreaEntity 를 필요로 합니다.
  - ```isShopOwner```는 회원가입 시에 추가되어야 합니다.
- ```CommunityUserDetailsService```클래스를 정의하고, ```UserDetailsService```의 구현체로 선언합시다.
  - ```UserRepository```를 멤버 객체로 가지고 있어, ```loadByUsername``` 등의 함수에서 사용할 수 있어야 합니다.
  - 주어진 ```username```에 해당하는 사용자가 없다면, ```UsernameNotFoundException```을 throw 할 수 있도록 작성합시다.
- ```UserRepository```를 통해 받아온 ```UserEntity```를 ```UserDetails```의 형태로 반환할 수 있어야 합니다.
  - ```UserDetails```는 인터페이스로서, Spring Security에서 요구하는 정보를 제공할 수 있는 getter 함수들을 구현하도록 명시되어 있습니다.
  - 강의에서 사용한 미리 구현된 ```User```객체를 사용하거나,
  - 직접 ```UserDetails```를 구현하여, 필요한 내용을 전달하면 됩니다.
  - ```UserController``` 라고 ```@Controller``` Bean을 만들고, 강의와 유사하게 로그인, 회원가입 등의 기능을 추가합시다.
    - 강의에서 사용한 ```signup-form.html``` 을 적당히 수정하면, shop owner를 form에 추가할 수 있습니다. ```type="checkbox"```는 ```Boolean```형으로 Controller 에서 받을 수 있습니다.<br/>
    ```html
    <form th:action="@{/user/signup}" method="post">
        <input type="text" name="username" placeholder="아이디"><br>
        <input type="password" name="password" placeholder="비밀번호"><br>
        <input type="password" name="password_check" placeholder="비밀번호 확인"><br>
        is shop owner&nbsp;<input type="checkbox" name="is_shop_owner"><br>
        <button type="submit">회원가입</button>
    </form>
    ```
    - ```AreaEntity``` 는 편의상 랜덤으로 지정해 줍시다.

## 세부 조건

- ```AreaEntity``` 의 경우, 더미 데이터를 우선 활용합니다.
  - 서울시 서초구 서초동, 37.4877° N, 127.0174° E
  - 서울시 강남구 역삼동, 37.4999° N, 127.0374° E
  - 서울시 강남구 삼성동, 37.5140° N, 127.0565° E
- ```UserDetailsService``` 를 구현할때, ```UserEntity``` 의 모든 정보가 ```UserDetails``` 에 포함될 필요는 없습니다. 기본적으로 ```UserDetails``` 는 인터페이스이며, 정의된 함수들이 다 구현되어 있는 어떤 클래스든 상관없이 사용할 수 있습니다.

## 스크린샷

1. 초기 진입(localhost:8080/home)

   ![image](https://user-images.githubusercontent.com/98807166/159119631-c6e2ad25-3b2a-4a86-acb5-c37c41c6f0fd.png)

2. 회원가입(localhost:8080/user/sign-up)
   1. 일반 유저: 로그인 후 메인 화면(localhost:8080/home)으로 이동
   
      ![image](https://user-images.githubusercontent.com/98807166/159119713-f2a4161b-4fae-4987-8b6b-7f591adf1c4c.png)
      ![image](https://user-images.githubusercontent.com/98807166/159119732-2b69f87a-5e4e-4d71-ae6a-45eb747089ed.png)
      ![image](https://user-images.githubusercontent.com/98807166/159119769-327fb582-e9f6-4eab-a78d-b305b187ada1.png)
   
   2. 상점 주인: 로그인 후 상점 주인 페이지(localhost:8080/shop/home)으로 이동
   
      ![image](https://user-images.githubusercontent.com/98807166/159119868-ea5d17ec-83c2-4ce8-a191-ad2859093a6a.png)
      ![image](https://user-images.githubusercontent.com/98807166/159119893-c1f90024-2739-461e-8168-8ad8311481e1.png)
      ![image](https://user-images.githubusercontent.com/98807166/159119929-40c25d29-a39d-4ea1-b71d-ed3d126f0004.png)
   
      1. 일반 유저로 상점 주인 페이지(localhost:8080/shop/home)로 이동 불가
      
         ![image](https://user-images.githubusercontent.com/98807166/159119979-f4451178-cdfc-4e76-baaa-9dcb671bbe01.png)
         ![image](https://user-images.githubusercontent.com/98807166/159119995-7796dfae-5b08-4811-8ee2-cf93d2e0698b.png)

3. 로그아웃

   ![image](https://user-images.githubusercontent.com/98807166/159119820-5d4c49cb-66ec-42a6-a5d8-115bc07dc3d8.png)
   ![image](https://user-images.githubusercontent.com/98807166/159119839-bf5db03d-fb63-4715-bdcd-8e2a0cbdc155.png)
   ![image](https://user-images.githubusercontent.com/98807166/159119851-56c1d2f3-41e4-49ea-82f1-f26c05d7a4e7.png)

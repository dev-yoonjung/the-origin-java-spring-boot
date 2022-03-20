# 4차 Challenge Mission

Spring Security의 기능은 대부분 Java Servlet Filter를 구성함으로서 만들어집니다. 
새로운 Filter를 구현하여, SSO의 초석을 닦아봅시다.

- 기본적인 로그인 기능이 구현된 서버(SSO)를 구성합시다.
  - 강의에서 사용된 ```login-form.html``` , ```signup-form.html``` 등을 활용하여도 무방합니다.
  - SSO를 활용하고자 하는 서버로서, Mission 3의 프로젝트를 활용합니다.
- Community Project에 새로운 Filter를 정의합니다.
  - Filter에서 Cookie 정보를 확인하여, ```likelion_login_cookie``` 가 존재하는지를 확인합니다.
  - 있다면 해당 내용을 로그로 출력하고, 없을경우 없다고 출력합니다.
- Community Project 의 임시 홈페이지를 만들고, 로그인 버튼을 추가하여 클릭시 SSO 서버로 Redirect가 진행되도록 만듭니다.
- 구체적인 경로는 ```/request-login``` 으로 하고, ```Query Parameter``` 로 ```request_from``` 에 마지막 요청 위치가 포함되도록 합니다.
  - 로그인 성공 이후, Cookie에 ```likelion_login_cookie``` 를 임의의 값으로 추가합시다.
  - 로그인 성공 후  ```/request-login``` 로, 전달받은 데이터를 잃어버리지 않고 돌아가도록 합니다.
  - 로그인 진행후 ```/request-login``` 로 돌아와, 본래 요청을 보냈던 Community Project 로 Redirect 하도록 구성해 봅시다. 이때, Cookie에 추가한 ```likelion_login_cookie``` 역시 ```Query Parameter``` 에 추가합니다.
- 앞서 Communtiy Project 에서 구성하였던 Filter에서, ```(HttpServletRequest) request``` 의 ```getQueryString()``` 에서 ```likelion_login_cookie``` 를 찾아내, Cookie에 저장하도록 합시다.
- Filter 내부에서 ```SecurityContextHolder.getContext()``` 가 정상적으로 작동하는지 확인합니다.
  - Community Project 에 ```spring-boot-starter-security``` 를 추가해 두도록 합니다.
  - ```SecurityContextHolder.getContext().setAuthentication()``` 함수가 잘 호출되는지 확인합니다.
  - 호출한 함수에 ```new Authentication() { ... }``` 을 인자로 전달하고, 내부 함수를 임시로 구현하여 어플리케이션이 사용자가 로그인 한것으로 판단하는지를 확인해 봅니다.

## 세부 조건

- 설명은 복잡해 보이지만, 강의에서 언급한 SSO 구현 방법론을 말로서 풀어 작성한 것입니다. 기본적으로 외부의 다른 서버에 저장되어 있는 사용자의 정보 표현을 일부 가져오는 것을 목표로 합니다.
- 현재 요구 사항까지 진행할 경우, 아직 SSO 로그인이 진행되지는 않습니다. 로그인 성공 이후 받아오게 되는 ```likelion_login_cookie``` 를 가지고 실제 로그인한 사용자의 정보를 확인하는 과정이 필요합니다.
- ```AuthenticationSuccessHandler``` 는 로그인이 성공한 뒤에만 실행되는, Filter와 유사한 동작을 하는 인터페이스 입니다.
- ```Query Parameter``` 는 URL의 구조에 대하여, URL 뒤에 조회 등의 목적으로 추가적인 데이터를 첨부할 때 사용하는 인자입니다. ```@GetMapping``` 의 ```@RequestParam``` 으로 확인할 수 있습니다.

## 스크린샷


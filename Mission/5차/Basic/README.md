# 5차 Basic Mission

사용자 위치 정보 판단

JavaScript를 사용하면 사용자의 위치 정보를 쉽게 받아올 수 있습니다. 사용자의 위치 정보를 받아서, 
사용자의 현재 소재지를 파악하는 기능을 구현해 봅시다. Mission 4 Basic 프로젝트에서 시작합니다.

- HTML Geolocation API를 사용해 봅시다.
  - 아래의 ```getLocation()``` 함수를 이용하면 사용자의 현 위치를 alert 창으로 표시합니다.
  ```javascript
    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);
        } else {
            alert("Geolocation is not supported by this browser.");
        }
    }

    function showPosition(position) {
        alert(`Latitude: ${position.coords.latitude}, Longitude: ${position.coords.longitude}`);
    }
  ```
- ```AreaController``` 에 ```latitude```와 ```longitude```를 인자로 받는 ```RequestMapping``` 을 하나 작성합니다.
- ```AreaService``` 에 ```latitude```와 ```longitude``` 를 인자로 받아서 현재 등록된 ```AreaEntity``` 를 기준으로 
  가장 가까운 AreaEntity 를 반환하도록 합시다.

## 세부 조건

- ```AreaEntity``` 의 경우, 더미 데이터를 우선 활용합니다.
  - 서울시 서초구 서초동, 37.4877° N, 127.0174° E
  - 서울시 강남구 역삼동, 37.4999° N, 127.0374° E
  - 서울시 강남구 삼성동, 37.5140° N, 127.0565° E
- ```index.html``` 에 버튼을 추가하여 ```getLocation()``` 함수를 사용할 수 있도록 합니다.
- Javascript Fetch API를 이용하면 쉽게 HTTP요청을 보낼 수 있습니다.
```javascript
await fetch(`/get-location-info?latitude=${latitude}&longitude=${longitude}`)
```

## 스크린샷

- index.html

![image](https://user-images.githubusercontent.com/98807166/161752238-7010537e-d894-4382-ad43-66466b9e76b1.png)

- AreaController

![image](https://user-images.githubusercontent.com/98807166/161752334-e887fb1d-12c3-4f89-9775-dab6412ee8ea.png)

- AreaService

![image](https://user-images.githubusercontent.com/98807166/161752462-e987eaaf-3d23-49ea-8125-37ab1c18eaf4.png)

![image](https://user-images.githubusercontent.com/98807166/161752599-08349d50-75dc-4be8-b431-dac9d4133ae4.png)


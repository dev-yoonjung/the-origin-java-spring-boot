# 3차 Challenge Mission

목적을 가진 커뮤니티 사이트 만들기

Basic Mission에서 만들었던 서비스를 바탕으로, 좀더 다양한 정보를 가진 서비스를 만들어 봅시다.

- 위치정보를 담기 위한 ```AreaEntity``` 를 만들어 봅시다.
  - ‘도, 광역시’, ‘시,군,구’, ‘동,면,읍’ 데이터를 따로 저장할 수 있도록 합시다.
  - ‘위도’, ‘경도’ 데이터를 저장할 수 있도록 합시다.
- 사용자 정보를 담는 ```UserEntity``` 를 Basic Mission과 유사하게 만들되, 사용자를 두가지로 분류할 수 있도록 합시다.
  - 위에 만든 ```AreaEntity``` 에 대한 정보를 담을 수 있도록 합시다. 이 정보는 자신의 거주지를 담기 위한 정보입니다.
  - ```UserEntity``` 는 사용자 하나를 나타내며, 일반 사용자 또는 상점 주인인지에 대한 분류가 되어야 합니다.
- 특정 ```UserEntity``` 만 가질 수 있는 ```ShopEntity``` 를 작성합시다. 또, 해당 ```ShopEntity``` 가 취급하는 품목에 대한 ```Category``` 를 어떻게 다룰지 생각하여 나타낼 수 있도록 합시다.
  - ```ShopEntity``` 는 어디 지역의 상점인지에 대한 정보를 가지고 있어야 합니다.  
- 마지막으로 ```ShopEntity``` 에 대한 게시글인, ```ShopPostEntity``` 와 ```ShopReviewEntity``` 를 작성해 봅시다.
  - ```ShopReviewEntity``` 는 어떤 사용자든 작성할 수 있으나, ```ShopPostEntity``` 는 해당 ```ShopEntity``` 에 대한 주인 ```UserEntity``` 만 작성할 수 있어야 합니다.

## 세부 조건

- 생성된 테이블의 실제 이름에는 Entity 라는 문구가 들어가지 않도록 @Table 어노테이션을 활용합시다.
- 변동될 가능성이 있는 데이터와 변동될 가능성이 없는 데이터를 잘 구분하여, Entity 작성 여부를 잘 판단합시다.
- Entity 를 먼저 구성하되, 시간이 남으면 CRUD까지 구성해 봅시다.

## 스크린샷

![image](https://user-images.githubusercontent.com/98807166/157263766-dd75b129-8266-4872-a5ce-4f2c2800673e.png)



# 1차 Basic Mission

- 사람을 나타내는 Person 인터페이스를 정의하고, 
<br/>사람을 구현하는 추상 클래스 AbstractPerson 을 구현한 다음,
<br/>AbstractPerson 을 확장하는 Student 와 Lecturer 클래스를 각각 만들어보세요.

## 세부 조건

- Person 인터페이스는 사람을 나타내는 인터페이스로서, void speak() 함수를 가지고 있습니다. Person 인터페이스의 구현체는 speak 함수를 통해 자신의 정보를 출력합니다.


- AbstractPerson 추상 클래스는 사람이라면 공통적으로 가지는 정보, 기능 등을 구현하기 위한 클래스 입니다. 이름, 나이 정보 등을 가지고 있으며, speak 함수도 사용할 수 있습니다.


- Student 와 Lecturer 는 AbstractPerson 을 extend 하며, speak 함수를 사용할 때 자신의 이름과 학생인지, 강사인지를 이야기해줍니다.
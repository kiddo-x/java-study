
# 📘 SRP / OCP 정리 

# 🎯 SRP & OCP — 객체지향 설계 원칙 정리

본 문서는 SOLID 중 **SRP(단일 책임 원칙)** 과 **OCP(개방-폐쇄 원칙)** 을 정리하고,  
직접 만든 실습 예제를 포함한 기록용 문서입니다.

---

# ✅ 1. SRP — Single Responsibility Principle (단일 책임 원칙)

## 📌 개념
> **하나의 클래스는 하나의 책임만 가져야 한다.**  
> 변경 이유가 2개 이상이면 SRP를 위반한 것이다.

### 왜 필요한가?
- 변경이 일어날 때 연쇄 버그를 막기 위함  
- 유지보수가 쉬워짐  
- 테스트하기 쉬운 클래스 구조가 됨  

---

## 📉 SRP 위반 예시

```java
// 1) 회원 정보 관리
// 2) 파일 저장 로직
// 두 책임을 한 클래스에서 처리 → SRP 위반
class MemberService {
    public void createMember() { /*...*/ }

    public void saveToFile(String data) {
        // 파일 저장 로직 (IO 책임)
    }
}
````

문제가 되는 점:

* 회원 도메인이 바뀌어도 파일 코드가 영향을 받음
* 파일 저장 방식을 바꾸면 서비스 로직도 함께 수정됨

---

## ✅ SRP 준수 리팩터링

```java
class MemberService {
    private final FileWriter writer;

    MemberService(FileWriter writer) {
        this.writer = writer;
    }

    public void createMember() { /*...*/ }
}

class FileWriter {
    public void save(String data) { /*...*/ }
}
```

변경 이유가 분리됨:

* 회원 생성 규칙 변경 → MemberService 수정
* 저장 방식 변경 → FileWriter 수정

---

# ✔ **실습 1 — SRP(단일 책임 원칙) 위반 코드 리팩토링**

아래 코드는 **하나의 클래스가 ‘너무 많은 역할’을 수행하는 SRP 위반 코드**다.
문제를 읽고, *SRP를 만족하도록 클래스를 분리*해보자.

---

## 📝 **문제 — 사용자 회원가입 처리**

### ❌ 아래 코드는 SRP를 심하게 위반하고 있다.

```java
class UserService {

    public void registerUser(String email, String password) {
        // 1. 입력 검증
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password too short");
        }

        // 2. 비밀번호 암호화
        String encrypted = encrypt(password);

        // 3. DB 저장
        System.out.println("Saving user to DB... email=" + email);

        // 4. 이메일 발송
        System.out.println("Sending welcome email to " + email);
    }

    private String encrypt(String pw) {
        return "encrypted-" + pw;
    }
}
```

### 🎯 요구사항

SRP에 따라 다음 책임을 각각 **별도의 클래스로 분리**해라.

* 입력 검증
* 비밀번호 암호화
* 사용자 저장
* 이메일 발송
* UserService는 "회원가입 흐름"만 담당해야 함

---

### 해결 코드

```java
class UserService {

    private final ValidationService validationService = new ValidationService();
    private final EncryptedService encryptedService = new EncryptedService();
    private final DbService dbService = new DbService();
    private final EmailService emailService = new EmailService();

    public void registerUser(String email, String password) {

        validationService.validate(email, password);

        String encrypted = encryptedService.encrypt(password);

        dbService.save(email, encrypted);

        emailService.sendWelcome(email);
    }
}

class ValidationService {
    public void validate(String email, String password) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password too short");
        }
    }
}

class EncryptedService {
    public String encrypt(String pw) {
        return "encrypted-" + pw;
    }
}

class DbService {
    public void save(String email, String encryptedPw) {
        System.out.println("Saving user to DB... " + email + ", pw=" + encryptedPw);
    }
}

class EmailService {
    public void sendWelcome(String email) {
        System.out.println("Sending welcome email to " + email);
    }
}

```

---

# 🚀 2. OCP — Open Closed Principle (개방-폐쇄 원칙)

## 📌 개념

> **확장에는 열려 있고, 변경에는 닫혀 있어야 한다.**
> 새로운 기능을 추가할 때 기존 코드를 수정하지 말아야 한다.

### 핵심 요점

* "if-else 지옥"을 다형성으로 해결
* 전략 패턴(Strategy)과 아주 밀접한 원칙
* 인터페이스 / 추상화를 잘 사용해야 OCP를 만족함

---

## 📉 OCP 위반 예시

```java
class PaymentService {
    public void pay(String type) {
        if (type.equals("kakao")) { /*...*/ }
        else if (type.equals("naver")) { /*...*/ }
        else if (type.equals("card")) { /*...*/ }
    }
}
```

문제점:

* 새로운 결제 방식 추가 때마다 `pay()` 수정
* 테스트와 유지보수 비용 증가

---

## ✅ OCP 준수 리팩터링 (전략 패턴 적용)

```java
interface PaymentStrategy {
    void pay();
}

class KakaoPay implements PaymentStrategy {
    public void pay() { /*...*/ }
}

class NaverPay implements PaymentStrategy {
    public void pay() { /*...*/ }
}

class CardPay implements PaymentStrategy {
    public void pay() { /*...*/ }
}

class PaymentService {
    private final PaymentStrategy payment;

    PaymentService(PaymentStrategy payment) {
        this.payment = payment;
    }

    public void pay() {
        payment.pay();
    }
}
```

확장 추가 시:

* `ApplePay` 클래스를 새로 만들기만 하면 됨
* 기존 `PaymentService` 수정 필요 없음 → OCP 충족

---

# ✔ **실습 2 — OCP(개방-폐쇄 원칙) 문제**

아래 코드는 변경이 생기면 `if-else`를 계속 늘려야 하는 **OCP 위반 코드**다.

---

## 📝 **문제 — 할인 정책 적용**

### ❌ 아래는 OCP를 위반하는 코드

```java
class DiscountService {
    public int discount(String grade, int price) {
        if (grade.equals("VIP")) {
            return price - 1000;
        } else if (grade.equals("GOLD")) {
            return price - 500;
        } else {
            return price;
        }
    }
}
```

### 🎯 요구사항

1. 할인 정책을 인터페이스 `DiscountPolicy`로 추상화하라.
2. VIP, GOLD, NONE 정책을 각각 클래스로 만들어라.
3. DiscountService는 if-else 없이 전략을 선택해 적용해야 한다.

---


### 해결 코드

```java
// 인터페이스: 확장 포인트
interface DiscountPolicy {
    int discount(int price);
}

// 구현체들 (확장 가능)
class VipDiscount implements DiscountPolicy {
    @Override
    public int discount(int price) {
        return price - 1000;
    }
}

class GoldDiscount implements DiscountPolicy {
    @Override
    public int discount(int price) {
        return price - 500;
    }
}

class NormalDiscount implements DiscountPolicy {
    @Override
    public int discount(int price) {
        return price;
    }
}

// 변경 없이 확장 가능한 핵심 서비스 (OCP 만족)
class DiscountService {
    public int calc(int price, DiscountPolicy policy) {
        return policy.discount(price);
    }
}

```

# ✔ **실습 3 — SRP + OCP 복합 문제 (실전형)**

---

## 📝 **문제 — 결제(Payment) 시스템 리팩토링**

### ❌ 아래 코드는 SRP/OCP 둘 다 위반한다.

```java
class PaymentProcessor {

    public void pay(String method, int amount) {
        // 1. 결제 검증
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        // 2. 분기 처리
        if (method.equals("CARD")) {
            System.out.println("Card 결제 처리...");
        } else if (method.equals("KAKAO")) {
            System.out.println("카카오페이 결제 처리...");
        } else if (method.equals("NAVER")) {
            System.out.println("네이버페이 결제 처리...");
        }

        // 3. 로그 기록
        System.out.println("결제 기록 저장");
    }
}
```

### 🎯 요구사항

1. 결제 수단(Card, Kakao, Naver)을 인터페이스로 추상화(OCP 만족).
2. 결제 검증, 결제 처리, 로그 기록을 각각 다른 책임으로 분리(SRP 만족).
3. PaymentProcessor는 "결제 흐름 관리"만 담당하도록 리팩토링.

---
### 해결 코드

```java
interface PaymentMethod{
    void process();
}

class CardPay implements PaymentMethod {
    @Override
    public void process(){
        System.out.println("Card 결제 처리...");
    }
}

class KakaoPay implements PaymentMethod {
    @Override
    public void process(){
        System.out.println("카카오페이 결제 처리...");
    }
}

class NaverPay implements PaymentMethod {
    @Override
    public void process(){
        System.out.println("네이버페이 결제 처리...");
    }
}

class PaymentProcessor {
    private final ValidationService validationService = new ValidationService();
    private final LogService logService = new LogService();
    
    public void pay(PaymentMethod method, int amount){
        validationService.validate(amount);
        Method.process();
        logService.logRecord();
    }
}

class ValidationService{
    public void validate(int amount){
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
    }
}

class LogService{
    public void logRecord(){
        System.out.println("결제 기록 저장");
    }
}

```
---

# 🧩 마무리

| 원칙      | 요약                           |
| ------- | ---------------------------- |
| **SRP** | 클래스는 단 하나의 책임(변경 이유)만 가져야 한다 |
| **OCP** | 확장에는 열려 있고 변경에는 닫혀 있어야 한다    |

이 두 원칙은 Spring, JPA, Service/Repository 구조에서 매일 사용되는 핵심 원칙입니다.

---

# 📎 참고

* SOLID 개념 정리 문서(추가 예정)
* Strategy 패턴 문서(추가 예정)

```

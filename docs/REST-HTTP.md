

# 🌐 HTTP & REST 핵심 정리

## 1️⃣ HTTP란 무엇인가?

**HTTP (HyperText Transfer Protocol)**
→ 클라이언트(브라우저)와 서버가 **요청(Request)** 과 **응답(Response)** 으로 통신하는 규칙

 핵심 특징

* **Stateless (무상태)**
  → 요청 하나하나가 독립적 (이전 요청 기억 X)
* **Client – Server 구조**
* 텍스트 기반 (요즘은 JSON 사용)

---

## 2️⃣ HTTP 요청 / 응답 구조

###  HTTP Request 구조

```
POST /users/login HTTP/1.1
Host: example.com
Content-Type: application/json

{
  "email": "test@test.com",
  "password": "1234"
}
```

| 구성 요소  | 설명                 |
| ------ | ------------------ |
| Method | 요청 동작 (GET, POST…) |
| URL    | 자원 위치              |
| Header | 메타 정보              |
| Body   | 실제 데이터             |

---

###  HTTP Response 구조

```
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": 1,
  "name": "Park"
}
```

| 구성 요소       | 설명     |
| ----------- | ------ |
| Status Code | 결과 상태  |
| Header      | 응답 정보  |
| Body        | 응답 데이터 |

---

## 3️⃣ HTTP Method 정리 (⭐⭐⭐ 중요)

| Method | 역할    | 특징         |
| ------ | ----- | ---------- |
| GET    | 조회    | 서버 상태 변경 X |
| POST   | 생성    | 데이터 생성     |
| PUT    | 전체 수정 | 전체 리소스 교체  |
| PATCH  | 부분 수정 | 일부만 수정     |
| DELETE | 삭제    | 리소스 제거     |

📌 예시

```
GET    /users/1        → 사용자 조회
POST   /users          → 사용자 생성
PUT    /users/1        → 사용자 전체 수정
DELETE /users/1        → 사용자 삭제
```

---

## 4️⃣ HTTP 상태 코드 (면접 단골)

###  2xx — 성공

| 코드  | 의미      |
| --- | ------- |
| 200 | OK      |
| 201 | Created |

###  4xx — 클라이언트 오류

| 코드  | 의미     |
| --- | ------ |
| 400 | 잘못된 요청 |
| 401 | 인증 실패  |
| 403 | 권한 없음  |
| 404 | 자원 없음  |

###  5xx — 서버 오류

| 코드  | 의미       |
| --- | -------- |
| 500 | 서버 내부 오류 |

---

## 5️⃣ REST란 무엇인가?

**REST (Representational State Transfer)**
→ HTTP를 **자원(Resource) 중심**으로 사용하기 위한 설계 원칙

 핵심 개념

* **URI는 자원**
* **행위는 HTTP Method**
* **상태 코드는 HTTP 상태 코드로 표현**
* **JSON 형태 데이터 교환**

---

## 6️⃣ RESTful API 설계 예시

###  안 좋은 설계

```
POST /getUser
POST /deleteUser
```

###  RESTful 설계

```
GET    /users/1
POST   /users
DELETE /users/1
```

 **URI에는 동사 ❌, 명사 ⭕**

---

## 7️⃣ REST 핵심 원칙 요약

| 원칙        | 설명            |
| --------- | ------------- |
| 자원 중심     | URI는 명사       |
| 행위 분리     | Method로 동작 표현 |
| Stateless | 요청 간 상태 저장 X  |
| 표현 사용     | JSON 등        |

---

## 8️⃣ HTTP vs REST 차이

| 구분 | HTTP  | REST        |
| -- | ----- | ----------- |
| 성격 | 통신 규칙 | 설계 방식       |
| 범위 | 저수준   | 고수준         |
| 관계 | 기반    | HTTP 위에서 동작 |

 **REST는 HTTP를 잘 쓰는 방법**

---

## 9️⃣ Spring과 연결되는 포인트 

Spring에서 이 개념들이 이렇게 매핑됨 👇

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) { }

    @PostMapping
    public User createUser(@RequestBody User user) { }
}
```

| 개념          | Spring          |
| ----------- | --------------- |
| HTTP Method | @GetMapping     |
| URI         | @RequestMapping |
| Body        | @RequestBody    |
| Status      | ResponseEntity  |

---

##  오늘 정리 핵심

* HTTP = 통신 규칙
* REST = HTTP를 사용하는 설계 철학
* URI는 자원, Method는 행동
* 상태 코드는 반드시 의미 맞게 사용
* Spring은 이 개념을 그대로 코드로 옮긴 것



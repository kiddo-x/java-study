
# 📌 Java Stream & Optional 요약 정리

## 1. Stream 기본 개념

Java의 Stream은 **데이터를 선언형(함수형) 방식으로 처리**할 수 있게 해주는 API다.

### ✔ 핵심 특징

* 배열/컬렉션을 **파이프라인 방식**으로 처리 (`filter → map → reduce`)
* **불변성 유지** (원본 데이터 변경 X)
* **지연(lazy) 연산**
* **병렬 처리(parallelStream) 지원**

---

## 2. intStream vs Stream<Integer> 차이

| 구분    | IntStream                    | Stream<Integer>                |
| ----- | ---------------------------- | ------------------------------ |
| 저장 타입 | 기본형 `int`                    | 참조형 `Integer`                  |
| 오토박싱  | ❌ 없음                         | ⭕ 필요 (비용 증가)                   |
| 제공 기능 | `sum()`, `average()` 등 숫자 특화 | 일반적인 Stream 기능                 |
| 변환    | `.boxed()` → Stream<Integer> | `.mapToInt(Integer::intValue)` |

📌 **성능 최적화**에서는 `IntStream`이 더 적합.

---

## 3. Optional 요약

### Optional은?

> 값이 있을 수도 있고 없을 수도 있는 상황을 표현하기 위한 “null-safe Wrapper 객체”

### 언제 Optional이 등장?

* `findFirst()`, `findAny()` 같이
  “값이 없을 수 있는” 스트림 연산 결과에서 등장

---

## 4. Optional 핵심 메서드 4개

### ✔ 1) `orElse(value)`

값이 없으면 기본값 반환

```java
opt.orElse("empty");
```

### ✔ 2) `orElseGet(() -> ...)`

지연(Lazy) 계산을 통해 기본값 제공

```java
opt.orElseGet(() -> createDefault());
```

### ✔ 3) `orElseThrow()`

값이 없으면 예외 발생

```java
opt.orElseThrow(() -> new IllegalStateException());
```

### ✔ 4) `ifPresent(consumer)`

값이 있을 때만 실행

```java
opt.ifPresent(v -> System.out.println(v));
```

📌 **이 4개 정도면 실무 + 코딩 테스트 전부 충분**

---

## 5. 오늘의 예제 풀이 정리

### ✔ 예제 1 — 짝수만 골라 제곱한 리스트 만들기

```java
int[] arr = {1, 2, 3, 4, 5};

List<Integer> result = Arrays.stream(arr)
    .filter(n -> n % 2 == 0)
    .map(n -> n * n)
    .boxed()
    .toList();
```

### ✔ 예제 2 — 문자열 중 길이 ≥ 3만 필터링

```java
List<String> list = List.of("hi", "apple", "car", "sun");

List<String> result = list.stream()
    .filter(s -> s.length() >= 3)
    .toList();
```

---

## ✔ 예제 3 — [완주하지 못한 선수](/programmers/level_1/IncompleteParticipant.java) (Stream 버전)

```java
Map<String, Long> countMap = Arrays.stream(participant)
    .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

Arrays.stream(completion)
    .forEach(c -> countMap.put(c, countMap.get(c) - 1));

String p3 = countMap.entrySet().stream()
    .filter(e -> e.getValue() != 0)
    .map(Map.Entry::getKey)
    .findFirst()
    .orElse("");

```

---

## ✔ 예제 4 — [로또 문제](/programmers/level_1/LottoRank.java) win_nums → Set 변환(Stream 이용) 

```java
Set<Integer> winSet = Arrays.stream(win_nums)
    .boxed()
    .collect(Collectors.toSet());
```

---

## ✔ 예제 5 — 합계 구하기

```java
//version 1
int sum = List.of(1,2,3,4,5).stream()
    .reduce(0, Integer::sum);

//version 2
int sum = List.of(1,2,3,4,5).stream()
    .mapToInt(Integer::intValue)
    .sum();
```

---

## 6. 스트림 팁

* 원본 변경 없이 데이터 처리 가능
* 가독성이 좋아짐
* 병렬 처리 쉽게 가능
* 단, 지나치게 복잡한 Stream은 **오히려 가독성 저하** → for문이 더 나을 때도 있음

---




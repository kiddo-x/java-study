
### 📌 Java 입력 최적화 정리 (SWEA / 삼성 SW 역량테스트 대비)

#### 1. BufferedReader

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```

* 한 줄 단위 입력
* `Scanner` 대비 **속도 훨씬 빠름**
* `readLine()` 사용
* `IOException` 발생 가능 → 예외 처리 필수

---

#### 2. StringTokenizer

```java
StringTokenizer st = new StringTokenizer(br.readLine());
int a = Integer.parseInt(st.nextToken());
int b = Integer.parseInt(st.nextToken());
```

* 공백 기준 문자열 분리
* 반복 입력 처리에 최적
* `split()` 보다 빠르고 메모리 효율적

---

#### 3. throws Exception

```java
public static void main(String[] args) throws Exception
```

* `BufferedReader.readLine()`의 `IOException` 처리 목적
* try-catch 없이 간결한 코드 작성 가능
* **시험 환경에서 표준 사용 방식**

---

#### 4. 기본 입력 템플릿 (암기)

```java
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
        }
    }
}
```

---

#### 5. Scanner를 쓰지 않는 이유

* 입력 속도 느림
* 대용량 입력에서 시간 초과 위험
* B형 / SWEA 고난이도 문제에서 **비권장**

---

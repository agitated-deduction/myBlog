
# session

## 세션 저장
@SessionAttributes
Model의 정보를 httpsession에 저장해주는 어노테이션

```java
@SessionAttributes("uid")

...

model.addAttribute("uid", uid);
```
같은 이름으로 model에 저장 시 session에도 저장됨.

## 세션 초기화
```java
sessionStatus.setComplete();
```

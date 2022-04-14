# Context(문맥 - 앱의 흐름)

## 구조
    - Book (Application Context)
    - Chapter1 (Activity Context)
        - chapter1-1
        - chapter1-2
    - Chapter2 (Activity Context)
        - chapter2-1
        - chapter2-2
    - Chapter3 (Activity Context)
        - chapter3-1
        - chapter3-2
        - chapter3-3
    - Chapter4 (Activity Context)
        - chapter4-1
        - chapter4-2
        - chapter4-3

## Context
    - Application Context
        - 단 하나만 존재
        - 앱 전반적인 흐름
        - 어플리케이션 전반에 걸친 환경, 정보 등

    - Activity Context
        - Activity 마다 존재
        - Activity 내부의 흐름
        - Activity 전체에 걸친 환경, 정보 등
        - Context를 구현하고 기능을 추가한 것이 -> Activity

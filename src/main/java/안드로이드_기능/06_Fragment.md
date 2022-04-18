# Fragment

## 1. 정의
    - 모듈식(재사용)

    - Fragment는 FragmentActivity 내의 어떤 동작 또는 사용자 인터페이스(XML)의 일부를 나타낸다.
    - Activity > FragmentActivity > Fragment (즉, Fragment가 있는 Activity가 FragmentActivity)
    - 여러개의 Fragment를 하나의 Activity에 결합하여 창이 여러 개인 UI를 빌드 할 수 있으며
    - 하나의 Fragment를 여러 Activity에서 재사용 할 수 있다.

    - Fragment는 Activity의 모듈식 섹션이라고 생각하면 된다.
    - Fragment는 자체적인 수명 주기를 갖고, 자체 입력 이벤트를 수신한다.
        - 수명 주기는 host Activity의 수명 주기에 직접적인 영향을 받는다.
    - Activity 안에 있는 Activity라고 생각 할 수 있다.
    - 다른 Activity에 재사용 할 수 있는 "하위 Activity" 같은 개념이다.

## 2. 생명주기
    - onAttach()
        - Fragment가 Activity와 연결되어 있는 경우 호출된다.
        - 여기에서 Activity가 전달이 된다.
    - onCreate()
        - Fragment를 생성할 때 시스템에서 호출한다.
        - 초기화 작업을 해야 한다.
    - onCreateView()
        - Fragment가 자신의 interface(화면)를 처음으로 그릴 시간이 되면 호출된다.
        - View를 반환해야 한다.
        - UI를 제공하지 않는 경우에는 null을 반환
    - onPause
        - 사용자가 Fragment를 떠난다는 것을 나타내는 첫번째 신호
        - 변경 사항을 저장하면 좋다.
    - onDetach
        - Fragment가 Activity와 연결이 끊어지는 중에 호출된다.

## 3. 생성방법
    - xml
    - code

## 4. Activity와 통신하는 방법
    - 데이터 전달하는 방법
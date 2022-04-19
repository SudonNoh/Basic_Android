# Thread
    - 프로그램(앱)을 실행하는 흐름
    - Thread가 작업을 처리하는 데 시간이 오래 걸리는 작업을 만날 수 있다.
        - (다른 Thread에 의해서) Thread는 추가될 수 있다.
        - (다른 Thread에 의해서) 실행 중 언제든지 필요에 따라 만들어질 수 있고 제거될 수 있다.
        - (다른 Thread에 의해서) 반드시 한 개의 Thread가 있어야 한다. (main Thread)

## Main Thread
    - 최초로 실행되며 무조건 실행이 된다.
    - 두 번째 Thread는 무조건 Main Thread에서 생성이 되었다.
    - 세 번째 Thread 부터는 Main Thread 또는 다른 Thread에 의해서 생성이 될 수 있다.

## 안드로이드에서의 Main Thread(UI Thread)
    - 화면을 그리는 역할을 담당
        - 다른 Thread는 화면을 그릴 수 없다.
        - Thread는 서로 독립적이기 때문에 어느 Thread가 언제 어떤 작업을 하는지 알 수 없다.
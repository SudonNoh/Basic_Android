# Activity

## Activity란 ?
    - 화면을 구성하는 가장 기본이 되는 요소
    - 자동으로 activity와 매칭되는 xml을 생성해준다 + manifest에도 등록이 된다.
    - 화면을 그리는 기능 + 화면에서 발생할 수 있는 일들을 처리할 수 있는 기능 내장

## 특수한 Activity
    - launcher activity, main activity
        - 앱이 실행될 때 최초로 실행되는 activity

## LifeCycle(생명주기)
    - 안드로이드 OS가 activity를 직접 종료시키는 일은 없다.
        - 다만 프로세스는 종료 가능
    - onCreate()
        - 필수적으로 구현을 해야 한다.
        - 생명주기 중에서 단 한번만 발생한다.
            - 단 한번만 하면 되는 일들을 여기에서 구현한다.
            - 화면 그리기, 데이터 준비
    - onStart()
        - activity를 foreground로 보내 상호작용 할 수 있도록 준비
            - forground: 앱이 사용자 눈에 보이는 상태/사용 중인 상태
            - background: A 앱이 켜져있는 상태에서 B 앱을 켜면 A 앱은 background 상태가 된다.
        - 매우 빠르게 완료된다.
    - onResume()
        - 앱이 사용자와 상호작용이 가능한 상태
        - 특정 이벤트가 발생하여 앱에서 focus가 떠날 때까지 이 상태에 머문다.
            - focus가 떠난 상태: 전화가 온다거나, 기기 화면이 꺼질 때
        - 화면이 가려지지 않으면 onResume() 상태에서 머문다.
    - onPause()
        - 사용자가 activity를 떠나는 것을 나타내는 첫번째 신호
            - activity가 foreground에 있지 않다는 신호
            - app 선택 창에 있을 때의 상태
        - 작업을 일시 정지한다.
            - 영상 일시 정지, GPS 일시 정지
    - onStop()
        - activity가 더이상 사용자에게 표시가 되지 않는 상태
            - 새로운 activity가 나오는 경우
            - 화면이 가려지는 경우: 전화가 오는 경우, 기기 화면이 꺼진 경우
        - 일시정지보다 강도가 높은 작업
        - 사용자에게 보이지 않는 동안 앱은 리소스를 해제 해야 한다.
            - 영상 종료, GPS 종료
        - 마지막으로 해야 할 일 등을 수행
            - 사용자가 쓰던 상태를 저장을 할 수 있는 마지막 기회
        - A 앱을 사용 중에 B 앱을 실행, A 앱은 onStrop() 상태로 background에 있다.
        - 다시 A앱으로 돌아오면 onRestart()를 거쳐 onStart() 상태로 전환
    - onDestroy()
        - activity가 소멸되기 전에 호출
            - 기기 회전 또는 멀티 윈도우 모드에서 시스템이 일시적으로 activity를 소멸시키는 경우
        - onStop()에서 해제되지 않은 모든 리소스를 해제해야 한다.


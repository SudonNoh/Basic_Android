# Activity Stack
    - 기본: 후입선출(LIFO, Last In, First Out)
    - stack은 될 수 있으면 건드리지 않는게 좋다.
    - 만약 조정해야 한다면 분명한 의도를 가지고 작업해야 한다.

    Activity A를 실행
    A

    Activity A가 실행되는 상태에서 B를 실행
    B (Foreground)
    A

    C (Foreground)
    B
    A

    C - 이 단계에서 뒤로가기를 누르면 C가 사라지고
    B (Foreground)
    A

## Stack 관리
    - Manifest 이용
        - launchMode                             
            - standard(LIFO)
        - singleTop
            - 이동하려는 엑티비티가 이미 스택에 존재하는 경우 새로 만들지 않는다
        - singleTask
            - singleTask로 런치모드가 설정된 엑티비티가 호출 되었을때 새로운 박스에 담는다
            -> 새로운 박스에도 다른 엑티비티를 쌓을 수 있다
        - singleInstance
            - singleTask로 런치모드가 설정된 엑티비티가 호출 되었을때 새로운 박스에 담는다
            -> 새로운 박스에도 다른 엑티비티를 쌓을 수 없다

    - Intent Flag 이용
        - FLAG_ACTIVITY_NEW_TASK (singleTask)
        - FLAG_ACTIVITY_SINGLE_TOP (singleTop)
    
        - FLAG_ACTIVITY_NO_HISTORY
            - 호출된 엑티비티는 스택에 쌓이지 않는다 (로딩)
        - FLAG_ACTIVITY_REORDER_TO_FRONT
            - 호출된 엑티비티가 스택에 존재할 경우 최상위로 올려준다
            - A B C -> B를 호출 -> A C B
        - FLAG_ACTIVITY_CLEAR_TOP
            - A B C -> A를 호출 -> A
    
        - FLAG_ACTIVITY_NO_ANIMATION
            - 화면전환 애니메이션 생략한다
    - Intent Flag 적용
        - setFlag
            - 기존에 적용된 flag를 삭제하고 다시 설정한다
        - addFlag
            - flag를 추가한다
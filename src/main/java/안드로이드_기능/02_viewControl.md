# How To Control View
    - 사용자와의 상호작용으로 인해서 View를 조작하는 방법
        - View에 이벤트가 발생했을 때 처리하는 방법
    - Listner
        - 이벤트가 발생했을 때 수신하는 역할

    - View
        - 지금까지 xml에 파일이 존재했다.
        - xml에 존재하는 View를 activity로 가져오는 방법
            - findViewById
                - Id > xml에서 부여한 View의 id
            - kotlinx
                - 귀찮은 findViewById 과정을 생략 가능
                - deprecated 되었다.
                    - 가급적이면 사용을 피해야 한다.
            - databinding
                - View와 Data를 묶는다.
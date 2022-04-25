# NetWork
    - 두 대 이상의 컴퓨터를 연결하는 것(Client 와 Server의 연결)
    - Client 와 Server 의 연결
        - Client : 사용자가 볼 수 있는 기기 (N개)
        - Server : 사용자가 볼 수 없는 기기 (1개)

    - 네트워크가 필요한 이유
        1) Client(App) -> Network(Internet) -> Server에 요청(첫 화면을 그리기 위한 데이터)
        2) Server -> Internet -> Client에 응답(화면을 그릴 수 있는 데이터가 도착)
        
        Client의 Request(요청), 서버가 Response(응답)를 보낸다. 

    - 네트워크의 문제점
        - 대부분의 앱들이 정보를 서버로부터 받아서 화면을 구성한다.
            - 매번 똑같은 화면을 그리는데 매번 요청을 하면 낭비다
        -> 해결책 : 캐싱
            - 한번 받은 데이터를 클라이언트가 로컬 데이터베이스에 저장을 하고
              다시 필요한 경우에 서버에게 요청을 하는 것이 아니라 로컬 데이터베이스에 있는 데이터를 이용
        -> 캐싱은 구현 난이도가 높다

## Networking
    - Server와 Client의 의사소통
    - Network 약속(Protocal : 프로토콜)이 존재한다.

## Network Protocol(규약)
    - FTP -> 파일 전송 규약
    - SMTOP -> 메일 전송 규약
    - HTTP -> 인터넷 서비스를 위한 규약

    Request(요청)
        - Request Header
            - 요청에 대한 추가 정보
        - Request Body
            - 추가 정보
            - JSON 형태로 보낸다
        - Request Method
            - GET, POST, PUT, PATCH, DELETE

    Response(응답)
        - Response Code
            - 응답의 요약
            - Status Code
        - Response

## JSON
    - 사용 방법
        - { } 객체 표현
        - [ ] 배열 표현
        - Key Value 방식
    - string
    - number (int, float)
    - object
    - array
    - Boolean
    - null
        
## Serializing (Serializer)
    - 꼬챙이로 객체를 담는다
    - 학생 객체 (이름, 번호, 나이)
    - 객체를 전송하기 위한 데이터 포맷으로 바꿔준다.

### HttpURLConnection
    - 안드로이드에서 기본으로 제공해주는 네트워크 모듈
    - 매우 번거롭다

### HttpURLConnection의 사용을 변하게 만들어 주는 라이브러리
    - Volly
    - Retrofit
    - OKHttp
    - ...
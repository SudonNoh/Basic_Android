# ListView
    - 기본적인 동작원리는 addView와 동일하다
    
    - Adapter
        - 데이터와 뷰를 짝지어 준다.
        - 제공해주는 기능
            1) 요청시 해당 번째 데이터를 준다.
            2) 데이터가 변경 되었을 때 갱신해준다.
            3) 
    
    - BaseAdapter
        - ArrayAdapter : 배열 타입
        - CursorAdapter : 데이터 전용
        - SimpleAdapter : 정적 XML
    
## AddView -> ListView -> RecyclerView
    - 최종적으로는 RecyclerView를 사용한다.
    - 이유:
        1) 개발하기 쉽다. (개발자를 위함)
        2) 성능이 좋다. (고객을 위함)
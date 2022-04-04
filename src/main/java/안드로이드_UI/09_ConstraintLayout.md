# ConstraintLayout
    - RelativeLayout -> 리소스를 많이 차지하기 때문에 사용하지 않도록 권유
        하지만 최근 핸드폰의 성능이 좋아져 크게 문제가 되지는 않는다.
        따라서 RelativeLayout을 사용해도 되지만 더 좋은 ConstraintLayout을 사용하는 것이
        바람직하다.
    - 제약을 통해서 뷰를 배치하는 컨테이너 뷰
    - RelativeLayout에서 할 수 있는 모든 것이 가능
    - 기능이 엄청나게 많다.
    - 반대 방향으로 작용하는 두 개의 제약을 동시에 적용하면 두 제약의 가운데에 배치된다.

## 1. 상대적 위치 배치(RelativeLayout 기능)
    - layout_constraint + 제약이름
    - layout_constraintLeft_toLeftOf
        - B Left_toLeftOf A
            - Left = 속성이 적용되는 뷰의 Left
            - toLeftOf = Of에 올 뷰의 Left
            - B의 왼쪽을 A의 왼쪽에 두겠다.
        - A가 될 수 있는 것들
            - ID로 설정된 뷰들
            - parent
                - B Left_toLeftOf parent

## 2. 여백
    - 해당 방향으로 여백을 두기 위해서는 반드시 그쪽 방향에 제약이 있어야 한다.
    - layout_marginLeft = 100dp
    - layout_constraintLeft_toLeftOf = "parent"
    - 왼쪽으로 마진을 둘 때 왼쪽이 어디에 제약이 걸려있는지 정해져있어야 한다.

## 3. Bias(치우침)
    - layout_constraintHorizontal_bias = 값
    - layout_constraintVertical_bias = 값
    - 값
        - 비율로 설정
        - 1인 경우 100% 치우친다
        - 0.5인 경우 50% 치우친다 -> 변화없음

## 4. 비율로 설정하는 방법 -> LinearLayout Weight
    - layout_constraintHorizontal_weight
    - layout_constraintVertical_weight
    - 가로 세로의 크기는 0dp를 갖고 있어야 한다

## 5. 원형 위치 설정(Circular Positioning)
    - layout_constraintCircle : 기준을 정한다
    - layout_constraintCircleRadius : 두 중심 간의 거리
    - layout_constraintCircleAngle : 각도

## 6. Chain 속성
    - Spread Chain
    - Spread Inside
    - Packed

## 구분
    Right End
    Left Start
    
    - 언어의 특징
        - LTR (Left to Right) 글자를 적는 방향이 왼쪽에서 오른쪽 -> Start = Left, End = Right
        - RTL (Right to LefT) 글자를 적는 방향이 오른쪽에서 왼쪽 -> Start = Right, End = Left
    
    언어에 따라서 방향이 달라지기 때문에 구분해서 사용한다.
    
    
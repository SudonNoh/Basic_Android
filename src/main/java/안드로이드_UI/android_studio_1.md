# 안드로이드 스튜디오(Android studio)

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
package="com.example.fastcampus">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.FastCampus">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
## 용어 설명
    - manifests 폴더: 개요, 안내서, 설계도가 들어 있는 폴더
    - AndoridManifest.xml: 설계도
    - package
        - package는 플레이스토어에 앱을 등록할 때 사용되는 이름이다.
        - 유니크한 값이 되어야 한다.
        - 보통 회사 URL을 거꾸로 작성한다 ex)com.example.fastcampus
    - allowBackup
        - 사용자가 앱을 삭제 후 다시 실행해도 일부의 데이터를 가지고 있는 경우가 있다.
        - 이럴 때 사용되는 기능으로 보통 true 값이다.
    - icon/roundIcon
        - 앱의 아이콘
    - label
        - 아이콘에 달린 라벨
    - supportsRtl
        - RTL 지원 여부
    - theme
        - 기본으로 제공될 테마 설정
        - 보통 사용하지 않음
    - activity
        - 하나의 화면이라고 생각할 수 있다.

## activity : 하나의 화면
    - name
        - activity의 이름으로 불러올 xml을 지정
        - java.com.example.fastcampus.MainActivity
    - exported
        - "true"면 이 activity는 외부로 나갈 수 있다
        - 다른 앱이 이 화면을 호출할 수 있다.
        - 기본적으로 False
        - 사용자가 앱을 켜면 첫 화면을 불러와야 한다. 즉 시스템이 첫 화면을 부른다
        - 따라서 첫 화면은 exported가 "true"값이 와야 한다.
        - 보통 MainActivity / LauncherActivity
    - intent-filter
        - intent 필드 안에만 있는 것만 처리하겠다는 의미
        - action.Main
        - category.LAUNCHER
        - 위 두 가지 요청만 처리
    - 
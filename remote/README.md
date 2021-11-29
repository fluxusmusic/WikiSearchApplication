# 요구사항
• HttpURLConnection, HttpsURLConnection 기반으로 구현한다.
• http 방식이든 https 방식이든, 모두 호출될 수 있도록 작성한다.
• 요청 메서드 타입은 GET, POST, PUT, DELETE를 지원하도록 한다.
• Request Header 값을 설정할 수 있어야 한다.
• Response Data를 어떤 형식의 타입으로도 요청할 수 있어야 한다.
• Request Body 전달 시 어떤 형식으로든 서버에 전달, 요청할 수 있어야 한다.
• API 접속 timeout 시간을 설정할 수 있도록 작성한다.
• jar로 패키징될 수 있도록 gradle 빌드 스크립트도 작성한다.
• 위의 요구 사항에 대해서 테스트 케이스를 작성한다.


## Builds

### Debug build 
• Jar및, kDoc함께 생성 (projectDir/debug/)

### Release
• Proguard 적용

### Gradle Task, exportJar (Optional)
• Jar format 의 library 를 build 한다. 해당 모듈 프로젝트의 release 폴더에 생성되며, kDoc 도 함께 생성된다.

## Usage Guide
• 기본사용은 SimpleDataManager 를 통해 가져온 requester 를 통해 동작을 기본으로 하고있으며
  해당 requester 에 timeout, header, body, query 를 전달하도록 한다.

### Requester
• connect() : 받고자 하는 형태의 데이터를 받기위해 parser 를 전달 하게 되면 해당 포맷으로 변환하여 return 한다.
• setBody() : body 정보를 전달 할때, requestBodyParser 를 함께 전달하게 되면, object 를 body 에 담을 수 있다.

### JsonParser
• JsonParer : toJson : String 과 parsing 하고 자 하는 type을 전달 받아 Object성 생
              fromJson : Object 를 String 으로 변환

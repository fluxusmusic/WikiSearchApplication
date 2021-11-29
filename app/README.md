# 요구사항

검색 상세 페이지: https://en.wikipedia.org/api/rest_v1/page/html/{검색어}
- 요약 정보 API: https://en.wikipedia.org/api/rest_v1/page/summary/{검색어}
- 연관 검색 API: https://en.wikipedia.org/api/rest_v1/page/related/{검색어}
* 요구 사항
  • SwipeRefreshLayout을 사용하여 ListView를 새로 고침하는 pull to refresh ListView 커스텀 뷰를
  구현한다.
  • 검색어를 입력 후 검색을 시도하면 “검색 결과 Activity”를 다음과 같이 구성한다.
  • “요약 정보 API” 를 이용하여 가져온 데이터를 이용하여 다음과 같이 ListView의 header view 를 구성한다
  • “연관 검색 API” 를 이용하여 가져온 데이터를 이용하여 다음과 같이 ListView의 각 항 목을 구성한다.
  • ListView의 header view를 클릭하면 “검색 상세 페이지” URL을 이용하여 WebView를 내장한 Activity를
  새롭게 띄워 해당 웹 페이지를 표시한다.
  • ListView의 header view를 클릭하면 “검색 상세 페이지” URL을 이용하여 WebView를 내장한 Activity를
  새롭게 띄워 해당 웹 페이지를 표시한다.
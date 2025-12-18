# spring-boot-wiremock

## 1. 설명
Spring Boot에서 WireMock을 이용한 Mock API Server 예제이다. 포트는 8081을 사용하고, WireMock은 9091 포트를 사용한다.

## 2. 개발환경

* OpenJDK 21

* spring-boot 4.0.0

* spring-web 4.0.0

* lombok 1.18.38

* org.wiremock 3.13.2

## 3. 실행

### 1) standalone 호출

* URL: `http://localhost:9091/api/standalone`

* Method: `GET`

* Response

```text
This is a standalone server response!
```

### 2) Guitar 목록
`search-guitars-response.json` 값을 response 한다.

* URL: `http://localhost:9091/api/guitars`

* Method: `GET`

* Response

```json
{
	"guitars": [
		{
			"name": "Fender",
			"brand": "펜더",
			"updateDate": "2025-12-18T06:58:55Z"
		},
		{
			"name": "Gibson",
			"brand": "깁슨",
			"updateDate": "2025-12-18T06:58:55Z"
		},
		{
			"name": "PRS",
			"brand": "폴 리드 스미스",
			"updateDate": "2025-12-18T06:58:55Z"
		}
	],
	"totalCount": 3,
	"timestamp": "2025-12-18T06:58:55Z"
}
```

### 3) Guitar 검색
`get-guitar-response.json` 값을 response 한다.

* URL: `http://localhost:9091/api/guitar?name=Gibson`

* Method: `GET`

* Response

```json
{
	"name": "Gibson",
	"status": "active",
	"updateDate": "2025-12-18T06:59:43Z"
}
```

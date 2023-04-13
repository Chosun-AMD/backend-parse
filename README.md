# AMD-Backend Parse

## Description 
> AMD의 Backend 프로젝트이며 MongoDB에 저장된 데이터를 파싱해 Front서버로 전달할 때 사용하는 서버입니다.
> DTO는 우선 임시로 작성했으며 요소는 다음과 같으며 추후 Database값에 어떤 값이 담기느냐에 따라 값은 변동될 수 있습니다.
- fileId (파일 ID)
- fileName (파일 명)
- fileSize (파일 사이즈)
- fileHash (파일 해시)
- isVuln (악성코드인지 여부)


### Server Information
- port : 9001
- http://localhost:9001/parse/getAllData (전체 데이터 전달)

h2-console에 접속해 보면 다음과 같이 DB에 값이 저장되어 있습니다. (추후 MongoDB로 바꿔 진행)(테스트용)
![image](https://user-images.githubusercontent.com/54488922/231762992-4b668102-4724-46d8-b2fc-cf1d976d70dd.png)  
이후 `http://localhost:9001/parse/getAllData`에 접속하게 되면 DB에 저장된 값 전체를 불러오는걸 확인할 수 있습니다.
![image](https://user-images.githubusercontent.com/54488922/231762873-9a251fa3-cca8-4d13-b7b1-ecfdf13da5c0.png)

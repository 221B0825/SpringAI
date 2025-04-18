# 📕SpringAI  
Using Java in 2025  
📌: Spring Boot 기반의 AI 챗봇 및 벡터 데이터 처리 프로젝트  

### 📚 자세한 설명 보기

해당 프로젝트의 구현 과정과 코드 상세 설명은 [티스토리 블로그 포스트](https://eunseoyu.tistory.com/category/%EC%9D%B8%EA%B0%84%20%EC%8B%9C%EB%8C%80%EC%9D%98%20%EB%81%9D%EC%9D%B4%20%EB%8F%84%EB%9E%98%ED%96%88%EB%8B%A4)에서 확인하실 수 있습니다.


[![License](https://img.shields.io/github/license/221b0825/SpringAI)](LICENSE)  
[![Last Commit](https://img.shields.io/github/last-commit/221b0825/SpringAI)](https://github.com/221b0825/SpringAI/commits/main)

---

## 🚀 Introduction

SpringAI는 Spring Boot로 개발된 두 개의 서브 프로젝트를 포함하는 AI 서비스 모노레포입니다.  
**spring_basic**은 간단한 생성형 AI 챗봇 기능을 제공하고, **spring_vectordb**는 PDF를 벡터화하여 검색할 수 있는 시스템입니다.

### 🔹 주요 기능  
- **AI 챗봇 기능 구현**: Spring Boot 기반 생성형 AI 응답 API 구현 
- **PDF 임베딩 및 검색 기능**: Vector DB 기반 정보 검색 기능 제공

---

## 📸 Preview  
### spring_basic 실행 화면
<div align="center"> <img src="https://github.com/user-attachments/assets/ab9d2546-46b2-494f-865c-da7a18983aaf" alt="Project Preview" style="width: 100%; height: auto;"></div>  

### spring_vectordb 실행 화면
<div align="center"> <img src="https://github.com/user-attachments/assets/2ffe08a3-baad-4a6e-a760-954d36693a7b" alt="Project Preview" style="width: 100%; height: auto;"></div>

---

## ✨ Features

- 📂 **spring_basic**  
생성형 AI 응답 기능을 제공하는 챗봇 백엔드  
  - `/ask-ai?prompt=...` : 기본 모델을 이용한 응답 반환  
  - `/ask-ai-options?prompt=...` : 모델 및 파라미터 설정 후 응답 반환

- 🖱️ **spring_vectordb**  
PDF 문서 내용을 벡터화하고 검색 가능한 시스템  
  - PDF → 텍스트 추출 → 임베딩 → 검색 API 제공

---

## 📂 Folder Structure
```plaintext
SpringAI/
├── spring_basic/
│   ├── src/main/java/com/ai/spring_basic/
│   │   ├── ChatService.java
│   │   ├── GenAIController.java
│   │   └── SpringBasicApplication.java
│   ├── src/main/resources/
│   │   └── application.yaml
│   ├── target/
│   │   └── spring_basic-0.0.1-SNAPSHOT.jar
│   └── pom.xml
│
└── spring_vectordb/
    ├── src/main/java/com/example/spring_vectordb/
    │   ├── DataLoader.java
    │   ├── ICSController.java
    │   └── SpringVectordbApplication.java
    ├── src/main/resources/
    │   ├── application.yaml
    │   ├── one_lucky_day.pdf
    │   └── schema.sql
    ├── target/
    │   └── classes/
    └── pom.xml
```
---

## 🛠️ Built With
- **Language**: Java 17  
- **Framework**: Spring Boot 3.4.1  
- **Spring AI**: OpenAI, pgvector, PDF Reader  
- **Database**: PostgreSQL (pgvector)

---

## 📧 Contact
- **Name**: Eunseo Yu  
- **E-mail**: eunseoyu0825@gmail.com  
- **GitHub**: [221B0825](https://github.com/221B0825)  

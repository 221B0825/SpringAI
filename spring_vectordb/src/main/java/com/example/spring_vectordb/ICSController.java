package com.example.spring_vectordb;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ICSController {

    private final ChatModel chatModel;
    private final VectorStore vectorStore;

    private String prompt = """
            이 글의 내용을 요약해줘. 단, 문서에서 찾지 못한다면 너는 답을 모르는 거야.
            "QUESTION: {input}
            "DOCUMENTS: {documents}""";

    public ICSController(ChatModel chatModel, VectorStore vectorStore) {
        this.chatModel = chatModel;
        this.vectorStore = vectorStore;
    }

    @GetMapping("/")
    public String simplify(@RequestParam(value = "question", defaultValue = "이 글의 내용을 요약해줘.")String question) {
        PromptTemplate template = new PromptTemplate(prompt);

        Map<String, Object> promptsParameters = new HashMap<>();
        promptsParameters.put("input", question);
        promptsParameters.put("documents", findSimilardata(question));

        return chatModel.call(template.create(promptsParameters)).getResult().getOutput().getContent();
    }

    private Object findSimilardata(String question) {
        List<Document> documents = vectorStore.similaritySearch(SearchRequest.builder().query(question).topK(3).build());

        return documents.stream().map(document -> document.getContent().toString()).collect(Collectors.joining());
    }
}

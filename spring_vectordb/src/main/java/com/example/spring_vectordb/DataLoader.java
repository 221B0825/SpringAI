package com.example.spring_vectordb;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import java.util.Vector;

@Component
public class DataLoader {
    private final VectorStore vectorStore;

    private final JdbcClient jdbcClient;

    @Value("classpath:/one_lucky_day.pdf")
    private Resource pdfResource;

    public DataLoader(VectorStore vectorStore, JdbcClient jdbcClient) {
        this.vectorStore = vectorStore;
        this.jdbcClient = jdbcClient;
    }

    @PostConstruct
    public void init(){
        Integer count = jdbcClient.sql("select COUNT(*) from vector_store").query(Integer.class).single();

        System.out.println("No of Records in the PG Vector store: " + count);
        if(count == 0){
            System.out.println("Loading pdf in the PG Vector store");
            PdfDocumentReaderConfig config = PdfDocumentReaderConfig.builder()
                    .withPagesPerDocument(1)
                    .build();

            PagePdfDocumentReader reader = new PagePdfDocumentReader(pdfResource, config);

            var textSplitter = new TokenTextSplitter();
            vectorStore.accept(textSplitter.apply(reader.get()));

            System.out.println("Application is ready to Serve the Requests");
        }
    }

}

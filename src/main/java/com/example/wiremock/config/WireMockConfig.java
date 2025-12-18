package com.example.wiremock.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Slf4j
@Configuration
public class WireMockConfig {

    @Value("${wiremock.port}")
    private int wiremockPort;

    @Value("${wiremock.files-directory}")
    private String filesDirectory;

    private WireMockServer wireMockServer;

    @Bean
    public WireMockServer wireMockServer() {
        wireMockServer = new WireMockServer(
                WireMockConfiguration.options()
                        .port(wiremockPort)
                        .usingFilesUnderDirectory(filesDirectory)
                        .globalTemplating(true)
        );

        wireMockServer.start();
        log.info("WireMock server started on port: {}", wiremockPort);
        log.info("Using files from: {}", new File(filesDirectory).getAbsolutePath());

        return wireMockServer;
    }

    @PreDestroy
    public void stopWireMock() {
        if (wireMockServer != null && wireMockServer.isRunning()) {
            wireMockServer.stop();
            log.info("WireMock server stopped");
        }
    }
}
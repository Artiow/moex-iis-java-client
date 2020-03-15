package com.artiow.moex.api.client;

import com.artiow.moex.api.model.schema.Document;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
public class MoexApiClient {

    private final RestTemplate restTemplate;


    private static URI buildUri(String uriString) {
        return buildUri(uriString, Collections.emptyMap());
    }

    private static URI buildUri(String uriString, MultiValueMap<String, String> queryParams) {
        return buildUri(uriString, Collections.emptyMap(), queryParams);
    }

    private static URI buildUri(String uriString, Map<String, String> uriVariables) {
        return UriComponentsBuilder.fromUriString(uriString).encode().build(uriVariables);
    }

    private static URI buildUri(String uriString, Map<String, String> uriVariables, MultiValueMap<String, String> queryParams) {
        return UriComponentsBuilder.fromUriString(uriString).queryParams(queryParams).encode().build(uriVariables);
    }


    private static RequestEntity<Void> buildRequest(MultiValueMap<String, String> headers, String uriString) {
        return buildRequest(headers, uriString, Collections.emptyMap());
    }

    private static RequestEntity<Void> buildRequest(MultiValueMap<String, String> headers, String uriString, MultiValueMap<String, String> queryParams) {
        return buildRequest(headers, uriString, Collections.emptyMap(), queryParams);
    }

    private static RequestEntity<Void> buildRequest(MultiValueMap<String, String> headers, String uriString, Map<String, String> uriVariables) {
        return new RequestEntity<>(headers, HttpMethod.GET, buildUri(uriString, uriVariables));
    }

    private static RequestEntity<Void> buildRequest(MultiValueMap<String, String> headers, String uriString, Map<String, String> uriVariables, MultiValueMap<String, String> queryParams) {
        return new RequestEntity<>(headers, HttpMethod.GET, buildUri(uriString, uriVariables, queryParams));
    }


    public Document request(String uriString) {
        return restTemplate.getForEntity(buildUri(uriString), Document.class).getBody();
    }

    public Document request(String uriString, MultiValueMap<String, String> queryParams) {
        return restTemplate.getForEntity(buildUri(uriString, queryParams), Document.class).getBody();
    }

    public Document request(String uriString, Map<String, String> uriVariables) {
        return restTemplate.getForEntity(buildUri(uriString, uriVariables), Document.class).getBody();
    }

    public Document request(String uriString, Map<String, String> uriVariables, MultiValueMap<String, String> queryParams) {
        return restTemplate.getForEntity(buildUri(uriString, uriVariables, queryParams), Document.class).getBody();
    }

    public Document request(MultiValueMap<String, String> headers, String uriString) {
        return restTemplate.exchange(buildRequest(headers, uriString), Document.class).getBody();
    }

    public Document request(MultiValueMap<String, String> headers, String uriString, MultiValueMap<String, String> queryParams) {
        return restTemplate.exchange(buildRequest(headers, uriString, queryParams), Document.class).getBody();
    }

    public Document request(MultiValueMap<String, String> headers, String uriString, Map<String, String> uriVariables) {
        return restTemplate.exchange(buildRequest(headers, uriString, uriVariables), Document.class).getBody();
    }

    public Document request(MultiValueMap<String, String> headers, String uriString, Map<String, String> uriVariables, MultiValueMap<String, String> queryParams) {
        return restTemplate.exchange(buildRequest(headers, uriString, uriVariables, queryParams), Document.class).getBody();
    }
}

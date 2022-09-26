package com.example.megazoneTraining2.Security.OAuth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping(path = "/oauth2")
public class OAuth2Controller {
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/loginSuccess")
    public String getLoginInfo(OAuth2AuthenticationToken authenticationToken) {
        OAuth2AuthorizedClient client = authorizedClientService
                .loadAuthorizedClient(
                        authenticationToken.getAuthorizedClientRegistrationId(),
                        authenticationToken.getName()
                );
        String userInfoEndpointUri = client.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();
        if (!StringUtils.isEmpty(userInfoEndpointUri)) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());
            HttpEntity entity = new HttpEntity("", httpHeaders);
            ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
            Map userAttribute = response.getBody();
            System.out.println(httpHeaders);
        }
        return "login success";
    }
}

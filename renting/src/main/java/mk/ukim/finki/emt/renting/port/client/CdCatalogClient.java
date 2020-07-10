package mk.ukim.finki.emt.renting.port.client;

import mk.ukim.finki.emt.renting.application.CdCatalog;
import mk.ukim.finki.emt.renting.domain.model.Cd;
import mk.ukim.finki.emt.renting.domain.model.CdId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class CdCatalogClient implements CdCatalog {

    private static final Logger LOGGER = LoggerFactory.getLogger(CdCatalogClient.class);

    private final RestTemplate restTemplate;
    private final String serverUrl;

    CdCatalogClient(@Value("${app.cd-catalog.url}") String serverUrl,
                         @Value("${app.cd-catalog.connect-timeout-ms}") int connectTimeout,
                         @Value("${app.cd-catalog.read-timeout-ms}") int readTimeout) {
        this.serverUrl = serverUrl;
        restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        // Never ever do a remote call without a finite timeout!
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(serverUrl);
    }

    @Override
    public List<Cd> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/cds").build().toUri(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Cd>>() {
                    }).getBody();
        } catch (Exception ex) {
            LOGGER.error("Error retrieving cds", ex);
            return Collections.emptyList();
        }
    }

    @Override
    public Cd findById(CdId id) {
        try {
            return restTemplate.exchange(uri().path("/api/cds/"+id.getId()).build().toUri(), HttpMethod.GET, null,
                    new ParameterizedTypeReference<Cd>() {
                    }).getBody();
        } catch (Exception ex) {
            LOGGER.error("Error retrieving cd by id", ex);
            return null;
        }
    }
}

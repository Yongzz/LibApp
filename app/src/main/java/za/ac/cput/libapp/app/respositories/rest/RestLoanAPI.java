package za.ac.cput.libapp.app.respositories.rest;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.libapp.app.domain.Impl.Loan;
import za.ac.cput.libapp.app.respositories.RestAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015/10/04.
 */
public class RestLoanAPI  implements RestAPI<Loan,Long> {

    final String BASE_URL="http://librarysystem-librarysystem.rhcloud.com/library/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Loan get(Long id) {
        final String url = BASE_URL+"loan/"+id.toString();
        HttpEntity<Loan> requestEntity = new HttpEntity<Loan>(requestHeaders);
        ResponseEntity<Loan> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Loan.class);
        Loan loan = responseEntity.getBody();
        return loan;
    }

    @Override
    public String post(Loan entity) {
        final String url = BASE_URL+"loan/create";
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Loan> httpEntity = new HttpEntity<>(entity,headers);
        String result = rest.postForObject(url, httpEntity, String.class);


/*
        HttpEntity<Loan> requestEntity = new HttpEntity<Loan>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();*/
        return result;
    }

    @Override
    public String put(Loan entity) {
        final String url = BASE_URL+"loan/update/"+entity.getId().toString();
        HttpEntity<Loan> requestEntity = new HttpEntity<Loan>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Loan entity) {
        final String url = BASE_URL+"loan/delete/"+entity.getId().toString();
        HttpEntity<Loan> requestEntity = new HttpEntity<Loan>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Loan> getAll() {
        List<Loan> loans = new ArrayList<>();
        final String url = BASE_URL+"loans/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Loan[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Loan[].class);
        Loan[] results = responseEntity.getBody();

        for (Loan b : results) {
            loans.add(b);
        }
        return loans;
    }
}

package com.escola.doamanha.service.impl;

import com.escola.doamanha.model.Cep;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepServiceImpl implements CepService {

    public Cep getCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        Cep cepInfo = restTemplate.getForObject(url, Cep.class);
        return cepInfo;
    }
}

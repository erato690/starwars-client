package com.starwars.client.proxy;

import com.starwars.client.exception.StarWarsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@Slf4j
@Service
public class StarWarsProxy {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.client.starwars.host}")
    private String host;

    public String getEntityByPage(Integer page,String path){
        UriComponents uri =
                UriComponentsBuilder
                        .fromHttpUrl(host)
                        .path(path)
                        .queryParam("page", page)
                        .build();
        log.info("inicio chamando a api do starwars  com a  url={} pagina={}",uri.toUriString(),page);

        try {
            ResponseEntity<String> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET,null ,  String.class);
            if(response.getStatusCode().is2xxSuccessful() &&  response.hasBody()) {
                return response.getBody();
            }else {
                log.error("api retorno um status diferente de 200 url={} pagina={} httpCode={}",uri.toUriString(),page,response.getStatusCode());
                throw new StarWarsException("Api retorno um status diferente de 200 httpCode="+response.getStatusCode());
            }
        }catch (Exception ex){
            log.error("Erro ao chamar api url={} pagina={} ex={}",uri.toUriString(),page,ex);
            throw  new StarWarsException("Erro ao chamar api", ex);
        }finally {
            log.info("fim chamando a api do starwars  com a url={} pagina={}",uri.toUriString(),page);
        }
    }

    public String getSingleEntityBySearchParam(String param,String path){
        UriComponents uri =
                UriComponentsBuilder
                        .fromHttpUrl(host)
                        .path(path)
                        .queryParam("search",param)
                        .encode()
                        .build();
        log.info("inicio chamando a api do starwars  com a  url={} param={}",uri.toUriString(),param);

        try {
            ResponseEntity<String> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET,null ,  String.class);
            if(response.getStatusCode().is2xxSuccessful() &&  response.hasBody()) {
                return response.getBody();
            }else {
                log.error("api retorno um status diferente de 200 url={} param={} httpCode={}",uri.toUriString(),param,response.getStatusCode());
                throw new StarWarsException("Api retorno um status diferente de 200 httpCode="+response.getStatusCode());
            }
        }catch (Exception ex){
            log.error("Erro ao chamar api url={} param={} ex={}",uri.toUriString(),param,ex);
            throw  new StarWarsException("Erro ao chamar api", ex);
        }finally {
            log.info("fim chamando a api do starwars  com a url={} param={}",uri.toUriString(),param);
        }
    }

    public String getSingleEntityByURL(String url){
        UriComponents uri =
                UriComponentsBuilder
                        .fromHttpUrl(url)
                        .encode()
                        .build();
        log.info("inicio chamando a api do starwars  com a  url={}",url);
        try {
            ResponseEntity<String> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET,null ,  String.class);
            if(response.getStatusCode().is2xxSuccessful() &&  response.hasBody()) {
                return response.getBody();
            }else {
                log.error("api retorno um status diferente de 200 url={} httpCode={}",url,response.getStatusCode());
                throw new StarWarsException("Api retorno um status diferente de 200 httpCode="+response.getStatusCode());
            }
        }catch (Exception ex){
            log.error("Erro ao chamar api url={}  ex={}",url,ex);
            throw  new StarWarsException("Erro ao chamar api", ex);
        }finally {
            log.info("fim chamando a api do starwars  com a url={} ",url);
        }
    }


}

package gt.umg.ventasonline.ws;

import org.codehaus.jackson.map.DeserializationConfig;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gt.umg.ventasonline.entities.Categoria;

/**
 * Created by BYRON TOLEDO on 2/22/2017.
 */

public class VentasOnlineWs {

    private final String urlApi = "http://192.168.0.4:8085/VentasOnlineWS/";
    private MappingJacksonHttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJacksonHttpMessageConverter();
    private RestTemplate restTemplate = new RestTemplate();

    public VentasOnlineWs(){

        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);

        mappingJacksonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        mappingJacksonHttpMessageConverter.getObjectMapper().configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        restTemplate.getMessageConverters().add(mappingJacksonHttpMessageConverter);

    }

    public Categoria[] getCategorias() throws Exception{
        Map<String,String> parameters = new HashMap<>();
        ResponseEntity<Categoria[]> respuesta = restTemplate.getForEntity(urlApi+"api/Categoria/",Categoria[].class,parameters);
        return respuesta.getBody();
    }

}

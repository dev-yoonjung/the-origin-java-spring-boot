package theorigin.javaspringboot.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import theorigin.javaspringboot.client.service.NcpAPIService;

@RestController
@RequestMapping("/ncp-api")
public class NcpAPIController {

    private static final String testIp = "210.57.252.50";
    private final NcpAPIService service;

    public NcpAPIController(@Autowired NcpAPIService service) {
        this.service = service;
    }

    @GetMapping("/geolocation")
    public ResponseEntity<?> getLocationByIp(@RequestParam(value = "ip", defaultValue = testIp) String ip){
        return ResponseEntity.ok(this.service.geoLocation(ip));
    }

}

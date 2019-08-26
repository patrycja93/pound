package com.patrycja.pound.resource;

import com.patrycja.pound.models.Zookeeper;
import com.patrycja.pound.services.ZookeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zookeepers")
public class ZookeeperResource {

    @Autowired
    private ZookeeperService zookeeperService;

    @PostMapping
    public ResponseEntity<String> addZookeeper(@RequestBody Zookeeper zookeeper) {
        return zookeeperService.addZookeeper(zookeeper);
    }

    @GetMapping
    public List<Zookeeper> getZookeepers() {
        return zookeeperService.getZookeepers();
    }
}

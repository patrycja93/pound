package com.patrycja.pound.resource;

import com.patrycja.pound.models.domain.Zookeeper;
import com.patrycja.pound.models.dto.ZookeeperDTO;
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
    public ResponseEntity<String> addZookeeper(@RequestBody ZookeeperDTO zookeeperDTO) {
        return zookeeperService.addZookeeper(zookeeperDTO);
    }

    @GetMapping
    public List<ZookeeperDTO> getZookeepers() {
        return zookeeperService.getZookeepers();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") int id, @RequestBody ZookeeperDTO zookeeperDTO){
        return zookeeperService.updateZookeeper(id, zookeeperDTO);
    }

    /*@DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id){
        return zookeeperService.deleteZookeeper(id);
    }*/
}

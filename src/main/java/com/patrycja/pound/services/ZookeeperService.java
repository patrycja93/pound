package com.patrycja.pound.services;


import com.patrycja.pound.models.Zookeeper;
import com.patrycja.pound.repository.ZookeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ZookeeperService {

    @Autowired
    private ZookeeperRepository zookeeperRepository;

    @Transactional
    public ResponseEntity<String> addZookeeper(Zookeeper zookeeper) {
        zookeeperRepository.save(zookeeper);
        return ResponseEntity.ok("Successfully added zookeeper!");
    }

    @Transactional
    public List<Zookeeper> getZookeepers() {
        return zookeeperRepository.findAll();
    }
}

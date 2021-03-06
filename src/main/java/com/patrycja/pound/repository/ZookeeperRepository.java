package com.patrycja.pound.repository;

import com.patrycja.pound.models.domain.Zookeeper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZookeeperRepository extends JpaRepository<Zookeeper, Integer> {
}

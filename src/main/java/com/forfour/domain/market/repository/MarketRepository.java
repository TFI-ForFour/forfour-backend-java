package com.forfour.domain.market.repository;

import com.forfour.domain.market.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {

    Optional<Market> findById(UUID uuid);
}

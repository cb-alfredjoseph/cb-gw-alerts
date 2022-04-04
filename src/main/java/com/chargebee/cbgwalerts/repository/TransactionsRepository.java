package com.chargebee.cbgwalerts.repository;

import com.chargebee.cbgwalerts.model.DomainAndCount;
import com.chargebee.cbgwalerts.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction,Integer> {
    @Query("select new com.chargebee.cbgwalerts.model.DomainAndCount(ls.domain ,count(t.site_id)) from Transaction t join LiteSite ls on t.site_id =ls.site_id where t.gateway =:gateway and t.payment_method=:payment " +
            "and t.status=:status and t.created_at < :localDateTime group by t.site_id")
    List<DomainAndCount> listDomainAndCount(@Param("gateway") int gw, @Param("payment") int payment,
                                            @Param("status") int status, @Param("localDateTime") LocalDateTime ldt);

}

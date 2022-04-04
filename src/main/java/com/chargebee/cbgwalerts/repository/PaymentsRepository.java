package com.chargebee.cbgwalerts.repository;

import com.chargebee.cbgwalerts.entity.Payment;
import com.chargebee.cbgwalerts.models.DomainAndCountResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentsRepository extends JpaRepository<Payment,Long> {

    @Query("select new com.chargebee.cbgwalerts.models.DomainAndCountResult(ls.domain ,count(p.site_id))"
            +" from Payment p join LiteSites ls on p.site_id =ls.site_id where p.gateway =:gateway and p.payment_method=:payment and p.status=:status and p.created_at < :localDateTime  group by p.site_id")
    List<DomainAndCountResult> listDomainAndCount(@Param("gateway") int gw, @Param("payment") int payment,
                                                  @Param("status") int status,@Param("localDateTime") LocalDateTime ldt);

}

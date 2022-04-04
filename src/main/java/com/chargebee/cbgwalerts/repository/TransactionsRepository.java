package com.chargebee.cbgwalerts.repository;

import com.chargebee.cbgwalerts.models.DomainAndCountResult;
import com.chargebee.cbgwalerts.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Integer> {
    @Query("select new com.chargebee.cbgwalerts.models.DomainAndCountResult(ls.domain ,count(t.site_id)) from Transactions t join LiteSites ls on t.site_id =ls.site_id where t.gateway =:gateway and t.payment_method=:payment " +
            "and t.status=:status and t.created_at < :localDateTime group by t.site_id")
    List<DomainAndCountResult> listDomainAndCount(@Param("gateway") int gw, @Param("payment") int payment,
                                                  @Param("status") int status,@Param("localDateTime") LocalDateTime ldt);

    // @Query("Select " + "from Transactions as t where t.gateway = :gateway and t.payment_method = :payment and t.status = :status group by t.site_id")
//    List<DomainAndCountResult> listDomainAndCount(@Param("gateway") int gw, @Param("payment") int payment,
//                                                  @Param("status") int status);
}



//    EntityManager entityManager = null;
//    TypedQuery<DomainAndCountResultPOJO> query = entityManager.createQuery("Select new com.chargebee.cbgwalerts.entity.DomainAndCountResultPOJO(t.site_id, count(t.site_id))  "
//            + "from Transactions as t group by t.site_id")
//    DomainAndCountResultPOJO result = query.setParameter("",gw);
//    List<DomainAndCountResultPOJO> listdomainAndCount();

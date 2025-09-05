package com.picketlogia.picket.api.reservation.repository;

import com.picketlogia.picket.api.product.model.entity.RoundTime;
import com.picketlogia.picket.api.reservation.model.entity.ReserveDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReserveDetailRepository extends JpaRepository<ReserveDetail, Long> {
    /**
     * 해당 회차에 해당하는 예매 상세 목록을 조회한다.
     * @param roundTime 조회할 회차
     * @return 해당 회차에 해당하는 예매 상세 목록
     */
    List<ReserveDetail> findAllByRoundTime(RoundTime roundTime);
}

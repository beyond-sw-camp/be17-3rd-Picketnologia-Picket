package com.picketlogia.picket.api.product.service;

import com.picketlogia.picket.common.exception.BaseException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.picketlogia.picket.common.model.BaseResponseStatus.OPEN_DATE_OUT_OF_PERFORMANCE_RANGE;

@Component
public class ProductValidator {

    /**
     * 오픈 예정일이 공연 시작일 보다 늦은지 검증한다.
     *
     * @param openDate  오픈 예정일
     * @param startDate 공연 시작일
     * @throws BaseException 오픈 예정일이 공연 시작일보다 느리면 예외 발생
     */
    public void validateOpenDate(LocalDateTime openDate, LocalDate startDate) {

        if (openDate.toLocalDate().isAfter(startDate)) {
            throw BaseException.from(OPEN_DATE_OUT_OF_PERFORMANCE_RANGE);
        }

    }
}

package com.picketlogia.picket.api.review.service;

import com.picketlogia.picket.api.orderdetail.service.OrderDetailService;
import com.picketlogia.picket.api.review.model.dto.ReviewDtoList;
import com.picketlogia.picket.api.review.model.dto.ReviewDtoRegister;
import com.picketlogia.picket.api.review.model.dto.ReviewList;
import com.picketlogia.picket.api.review.model.entity.Review;
import com.picketlogia.picket.api.review.repository.ReviewRepository;
import com.picketlogia.picket.common.exception.BaseException;
import com.picketlogia.picket.common.model.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.lettuce.core.pubsub.PubSubOutput.Type.message;
import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final OrderDetailService orderDetailService;

    public void save(ReviewDtoRegister dto, Long userIdx) {
        if (!orderDetailService.hasPurchasedProduct(userIdx, dto.getProductId())) {
            throw new BaseException("예매자만 리뷰작성이 가능합니다.", BaseResponseStatus.ORDERS_NOT_ORDERED);
        }
        reviewRepository.save(dto.toEntity(userIdx));
    }


    public List<ReviewDtoList> list() {
    List<Review> result = reviewRepository.findAll();

    return result.stream().map(ReviewDtoList::from).toList();
}

    public ReviewList listpaging(Integer page, Integer size) {

        Page<Review> result = reviewRepository.findAll(PageRequest.of(page,size)); // 페이지네이션이 필요하면 사용
//        Slice<Board> result = boardRepository.findAll(PageRequest.of(page,size)); // 페이지네이션이 필요없으면 사용
        Double averageRating = reviewRepository.findAverageRating();

        return ReviewList.from(result, averageRating);
    }

}

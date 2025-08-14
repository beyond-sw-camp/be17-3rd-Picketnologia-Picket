package com.picketlogia.picket.api.review.service;

import com.picketlogia.picket.api.review.model.dto.ReviewDtoList;
import com.picketlogia.picket.api.review.model.dto.ReviewDtoRegister;
import com.picketlogia.picket.api.review.model.dto.ReviewList;
import com.picketlogia.picket.api.review.model.entity.Review;
import com.picketlogia.picket.api.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public void save(ReviewDtoRegister dto) {
    reviewRepository.save(dto.toEntity());
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

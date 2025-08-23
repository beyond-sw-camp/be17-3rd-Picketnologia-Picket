package com.picketlogia.picket.api.region.RegionController;

import com.picketlogia.picket.api.region.model.RegionList;
import com.picketlogia.picket.api.region.service.RegionService;
import com.picketlogia.picket.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping()
    public ResponseEntity<BaseResponse<RegionList>> getRegions() {
        RegionList regions = regionService.findAll();

        return ResponseEntity.ok(BaseResponse.success(regions));
    }
}
package com.survey.domain.services.detailResponse;

import com.survey.persistence.entities.DetailResponse;

import java.util.List;
import java.util.Optional;

public interface IDetailResponse {
    List<DetailResponse> findAll();
    Optional<DetailResponse> findById(Long id);
    DetailResponse save(DetailResponse detailResponse);
    Optional<DetailResponse> update(Long id, DetailResponse detailResponse);
    Optional<DetailResponse> delete(Long id);
}

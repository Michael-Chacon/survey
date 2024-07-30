package com.survey.domain.services.responseOption;

import com.survey.persistence.entities.ResponsOption;
import java.util.List;
import java.util.Optional;

public interface IResponseOption {
    List<ResponsOption> findAll();
    Optional<ResponsOption> findById(Long id);
    ResponsOption save(ResponsOption responseOption);
    Optional<ResponsOption> update(Long id, ResponsOption responseOption);
    Optional<ResponsOption> delete(Long id);
}

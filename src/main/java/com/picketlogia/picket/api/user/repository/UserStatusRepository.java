package com.picketlogia.picket.api.user.repository;

import com.picketlogia.picket.api.user.model.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusRepository extends JpaRepository<UserStatus, Integer> {
}

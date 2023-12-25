package com.rungroup.web.services;

import com.rungroup.web.services.dto.ClubDto;

import java.util.List;

public interface ClubServices {
    List<ClubDto> findAllClubs();
}

package com.rungroup.web.services.impl;

import com.rungroup.web.services.dto.ClubDto;
import com.rungroup.web.models.Club;
import com.rungroup.web.repository.ClubRepository;
import com.rungroup.web.services.ClubServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServicesInpl implements ClubServices {
   private ClubRepository clubRepository;

   @Autowired
    public ClubServicesInpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto(Club club){
       ClubDto clubDto = ClubDto.builder()
               .id(club.getId())
               .title(club.getTitle())
               .photoUrl(club.getPhotoUrl())
               .content(club.getContent())
               .createdOn(club.getCreatedOn())
               .udateOn(club.getUdateOn())
               .build();
       return clubDto;
    }
}

package springboot.mission.basic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springboot.mission.basic.controller.dto.AreaDTO;
import springboot.mission.basic.entity.AreaEntity;
import springboot.mission.basic.repository.AreaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    private static final Logger logger = LoggerFactory.getLogger(AreaService.class);
    private final AreaRepository areaRepository;

    public AreaService(@Autowired AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public AreaDTO createArea(AreaDTO areaDto){
        AreaEntity areaEntity = new AreaEntity();
        areaEntity.setRegionMajor(areaDto.getRegionMajor());
        areaEntity.setRegionMinor(areaDto.getRegionMinor());
        areaEntity.setRegionPatch(areaDto.getRegionPatch());
        areaEntity.setLatitude(areaDto.getLatitude());
        areaEntity.setLongitude(areaDto.getLongitude());
        areaEntity = areaRepository.save(areaEntity);

        return new AreaDTO(areaEntity);
    }

    public AreaDTO readArea(Long id) {
        Optional<AreaEntity> areaEntityOptional = areaRepository.findById(id);
        if (areaEntityOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new AreaDTO(areaEntityOptional.get());
    }

    public List<AreaDTO> readAreaAll(){
        List<AreaDTO> areaDtoList = new ArrayList<>();
        areaRepository.findAll().forEach(areaEntity -> areaDtoList.add(new AreaDTO(areaEntity)));
        return areaDtoList;
    }

}

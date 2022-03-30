package springboot.mission.basic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springboot.mission.basic.controller.dto.AreaDto;
import springboot.mission.basic.entity.AreaEntity;
import springboot.mission.basic.repository.AreaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    private static final Logger logger = LoggerFactory.getLogger(AreaService.class);
    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public AreaDto createArea(AreaDto areaDto){
        AreaEntity areaEntity = new AreaEntity();
        areaEntity.setRegionMajor(areaDto.getRegionMajor());
        areaEntity.setRegionMinor(areaDto.getRegionMinor());
        areaEntity.setRegionPatch(areaDto.getRegionPatch());
        areaEntity.setLatitude(areaDto.getLatitude());
        areaEntity.setLongitude(areaDto.getLongitude());
        areaEntity = areaRepository.save(areaEntity);

        return new AreaDto(areaEntity);
    }

    public AreaDto readArea(Long id) {
        Optional<AreaEntity> areaEntityOptional = areaRepository.findById(id);
        if (areaEntityOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new AreaDto(areaEntityOptional.get());
    }

    public List<AreaDto> readAreaAll(){
        List<AreaDto> areaDtoList = new ArrayList<>();
        areaRepository.findAll().forEach(areaEntity -> areaDtoList.add(new AreaDto(areaEntity)));
        return areaDtoList;
    }

    public AreaDto getNearestPlace(Double latitude, Double longitude) {
        Double[] myLocation = {latitude, longitude};
        List<AreaDto> areaDtoList = new ArrayList<>();
        areaRepository.findAll().forEach(areaEntity -> areaDtoList.add(new AreaDto(areaEntity)));
        double dis = (double) -1;
        AreaDto result = null;
        for (AreaDto areaDto : areaDtoList) {
            Double distance = distance(myLocation, new Double[]{areaDto.getLatitude(), areaDto.getLongitude()});
            if (dis == -1 || distance < dis) {
                dis = distance;
                result = areaDto;
            }
        }
        return result;
    }

    private Double distance(Double[] myLocation, Double[] compare) {
        return Math.sqrt(Math.pow((myLocation[0] - compare[0]), 2) + Math.pow((myLocation[1] - compare[1]), 2));
    }
}

package model.converter;

import model.dao.SkillsDao;
import model.dto.SkillsDto;

public class SkillsConverter {
    public SkillsDto convert(SkillsDao skillDao){
        SkillsDto skillDto = new SkillsDto();
        skillDto.setId(skillDao.getId());
        skillDto.setRank(skillDao.getRank());
        skillDto.setSyntax(skillDao.getSyntax());
        return skillDto;
    }


    public SkillsDao convert(SkillsDto skillDto){
        SkillsDao skillDao = new SkillsDao();
        skillDao.setId(skillDto.getId());
        skillDao.setRank(skillDto.getRank());
        skillDao.setSyntax(skillDto.getSyntax());
        return skillDao;
    }
}

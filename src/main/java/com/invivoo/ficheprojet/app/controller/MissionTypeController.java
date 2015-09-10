package com.invivoo.ficheprojet.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invivoo.ficheprojet.app.domain.MissionType;
import com.invivoo.ficheprojet.app.service.MissionTypeService;

@RestController
@RequestMapping("/api/mission-types")
public class MissionTypeController {

    @Autowired
    private MissionTypeService missionTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<MissionType> list() {
	return missionTypeService.list();
    }

    @RequestMapping(method = RequestMethod.POST)
    public MissionType create(@RequestBody @Valid MissionType missionType) {
	return missionTypeService.save(missionType);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public MissionType get(@PathVariable Long id) {
	return missionTypeService.read(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public MissionType update(@Valid @RequestBody MissionType missionType) {
	return missionTypeService.save(missionType);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable Long id) {
	missionTypeService.delete(id);
    }

}

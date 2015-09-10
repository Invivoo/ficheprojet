package com.invivoo.ficheprojet.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invivoo.ficheprojet.app.domain.Function;
import com.invivoo.ficheprojet.app.service.FunctionService;

@RestController
@RequestMapping("/api/functions")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Function> list() {
	return functionService.list();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Function create(@RequestBody @Valid Function function) {
	return functionService.save(function);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Function get(@PathVariable Long id) {
	return functionService.read(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Function update(@Valid @RequestBody Function function) {
	return functionService.save(function);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable Long id) {
	functionService.delete(id);
    }

}

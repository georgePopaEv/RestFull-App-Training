package com.RestFull.example.RestfullWebservices.filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //I want to show to customer only filed1 and field2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("value1", "value2" , "value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.
                filterOutAllExcept("field1", "field2");     // se customizeaza filtrul
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter); // se creaza filtrul filter adus din clasa SomeBean ... id-ul fiind acolo
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);    //se Creeaza o noua grupare de resurse care mai apoi se si afiseaza
        mapping.setFilters(filters);        // se seteaza acel filtru pentru gruparea noastra
        return mapping;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveListSomeBean(){
        return Arrays.asList(new SomeBean("value1", "value2" , "value3"),
                new SomeBean("value11", "value21" , "value31"));
    }
}
